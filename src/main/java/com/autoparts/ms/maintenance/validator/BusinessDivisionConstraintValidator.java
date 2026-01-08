/**
 * 
 */
package com.autoparts.ms.maintenance.validator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.autoparts.ms.maintenance.constants.BusinessDivision;

/**
 * @author sosseres
 *
 */
public class BusinessDivisionConstraintValidator implements ConstraintValidator<BusinessDivisionConstraint, String>{
	
	private static List<String> options = Arrays.stream(BusinessDivision.values())
			.map(status -> status.getValue())
			.collect(Collectors.toList());
	
	/**
	 * 
	 */
	private BusinessDivisionConstraintValidator() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		return options.contains(value) ? true: false;
		
	}
	
//	public static void main(String[] args) {
		
//		System.out.println(options.toString());
//		
//		System.out.println( LoginOption.class.getDeclaredFields().length);
//		
//		Field[] fs = LoginOption.class.getDeclaredFields();
//		Field f;
//		for(int i = 0; i < fs.length; i++) {
//			f = fs[i];
//			
//			if(Modifier.isPublic(f.getModifiers()) && Modifier.isStatic(f.getModifiers()) && Modifier.isFinal(f.getModifiers())) {
//				try {
////					System.out.println(f.getModifiers() + ", " + Modifier.isPrivate(f.getModifiers()));
//					System.out.println( f.get(LoginOption.class.getClass())  );
//				} catch (IllegalArgumentException | IllegalAccessException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}	
//		}
//	
		/**
		 * Set<String> statusCodes = Arrays.stream(Status.values())
                               .map(Status::getCode)
                               .collect(Collectors.toSet());

		 */

//		List<String> ss = Arrays.stream(PartyCode.values()).map(status -> status.getValue()).collect(Collectors.toList());
//		System.out.println(ss.toString());
////		
//		
//	}

}

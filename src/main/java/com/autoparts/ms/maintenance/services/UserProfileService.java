/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.autoparts.common.constants.Common;
import com.autoparts.core.exception.ApplicationException;
import com.autoparts.core.utils.HashUtils;
import com.autoparts.core.utils.StringUtils;
import com.autoparts.jwt.AuthenticationConfig;
import com.autoparts.ms.maintenance.constants.MaintenanceResponseReason;
import com.autoparts.ms.maintenance.constants.UserStatus;
import com.autoparts.ms.maintenance.repository.UserProfileRepository;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileCreateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileVO;

/**
 * @author sosseres
 *
 */
@Service
@Validated
public class UserProfileService {
	
	private static Logger log = LoggerFactory.getLogger(UserProfileService.class.getName());

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	
	/**
	 * 
	 */
	public UserProfileService() {
		// TODO Auto-generated constructor stub
	}
	
	public String create(UserProfileCreateVO vo) throws Exception {
		String id = StringUtils.generateRandomId();
		String pw = StringUtils.generateRandomAlphanumeric(10);
		
		userProfileRepository.create(
				id, 
				vo.getLoginId(), 
				HashUtils.hashing(pw, HashUtils.SHA_256),
				System.currentTimeMillis() + AuthenticationConfig.passwordResetValidity,
				vo.getFirstName(), 
				vo.getLastName(), 
				vo.getMobileNumber(), 
				vo.getEmail(), 
				vo.getCompanyId(), 
				UserStatus.PASSWORD_RESET_REQUIRE.getValue(), 
				new Date(), 
				Common.SYSTEM_USER);
		
		log.debug("New user profile is creatd. {}", pw);
		
		return id;
	}
	
	public UserProfileVO findById(String id) throws Exception {
		UserProfileVO vo = userProfileRepository.findById(id);
		
		if(vo == null) {
			throw new ApplicationException(MaintenanceResponseReason.USER_NOT_FOUND);	
		}
		else {
			return vo;
		}
	}
	
	public void update(UserProfileUpdateVO vo) throws Exception {
		
		if(userProfileRepository.findById(vo.getId()) == null){
			throw new ApplicationException(MaintenanceResponseReason.USER_NOT_FOUND);	
		}
		else {
			userProfileRepository.update(vo.getId(), vo.getFirstName(), vo.getLastName(), vo.getEmail(), new Date(), Common.SYSTEM_USER);
		}
	}
	
	public List<UserProfileListVO> findAllUserProfile(@NotBlank String companyId, @Min(1) int page, @Min(1) int pageSize) throws Exception {
		
		return userProfileRepository.findAllUserProfile(companyId, (page - 1) * pageSize, pageSize);
		
	}
	
//	public void deleteUser(String id) throws Exception {
//		if(userProfileEntity.findUserById(id) == null) {
//			throw new ApplicationException(UserProfileResponseStatus.USER_NOT_FOUND);	
//		}
//		else {
//			userProfileEntity.delete(id);
//		}
//	}
//	
//	public void deactivate(String id) throws Exception {
//		this.updateUserStatus(id, UserStatus.DEACTIVATE);
//	}
//	
//	public void activate(String id) throws Exception {
//		this.updateUserStatus(id, UserStatus.ACTIVE);
//	}

	
//	private void updateUserStatus(String id, String status) throws Exception {
//		
//		UserProfileUpdateVO vo = new UserProfileUpdateVO();
//		vo.setId(id);
//		vo.setStatusId(status);
//		vo.setUpdated(new Date());
//		vo.setUpdatedBy(Common.SYSTEM_USER);
//		
//		userProfileEntity.update(vo);
//		
//	}
	
//	private void sendMessageToKafkaTopic(String topic, Object obj) throws JsonProcessingException {
//		
//		String msg = objectMapper.writeValueAsString(obj);
//		
//		kafkaTemplate.send(topic, msg);
//		kafkaTemplate.flush();
//		
//        log.debug("message sent to topic: {}, {}", topic, msg);
//	}


}

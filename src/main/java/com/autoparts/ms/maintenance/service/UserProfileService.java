/**
 * 
 */
package com.autoparts.ms.maintenance.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoparts.common.constants.Common;
import com.autoparts.common.constants.Reason;
import com.autoparts.common.constants.UserStatus;
import com.autoparts.core.ApplicationParameter;
import com.autoparts.core.exception.ApplicationException;
import com.autoparts.ms.maintenance.repository.UserProfileEntity;
import com.autoparts.ms.maintenance.vo.user.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileVO;

/**
 * @author sosseres
 *
 */
@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileEntity userProfileEntity;
	

	/**
	 * 
	 */
	public UserProfileService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<UserProfileListVO> findAllUser(String companyId, int page) throws Exception{
		
		List<UserProfileListVO> lst = userProfileEntity.findAllUser(companyId, page, ApplicationParameter.pageSize);
		
		if(lst == null || lst.size() == 0) {
			throw new ApplicationException(Reason.USER_NOT_FOUND.name());
		}
		else {
			return lst;
		}
		
	}
	

	public List<UserProfileListVO> findUserByFirstname(String firstName, String companyId, int page) throws Exception{
		
		List<UserProfileListVO> lst = userProfileEntity.findUserByFirstname(firstName, companyId, page, ApplicationParameter.pageSize);
		
		if(lst == null || lst.size() == 0) {
			throw new ApplicationException(Reason.USER_NOT_FOUND.name());
		}
		else{
			return lst;
		}
	}
	
	public UserProfileVO findUserById(String id) throws Exception {
		UserProfileVO rst = userProfileEntity.findUserById(id);
		
		if(rst == null) {
			throw new ApplicationException(Reason.USER_NOT_FOUND.name());	
		}
		else {
			return rst;
		}
	}
	
	
	public void updateUser(UserProfileUpdateVO vo) throws Exception {
		
		if(userProfileEntity.findUserById(vo.getId()) == null) {
			throw new ApplicationException(Reason.USER_NOT_FOUND.name());	
		}
		else {
			vo.setUpdated(new Date());
			vo.setUpdatedBy(Common.SYSTEM_USER);
			
			userProfileEntity.update(vo);
		}
	}
	
	public void deleteUser(String id) throws Exception {
		if(userProfileEntity.findUserById(id) == null) {
			throw new ApplicationException(Reason.USER_NOT_FOUND.name());	
		}
		else {
			userProfileEntity.delete(id);
		}
	}
	
	public void deactivate(String id) throws Exception {
		this.updateUserStatus(id, UserStatus.DORMANT);
	}
	
	public void activate(String id) throws Exception {
		this.updateUserStatus(id, UserStatus.ACTIVE);
	}

	
	private void updateUserStatus(String id, String status) throws Exception {
		
		UserProfileUpdateVO vo = new UserProfileUpdateVO();
		vo.setId(id);
		vo.setStatus(status);
		vo.setUpdated(new Date());
		vo.setUpdatedBy(Common.SYSTEM_USER);
		
		userProfileEntity.update(vo);
		
	}


}

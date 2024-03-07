/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autoparts.core.entity.BaseEntity;
import com.autoparts.core.entity.EntityException;
import com.autoparts.ms.maintenance.vo.user.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.user.UserProfileVO;

/**
 * @author sosseres
 *
 */
@Repository
public class UserProfileEntity extends BaseEntity{

	/**
	 * 
	 */
	public UserProfileEntity(@Qualifier("apdbEM") EntityManager em) {
		// TODO Auto-generated constructor stub
		this.setEntityManager(em);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public UserProfileVO findUserById(String id) throws EntityException {
		UserProfileVO vo = new UserProfileVO();
		vo.setId(id);
		
		return getSingleResult("USER#ID#S", vo);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<UserProfileListVO> findAllUser(String companyId, int page, int pageSize) throws EntityException{
		UserProfileListVO vo = new UserProfileListVO();
		vo.setCompanyId(companyId);
		vo.setPagination(page, pageSize);
		
		return executeQuery("USER#ALL#S", vo);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<UserProfileListVO> findUserByFirstname(String firstName, String companyId, int page, int pageSize) throws EntityException{
		UserProfileListVO vo = new UserProfileListVO();
		vo.setCompanyId(companyId);
		vo.setFirstName(firstName);
		vo.setPagination(page, pageSize);
		
		return executeQuery("USER#FIRST_NM#S", vo);
	}
	
	
	@Transactional
	public int update(UserProfileUpdateVO vo) throws EntityException {
		return execute("USER#U", vo);
		
	}
	
	@Transactional
	public int delete(String id) throws EntityException {
		UserProfileVO vo = new UserProfileVO();
		vo.setId(id);
		
		return execute("USER#D", vo);
	}

}

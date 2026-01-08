/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autoparts.core.entity.annotation.BindVariable;
import com.autoparts.core.entity.annotation.NativeQuery;
import com.autoparts.core.entity.annotation.NativeQueryRepository;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileListVO;
import com.autoparts.ms.maintenance.vo.userprofile.UserProfileVO;

/**
 * @author sosseres
 *
 */
@NativeQueryRepository(factoryBean = PrimaryRepositoryFactoryBean.class)
public interface UserProfileRepository {

	/**
	 * 
	 */
	
	@Transactional
	@NativeQuery(modifying = true, value = """
			INSERT INTO T_USER (ID, LOGIN_ID, PASSWORD, RESET_EXPIRY, FIRST_NAME, LAST_NAME, MOBILE_NUM, EMAIL, COMPANY_ID, STATUS_ID, IS_DEL, CREATED, CREATED_BY)
			VALUES (:id, :loginId, :password, :resetExpiry, :firstName, :lastName, :mobileNumber, :email, :companyId, :status, 'N', :created, :createdBy)
			""")
	public int create(
			@BindVariable String id,
			@BindVariable String loginId,
			@BindVariable String password,
			@BindVariable long resetExpiry,
			@BindVariable String firstName,
			@BindVariable String lastName,
			@BindVariable String mobileNumber,
			@BindVariable String email,
			@BindVariable String companyId,
			@BindVariable String status,
			@BindVariable Date created,
			@BindVariable String createdBy);
	
	
	@Transactional
	@NativeQuery(modifying = true, value = """
			UPDATE T_USER SET 
				UPDATED = :updated,
				UPDATED_BY = :updatedBy,
				FIRST_NAME = CASE WHEN :firstName IS NULL THEN FIRST_NAME ELSE :firstName END,
				LAST_NAME = CASE WHEN :lastName IS NULL THEN LAST_NAME ELSE :lastName END,
				EMAIL = CASE WHEN :email IS NULL THEN EMAIL ELSE :email END
				WHERE ID = :id
			""")
	public int update(
			@BindVariable String id,
			@BindVariable String firstName,
			@BindVariable String lastName,
			@BindVariable String email,
			@BindVariable Date updated,
			@BindVariable String updatedBy);
	
	

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@NativeQuery("""
			SELECT u.ID, u.FIRST_NAME, u.LAST_NAME, u.MOBILE_NUM, u.EMAIL, u.COMPANY_ID, u.STATUS_ID
			FROM T_USER u
			WHERE u.ID = :id 
			AND u.IS_DEL = 'N'
			""")
	public UserProfileVO findById(@BindVariable String id);
	
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@NativeQuery("""
			SELECT ROW_NUMBER() OVER() AS ROWNUM, CEIL(COUNT(u.ID) OVER() / :pageSize) AS TOTAL_PAGE,
					u.ID, u.FIRST_NAME, u.LAST_NAME, u.MOBILE_NUM, u.EMAIL, u.COMPANY_ID, u.STATUS_ID
			FROM T_USER u
			WHERE u.COMPANY_ID = :companyId 
			LIMIT :pageSize OFFSET :offset
			""")
	public List<UserProfileListVO> findAllUserProfile(@BindVariable String companyId, @BindVariable int offset, @BindVariable int pageSize);


}

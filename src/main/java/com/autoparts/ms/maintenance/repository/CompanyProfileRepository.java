/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import java.util.Date;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autoparts.core.entity.annotation.BindVariable;
import com.autoparts.core.entity.annotation.NativeQuery;
import com.autoparts.core.entity.annotation.NativeQueryRepository;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileVO;

/**
 * @author sosseres
 *
 */
@NativeQueryRepository(factoryBean = PrimaryRepositoryFactoryBean.class)
public interface CompanyProfileRepository {
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	@NativeQuery("""
			SELECT COUNT(c.ID)
			FROM T_COMPANY c
			WHERE c.BRN = UPPER(:brn)
			AND c.STATUS_ID = 'ACTV'
			AND c.IS_DEL = 'N'
			""")
	public int findRegisteredCompany(@BindVariable String brn);
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	@NativeQuery("""
			SELECT 
				c.ID, c.NAME, c.BRN, c.ADDR_LINE_1, c.ADDR_LINE_2, c.ADDR_LINE_3, 
				c.POSTCODE, st.NAME STATE, ctry.NAME COUNTRY, c.CONTACT_NUM, c.PARTY_CD, c.IS_SELLER_ENABLED
			FROM T_COMPANY c
			INNER JOIN T_MT_STATE st ON c.MT_STATE_ID = st.CD
			INNER JOIN T_MT_CTRY ctry ON c.MT_CTRY_ID = ctry.CD
			WHERE c.ID = :id 
			AND c.STATUS_ID = 'ACTV'
			AND c.IS_DEL = 'N'
			""")	
	public CompanyProfileVO findById(@BindVariable String id);

	@Transactional
	@NativeQuery(modifying = true, value = """
			INSERT INTO T_COMPANY 
				(ID, NAME, BRN, PARTY_CD, CONTACT_NUM, ADDR_LINE_1, ADDR_LINE_2, ADDR_LINE_3, POSTCODE, 
				MT_STATE_ID, MT_CTRY_ID, DIVISION, STATUS_ID, IS_DEL, CREATED, CREATED_BY)
			VALUES (:id, UPPER(:name), UPPER(:businessRegistrationNumber), :partyCode, :contactNumber, :addressLine1, :addressLine2, :addressLine3, 
				:postcode, :stateId, :countryId, :businessDivision, :statusId, 'N', :created, :createdBy)
			""")
	public int create(
			@BindVariable String id,
			@BindVariable String name,
			@BindVariable String businessRegistrationNumber,
			@BindVariable String partyCode,
			@BindVariable String contactNumber,
			@BindVariable String addressLine1,
			@BindVariable String addressLine2,
			@BindVariable String addressLine3,
			@BindVariable String postcode,
			@BindVariable String stateId,
			@BindVariable String countryId,
			@BindVariable String businessDivision,
			@BindVariable String statusId,
			@BindVariable Date created,
			@BindVariable String createdBy);
	
	@Transactional
	@NativeQuery(modifying = true, value = """
			UPDATE T_COMPANY SET 
				UPDATED = :updated,
				UPDATED_BY = :updatedBy,
				CONTACT_NUM = CASE WHEN :contactNumber IS NULL THEN CONTACT_NUM ELSE :contactNumber END,
				NAME = CASE WHEN :name IS NULL THEN NAME ELSE :name END,
				ADDR_LINE_1 = CASE WHEN :addressLine1 IS NULL THEN ADDR_LINE_1 ELSE :addressLine1 END,
				ADDR_LINE_2 = CASE WHEN :addressLine2 IS NULL THEN ADDR_LINE_2 ELSE :addressLine2 END,
				ADDR_LINE_3 = CASE WHEN :addressLine3 IS NULL THEN ADDR_LINE_3 ELSE :addressLine3 END,
				POSTCODE = CASE WHEN :postcode IS NULL THEN POSTCODE ELSE :postcode END,
				MT_STATE_ID = CASE WHEN :stateId IS NULL THEN MT_STATE_ID ELSE :stateId END, 
				MT_CTRY_ID = CASE WHEN :countryId IS NULL THEN MT_CTRY_ID ELSE :countryId END
			WHERE ID = :id
			""")
	public int update(
			@BindVariable String id,
			@BindVariable String name,
			@BindVariable String contactNumber,
			@BindVariable String addressLine1,
			@BindVariable String addressLine2,
			@BindVariable String addressLine3,
			@BindVariable String postcode,
			@BindVariable String stateId,
			@BindVariable String countryId,
			@BindVariable Date updated,
			@BindVariable String updatedBy);
	

}

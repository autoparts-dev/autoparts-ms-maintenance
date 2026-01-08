package com.autoparts.ms.maintenance.services;

import java.util.Date;
//import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.autoparts.common.constants.Common;
//import com.autoparts.core.entity.Action;
import com.autoparts.core.exception.ApplicationException;
import com.autoparts.core.utils.StringUtils;
import com.autoparts.ms.maintenance.constants.MaintenanceResponseReason;
import com.autoparts.ms.maintenance.constants.CompanyStatus;
import com.autoparts.ms.maintenance.repository.CompanyProfileRepository;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileCreateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileUpdateVO;
import com.autoparts.ms.maintenance.vo.companyprofile.CompanyProfileVO;

@Service
@Validated
public class CompanyProfileService {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileService.class.getName());
	
	@Autowired
	private CompanyProfileRepository companyProfileRepository;
	
	public CompanyProfileService() {
		// TODO Auto-generated constructor stub
	}
	
	public CompanyProfileVO findById(String id) throws Exception   {
		
		CompanyProfileVO vo = companyProfileRepository.findById(id);
		
		if(vo == null) {
			log.warn("Reason: {}", MaintenanceResponseReason.COMPANY_NOT_FOUND);
			throw new ApplicationException(MaintenanceResponseReason.COMPANY_NOT_FOUND);
		}
		else {
			return vo;
		}
	}
	
	public String create(@Valid CompanyProfileCreateVO vo) throws Exception {
		log.debug("start to create company");
		
		String id = null;
		
		if(companyProfileRepository.findRegisteredCompany(vo.getBusinessRegistrationNumber()) > 0) {
			throw new ApplicationException(MaintenanceResponseReason.COMPANY_DUPLICATE_ERROR, vo.getName(), vo.getBusinessRegistrationNumber());
		}
		else {
			id = StringUtils.generateRandomId();

			companyProfileRepository.create(
					id, 
					vo.getName(), 
					vo.getBusinessRegistrationNumber(), 
					vo.getPartyCode(), 
					vo.getContactNumber(),
					vo.getAddressLine1(), 
					vo.getAddressLine2(), 
					vo.getAddressLine3(), 
					vo.getPostcode(), 
					vo.getStateId(), 
					vo.getCountryId(), 
					vo.getBusinessDivision(),
					CompanyStatus.ACTIVE.getValue(),
					new Date(), 
					Common.SYSTEM_USER);
			
		}
		
		log.debug("compamy is created");
		return id;
	}
	
	public void update(CompanyProfileUpdateVO vo) throws Exception {
		if(companyProfileRepository.findById(vo.getId()) == null) {
			throw new ApplicationException(MaintenanceResponseReason.COMPANY_NOT_FOUND);
		}else {
			companyProfileRepository.update(
					vo.getId(), 
					vo.getName(), 
					vo.getContactNumber(), 
					vo.getAddressLine1(), 
					vo.getAddressLine2(), 
					vo.getAddressLine3(), 
					vo.getPostcode(), 
					vo.getStateId(), 
					vo.getCountryId(), 
					new Date(), 
					Common.SYSTEM_USER);
		}
	}
	
	
	/**
	 * 
	 * @param id
	 * @throws Exception
	 */
//	public void deleteCompany(String id) throws Exception{
//		CompanyUpdateVO vo = new CompanyUpdateVO();
//		vo.setId(id);
//		vo.setUpdated(new Date());
//		vo.setUpdatedBy(Common.SYSTEM_USER);
//		vo.setStatusId(CompanyStatus.DELETED);
//		vo.setDelete("Y");
//		
//		int r = companyProfileEntity.update(vo);
//		
//		log.debug("perform removeCompany= {}", r);
//			
//	}
	
	

}

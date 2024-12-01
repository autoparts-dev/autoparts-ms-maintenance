package com.autoparts.ms.maintenance.services;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoparts.common.ApplicationParameter;
import com.autoparts.common.constants.Common;
import com.autoparts.common.web.constants.Reason;
import com.autoparts.core.exception.ApplicationException;
import com.autoparts.core.utils.StringUtils;
import com.autoparts.ms.maintenance.repository.CompanyProfileEntity;
import com.autoparts.ms.maintenance.vo.CompanyCreateVO;
import com.autoparts.ms.maintenance.vo.CompanyListVO;
import com.autoparts.ms.maintenance.vo.CompanyProfileVO;
import com.autoparts.ms.maintenance.vo.CompanyUpdateVO;

@Service
public class CompanyProfileService {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileService.class.getName());
	
	@Autowired
	private CompanyProfileEntity companyProfileEntity;
	
	@Autowired
	private ApplicationParameter applicationParameter;
	
	
	public CompanyProfileService() {
		// TODO Auto-generated constructor stub
	}
	
	public CompanyProfileVO findCompanyById(String id) throws Exception   {
		
		CompanyProfileVO vo = companyProfileEntity.findCompanyById(id);
		
		if(vo == null) {
			log.warn("Reason: " + Reason.COMPANY_NOT_FOUND);
			throw new ApplicationException(Reason.COMPANY_NOT_FOUND);
		}
		else {
			return vo;
		}
	}
	
	
	public List<CompanyListVO> findCompanyByName(String name, int page) throws Exception {
		
		List<CompanyListVO> lst = companyProfileEntity.findCompanyByName(name, (page == 0 ? 1 : page), applicationParameter.pageSize);
		
		if(lst == null || lst.size() == 0) {
			throw new ApplicationException(Reason.COMPANY_NOT_FOUND);
		}
		else {
			return lst;
		}
		
	}
	
	public String createCompany(CompanyCreateVO vo) throws Exception {
		String id = null;
		
//		if(companyProfileEntity.findCompanyByBRN(brn) != null) {
//			throw new ApplicationException(Reason.DUPLICATE_BRN);
//		}
		
		if(companyProfileEntity.findExistCompany(vo.getName(), vo.getBusinessRegistrationNumber()) != null) {
			throw new ApplicationException(Reason.COMPANY_DUPLICATE_ERROR, vo.getName().toUpperCase());
		}
		else {
			id = StringUtils.generateRandomId();
			
			vo.setCreated(new Date());
			vo.setCreatedBy(Common.SYSTEM_USER);
			vo.setId(id);
			vo.setStatus("ACTV");
			
			companyProfileEntity.create(vo);
		}
		
		return id;
	}
	
	public void updateCompany(CompanyUpdateVO vo) throws Exception {
		
		if(companyProfileEntity.findCompanyById(vo.getId()) == null) {
			throw new ApplicationException(Reason.COMPANY_NOT_FOUND);
		}else {
			vo.setUpdated(new Date());
			vo.setUpdatedBy(Common.SYSTEM_USER);
			
			companyProfileEntity.update(vo);
		}
	}
	
	
	/**
	 * Soft delete
	 * @param id
	 * @throws Exception
	 */
	public void removeCompany(String id) throws Exception{
		CompanyUpdateVO vo = new CompanyUpdateVO();
		vo.setId(id);
		vo.setUpdated(new Date());
		vo.setUpdatedBy(Common.SYSTEM_USER);
		vo.setStatus("DELETE");
		vo.setDelete("Y");
		
		int r = companyProfileEntity.update(vo);
		
		log.debug("perform removeCompany=" + r);
			
	}
	
	/**
	 * Hard delete
	 * @param id
	 * @throws Exception
	 */
	public void deleteCompany(String id) throws Exception {
		companyProfileEntity.delete(id);
	}
	

}

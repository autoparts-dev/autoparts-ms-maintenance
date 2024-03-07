/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.autoparts.core.entity.BaseEntity;
import com.autoparts.core.entity.EntityException;
import com.autoparts.ms.maintenance.vo.company.CompanyCreateVO;
import com.autoparts.ms.maintenance.vo.company.CompanyListVO;
import com.autoparts.ms.maintenance.vo.company.CompanyProfileVO;
import com.autoparts.ms.maintenance.vo.company.CompanyUpdateVO;

/**
 * @author sosseres
 *
 */
@Repository
public class CompanyProfileEntity extends BaseEntity{
	

	private static Logger log = LoggerFactory.getLogger(CompanyProfileEntity.class.getName());

	/**
	 * 
	 */
	public CompanyProfileEntity(@Qualifier("apdbEM") EntityManager em) {
		// TODO Auto-generated constructor stub
		setEntityManager(em);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CompanyProfileVO findCompanyById(String id) throws EntityException {
		
		CompanyProfileVO vo = new CompanyProfileVO();
		vo.setId(id);
		
		List<CompanyProfileVO> lst = executeQuery("COMPANY#ID#S", vo);
		
		if(lst == null || lst.size() == 0) {
			return null;
		}else {

			return lst.get(0);
		}
	}

	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public CompanyProfileVO findCompanyByBRN(String brn) throws EntityException {
		
		CompanyProfileVO vo = new CompanyProfileVO();
		vo.setBusinessRegisrationNumber(brn);
			
		List<CompanyProfileVO> lst = executeQuery("COMPANY#BRN#S", vo);
		
		if(lst == null || lst.size() == 0) {
			return null;
		}
		else {
			return lst.get(0);
		}
	}
	
	/**
	 * Admin function
	 * @param name
	 * @param page
	 * @param pageSize
	 * @return
	 * @throws EntityException
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<CompanyListVO> findCompanyByName(String name, int page, int pageSize) throws EntityException {

		CompanyListVO vo = new CompanyListVO();
		vo.setName(name);
		vo.setPagination(page, pageSize);

		return executeQuery("COMPANY#NAME#S", vo);
//		
	}
	
	
	@Transactional
	public int create(CompanyCreateVO vo) throws EntityException {
		return execute("COMPANY#I", vo);
	}
	
	@Transactional
	public int update(CompanyUpdateVO vo) throws EntityException{
		return execute("COMPANY#U", vo);
	}
	
	@Transactional
	public int delete(String id) throws EntityException {
		CompanyUpdateVO vo = new CompanyUpdateVO();
		vo.setId(id);
		
		return execute("COMPANY#D", vo);
	}
	
	

}

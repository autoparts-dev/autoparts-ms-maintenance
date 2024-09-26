/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoparts.core.entity.EntityException;
import com.autoparts.ms.maintenance.repository.MaintenanceEntity;
import com.autoparts.ms.maintenance.vo.ProductCategoryVO;

/**
 * @author sosseres
 *
 */
@Service
public class MaintenanceService {
	
	
	private static Logger log = LoggerFactory.getLogger(MaintenanceService.class.getName());
	
	@Autowired
	private MaintenanceEntity maintenanceEntity;
	
	/**
	 * 
	 */
	public MaintenanceService() {
		// TODO Auto-generated constructor stub
	}
	
	public List<ProductCategoryVO> getListOfProductCategory() throws Exception {
		List<ProductCategoryVO> lst;
		
		try {
			lst = maintenanceEntity.getListOfProductCategory();
			log.debug("product category lsit: {}", lst.size());
			
		} catch (EntityException e) {
			log.error(e.getMessage(), e);
			throw e;
		}
		
		return lst;
	}

}

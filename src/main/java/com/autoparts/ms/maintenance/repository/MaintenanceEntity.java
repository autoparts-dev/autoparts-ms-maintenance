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
import com.autoparts.ms.maintenance.vo.service.ProductCategoryVO;

/**
 * @author sosseres
 *
 */
@Repository
public class MaintenanceEntity extends BaseEntity{

	/**
	 * 
	 */
	public MaintenanceEntity(@Qualifier("apdbEM") EntityManager em) {
		// TODO Auto-generated constructor stub
		setEntityManager(em);
	}
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<ProductCategoryVO> getListOfProductCategory() throws EntityException{
		ProductCategoryVO vo = new ProductCategoryVO();
		
		return executeQuery("PROD_CATGS#S", vo);
		
	}

}

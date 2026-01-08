/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.PlatformTransactionManager;

import com.autoparts.core.entity.repository.NativeRepositoryFactoryBean;

/**
 * @author sosseres
 *
 */
public class PrimaryRepositoryFactoryBean<T> extends NativeRepositoryFactoryBean<T>{
	
	@Autowired
    @Qualifier("apdbEM")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Autowired
    @Qualifier("apdbTM")
    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


}

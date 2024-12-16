/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.autoparts.core.entity.Action;
import com.autoparts.core.entity.EntityException;
import com.autoparts.ms.maintenance.repository.CompanyProfileEntity;
import com.autoparts.ms.maintenance.vo.RollbackVO;

/**
 * @author sosseres
 *
 */
@Component
public class CompanyProfileRollbackConsumer {
	
	private static Logger log = LoggerFactory.getLogger(CompanyProfileRollbackConsumer.class.getName());

	@Autowired
	private CompanyProfileRollbackService companyProfileRollbackService;
	
	@Autowired
	private CompanyProfileEntity companyProfileEntity;

	/**
	 * 
	 */
	public CompanyProfileRollbackConsumer() {
		// TODO Auto-generated constructor stub
	}
	

	@KafkaListener(topics = "${kafka.rollbackCompanyProfile.topic}", groupId = "${kafka.rollbackCompanyProfile.groupId}", concurrency = "${kafka.rollbackCompanyProfile.consumer-concurrency}", containerFactory = "defaultKafkaListenerContainerFactory")
	public void consume(ConsumerRecord<String, String> message) {
		
		RollbackVO vo = companyProfileRollbackService.get(message.value());
		
		log.debug("perform rollback action, id: {}, {}, {}", vo.getId(), vo.getTableName(), vo.getAction().name());
		
		if(Action.INSERT.equals(vo.getAction())){
			vo.getTableName();
			vo.getId();
			
			vo.getPreviousStage();
			
			try {
				companyProfileEntity.delete(vo.getId());
				log.debug("record is rollback id: {}", vo.getId());
			} catch (EntityException e) {
				log.error(e.getMessage(), e);
				
//				TODO insert into rollback record table
			}
		}
		else if(Action.UPDATE.equals(vo.getAction())) {
			
		}
		else if(Action.DELETE.equals(vo.getAction())) {
			
		}
		else {
			log.warn("Unknown rollback action {} {}", vo.getId(), vo.getAction().name());
		}
	}

}

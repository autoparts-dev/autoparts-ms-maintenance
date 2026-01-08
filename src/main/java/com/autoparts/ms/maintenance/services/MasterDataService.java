/**
 * 
 */
package com.autoparts.ms.maintenance.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autoparts.ms.maintenance.repository.MasterDataRepository;
import com.autoparts.ms.maintenance.vo.masterdata.StateVO;

/**
 * @author sosseres
 *
 */
@Service
public class MasterDataService {
	
	
	private static Logger log = LoggerFactory.getLogger(MasterDataService.class.getName());
	
	@Autowired
	private MasterDataRepository masterDataRepository;
	
	/**
	 * 
	 */
	public MasterDataService() {
		// TODO Auto-generated constructor stub
	}
	
//	public List<CountryVO> getCountries() {
//		return masterDataRepository.getCountryList();
//	}

	public List<StateVO> getStates(String countryCode) {
		return masterDataRepository.getStateList(countryCode);
	}
	


}

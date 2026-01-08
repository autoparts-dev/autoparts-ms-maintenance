/**
 * 
 */
package com.autoparts.ms.maintenance.repository;

import java.util.List;

import com.autoparts.core.entity.annotation.BindVariable;
import com.autoparts.core.entity.annotation.NativeQuery;
import com.autoparts.core.entity.annotation.NativeQueryRepository;
import com.autoparts.ms.maintenance.vo.masterdata.StateVO;

/**
 * @author sosseres
 *
 */
@NativeQueryRepository(factoryBean = PrimaryRepositoryFactoryBean.class)
public interface MasterDataRepository {
	
	
	@NativeQuery("""
			SELECT ID, NAME, CD FROM T_MT_STATE WHERE CTRY_CD = :countryCode AND IS_DEL = 'N'
			""")
	public List<StateVO> getStateList(@BindVariable String countryCode);

}

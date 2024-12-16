/**
 * 
 */
package com.autoparts.ms.maintenance.vo;

import java.io.Serializable;

import com.autoparts.core.entity.Action;

/**
 * @author sosseres
 *
 */
public class RollbackVO implements Serializable {

	private String id;
	private Action action;
	private String tableName;
	private Object previousStage;
	
	/**
	 * 
	 */
	public RollbackVO(String id, Action action, String tableName, Object previousStage) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.previousStage = previousStage;
		this.tableName = tableName;
		this.action = action;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public Object getPreviousStage() {
		return previousStage;
	}

	public void setPreviousStage(Object previousStage) {
		this.previousStage = previousStage;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

}

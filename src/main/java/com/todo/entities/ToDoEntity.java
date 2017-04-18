/**
 * 
 */
package com.todo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * @author Achuth K
 *
 */
@Entity
public class ToDoEntity {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String taskName;
	private String priority;
	private Date creationTime;
	private Date modificationtime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getModificationtime() {
		return modificationtime;
	}
	public void setModificationtime(Date modificationtime) {
		this.modificationtime = modificationtime;
	}
	@Override
	public String toString() {
		return "ToDoEntity {id=" + id + ", taskName=" + taskName + ", priority=" + priority + ", creationTime="
				+ creationTime + ", modificationtime=" + modificationtime + "}";
	}
	public ToDoEntity() {
	
	}
	
	
	
}

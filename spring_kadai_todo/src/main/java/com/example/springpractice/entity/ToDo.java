package com.example.springpractice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table( name = "todos")
@Data
public class ToDo {
	
	// ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name = "id")
	private Integer taskId;
	
	// タイトル
	@Column( name = "title" )
	private String taskTitle;
	
	// 優先度
	@Column( name = "priority")
	private String taskPriority;
	
	// ステータス
	@Column( name = "status" )
	private String taskStatus;

}

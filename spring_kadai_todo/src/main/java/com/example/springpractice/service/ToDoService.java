package com.example.springpractice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springpractice.entity.ToDo;
import com.example.springpractice.repository.ToDoRepository;

@Service
public class ToDoService {
	
	// Repository(DI)
	private final ToDoRepository todoRepository;
	
	public ToDoService(ToDoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}
	
	
	// 最新リストの取得
	public List<ToDo> getLatestToDoList() {
				
		// リストの取得
		return todoRepository.findAll();
	}

}

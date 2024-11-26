package com.example.springpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springpractice.service.ToDoService;

@Controller
public class ToDoController {

	// Service(DI)
	private final ToDoService todoService;
	
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	
	
	@GetMapping("/todo")
	public String showToDoList(Model model) {
		
		// 最新リストの取得
		model.addAttribute("tasks", todoService.getLatestToDoList());
		
		// ビューの表示
		return "todoView";
		
	}
	
}

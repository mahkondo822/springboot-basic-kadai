package com.example.springpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springpractice.entity.ToDo;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{

	// 独自の検索メソッド なし
	
}

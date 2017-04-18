package com.todo.services;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.todo.entities.ToDoEntity;




public interface ToDoEntityService {

	public List<ToDoEntity> findAll();
	public ToDoEntity findOne(Long id);
	public void delete(Long id);
	public void save(ToDoEntity dto);
	public void update(ToDoEntity dto);
	public Page<ToDoEntity> findAll(Pageable pageable);

}
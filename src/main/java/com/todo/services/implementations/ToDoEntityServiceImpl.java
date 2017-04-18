package com.todo.services.implementations;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.todo.entities.ToDoEntity;
import com.todo.repositories.ToDoRepository;
import com.todo.services.ToDoEntityService;



/**
 * @author : Achuth K
 *
 */
@Service
public class ToDoEntityServiceImpl implements ToDoEntityService {


	@Autowired
	private ToDoRepository repository;
	
	@Override
	public List<ToDoEntity> findAll() {
		return repository.findAll();
	}

	
	@Override
	public ToDoEntity findOne(Long id) {
		return repository.findOne(id);
	}

	
	@Override
	public void delete(Long id) {
		repository.delete(id);
	}

	
	@Override
	public void save(ToDoEntity dto) {
		dto.setCreationTime(new Date());
		dto.setModificationtime(new Date());
		repository.save(dto);
	}

	
	@Override
	public void update(ToDoEntity dto) {
		dto.setCreationTime(dto.getCreationTime());
		dto.setModificationtime(new Date());
		repository.save(dto);
	}

	
	@Override
	public Page<ToDoEntity> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}



}


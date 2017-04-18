/**
 * 
 */
package com.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.todo.entities.ToDoEntity;

/**
 * @author Achuth K
 *
 */
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long>, PagingAndSortingRepository<ToDoEntity, Long>{

}

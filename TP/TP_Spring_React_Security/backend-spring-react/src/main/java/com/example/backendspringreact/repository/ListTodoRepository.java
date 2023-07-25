package com.example.backendspringreact.repository;

import com.example.backendspringreact.model.ListTodo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListTodoRepository extends JpaRepository<ListTodo, Long> {
}

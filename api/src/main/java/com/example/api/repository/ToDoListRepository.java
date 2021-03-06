package com.example.api.repository;


import com.example.api.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}

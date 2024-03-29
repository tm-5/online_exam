package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Question;

public interface QuestionRepository extends CrudRepository<Question,Long>{

}
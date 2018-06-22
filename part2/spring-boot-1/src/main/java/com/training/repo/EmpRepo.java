package com.training.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.bean.Emp;

@Repository
public interface EmpRepo extends CrudRepository<Emp, Integer>{

}

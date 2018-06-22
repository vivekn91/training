package com.training.spring;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.spring.entity.Emp;

@Repository
@Transactional
public class EmpDaoJpaImpl implements EmpDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public int save(Emp emp) {
		em.persist(emp);
		return 1;
	}

	@Override
	public int delete(int empno) {
		Emp e = em.find(Emp.class, empno);
		if(e != null){
			em.remove(e);
			return 1;
		}
		return 0;
	}

	@Override
	public Emp findById(int empno) {
		Emp e = em.find(Emp.class, empno);
		return e;
	}

	@Override
	public List<Emp> findAll() {
		Query query = em.createQuery("select e from Emp e");
		List<Emp> empList = query.getResultList();
		return empList;
	}

	@Override
	public int saveEmpList(List<Emp> empList) {
		try {
			for (Emp emp : empList) {
				em.persist(emp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return empList.size();
	}

}

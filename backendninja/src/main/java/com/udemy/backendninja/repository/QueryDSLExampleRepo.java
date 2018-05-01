package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;
	
	public void find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<>(em);
		
		Predicate predicate1 = qCourse.description.endsWith("OP");
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(predicate1);
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		}else {
			Predicate predicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(predicate3);
		}
		
		Course course1 =(Course)query.
				select(qCourse.name,qCourse.description)
				.from(qCourse)
				.where(predicateBuilder)
				.fetchOne();
		
		List<Course> courseList = query
				.select(qCourse)
				.from(qCourse)
				.where(qCourse.hours.between(20, 50))
				.fetch();
	}
}

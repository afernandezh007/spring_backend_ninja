package com.udemy.backendninja.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backendninja.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {

//	// Generates automatically a query for Price using findBy<column>
//	Course findByPrice(int price);
//
//	Course findByPriceAndName(int price, String name);
//
//	List<Course> findNameOrderByHours(String name);
//
//	List<Course> findNameOrPrice(String name, int price);
}

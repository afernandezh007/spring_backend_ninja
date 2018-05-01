package com.udemy.backendninja.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.converter.CourseConverter;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;
import com.udemy.backendninja.repository.CourseJpaRepository;
import com.udemy.backendninja.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService {

	private static final Log LOGGER = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter courseConverter;
	
	@Override
	public List<CourseModel> listAllCourses() {
		
		LOGGER.info("Call: listAllCourses()");
		
		List<Course> entityList = courseJpaRepository.findAll();
		
		List<CourseModel> modelList = entityList.stream()
			.map(entity -> courseConverter.entityToModel(entity))
			.collect(Collectors.toList());
		
		return modelList;
	}

	@Override
	public CourseModel addCourse(CourseModel course) {
		LOGGER.info("Call: addCourse()");
		
		Course entity = courseConverter.modelToEntity(course);
		
		Course entitySaved = courseJpaRepository.save(entity);
		
		return courseConverter.entityToModel(entitySaved);
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	/**
	 * It's the same like save a new course
	 */
	@Override
	public CourseModel modifyCourse(CourseModel course) {
		return addCourse(course);
	}

}

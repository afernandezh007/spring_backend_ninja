package com.udemy.backendninja.converter;

import org.springframework.stereotype.Component;

import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

	/**
	 * Entity  --> Model
	 * @param course
	 * @return
	 */
	public CourseModel entityToModel(Course course) {
		CourseModel courseModel = new CourseModel();
		
		courseModel.setName(course.getName());
		courseModel.setDescription(course.getDescription());
		courseModel.setPrice(course.getPrice());
		courseModel.setHours(course.getHours());
				
		return courseModel;
	}
	
	/**
	 * Model --> Entity
	 * @param model
	 * @return
	 */
	public Course modelToEntity(CourseModel model) {
		
		Course course = new Course();
		
		course.setName(model.getName());
		course.setDescription(model.getDescription());
		course.setPrice(model.getPrice());
		course.setHours(model.getHours());
				
		return course;
		
	}
}

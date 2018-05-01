package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.entity.Course;

public interface CourseService {

	List<Course> listAllCourses();

	Course addCourse(Course course);

	int removeCourse(int id);

	Course modifyCourse(Course course);
}

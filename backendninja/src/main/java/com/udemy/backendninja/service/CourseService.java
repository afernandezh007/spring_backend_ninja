package com.udemy.backendninja.service;

import java.util.List;

import com.udemy.backendninja.model.CourseModel;

public interface CourseService {

	List<CourseModel> listAllCourses();

	CourseModel addCourse(CourseModel course);

	int removeCourse(int id);

	CourseModel modifyCourse(CourseModel course);
}

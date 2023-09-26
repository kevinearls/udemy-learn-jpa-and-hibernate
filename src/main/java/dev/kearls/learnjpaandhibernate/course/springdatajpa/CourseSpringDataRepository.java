package dev.kearls.learnjpaandhibernate.course.springdatajpa;

import dev.kearls.learnjpaandhibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}

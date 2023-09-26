package dev.kearls.learnjpaandhibernate.course.jdbc;

import dev.kearls.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner means this should be run at startup
@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseJdbcRepository repository;
    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS dimwit", "Some jerk"));
        repository.insert(new Course(2, "Learn Azure", "Some other jerk"));
        repository.insert(new Course(3, "Learn DevOps", "Some complete loser"));

        repository.deleteCourse(1);

        System.out.println(repository.findCourseById(2));
        System.out.println(repository.findCourseById(3));


    }
}

package dev.kearls.learnjpaandhibernate.course.jpa;

import dev.kearls.learnjpaandhibernate.course.Course;
import dev.kearls.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner means this should be run at startup
@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {
    //@Autowired
    //private CourseJdbcRepository repository;
    @Autowired
    CourseJpaRepository courseJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        repository.insert(new Course(1, "Learn AWS dimwit", "Some jerk"));
//        repository.insert(new Course(2, "Learn Azure", "Some other jerk"));
//        repository.insert(new Course(3, "Learn DevOps", "Some complete loser"));
//
//        repository.deleteCourse(1);
//
//        System.out.println(repository.findCourseById(2));
//        System.out.println(repository.findCourseById(3));
        var course1 = new Course(1, "Learn AWS dimwit", "Some jerk");
        var course2 = new Course(2, "Learn Azure dimwit", "Some other jerk");
        var course3 = new Course(3, "Learn DevOps dimwit", "Some guy");


        courseJpaRepository.insertCourse(course1);
        courseJpaRepository.insertCourse(course2);
        courseJpaRepository.insertCourse(course3);

        courseJpaRepository.deleteById(1);

        System.out.println(courseJpaRepository.findById(2));
        System.out.println(courseJpaRepository.findById(3));
    }
}

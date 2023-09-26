package dev.kearls.learnjpaandhibernate.course;

import dev.kearls.learnjpaandhibernate.course.Course;
import dev.kearls.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import dev.kearls.learnjpaandhibernate.course.springdatajpa.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// CommandLineRunner means this should be run at startup
@Component
public class CourseCommandLineRunner implements CommandLineRunner {
    @Autowired
    private CourseSpringDataRepository repository;

    @Override
    public void run(String... args) throws Exception {
        var course1 = new Course(1, "Learn AWS dimwit", "Some jerk");
        var course2 = new Course(2, "Learn Azure dimwit", "Some other jerk");
        var course3 = new Course(3, "Learn DevOps dimwit", "Some guy");

        repository.save(course1);
        repository.save(course2);
        repository.save(course3);

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));
    }
}

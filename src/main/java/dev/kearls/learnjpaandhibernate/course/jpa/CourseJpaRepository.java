package dev.kearls.learnjpaandhibernate.course.jpa;

import dev.kearls.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
@PersistenceContext
private EntityManager entityManager;

    public void insertCourse(Course course) {
        entityManager.merge(course);
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        var course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }
}

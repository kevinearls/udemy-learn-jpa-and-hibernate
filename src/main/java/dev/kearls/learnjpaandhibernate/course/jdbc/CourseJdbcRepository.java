package dev.kearls.learnjpaandhibernate.course.jdbc;

import dev.kearls.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_QUERY = """
            insert into course (id, name, author)
            values(?, ?, ?);
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteCourse(long id) {
        jdbcTemplate.update("delete from course where id = ?", id);
    }
}

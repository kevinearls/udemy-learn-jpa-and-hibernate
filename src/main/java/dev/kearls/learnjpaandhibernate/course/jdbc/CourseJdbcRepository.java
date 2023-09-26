package dev.kearls.learnjpaandhibernate.course.jdbc;

import dev.kearls.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
    private static final String DELETE_QUERY = "delete from course where id = ?";

    private static final String SELECT_QUERY = """
            select * from COURSE 
            where id = ?
            """;

    public void insert(Course course) {
        jdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteCourse(long id) {
        jdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findCourseById(long id) {
        var courseMapper = new BeanPropertyRowMapper<>(Course.class);
        var course = jdbcTemplate.queryForObject(SELECT_QUERY, courseMapper, id);

        return course;
    }


}

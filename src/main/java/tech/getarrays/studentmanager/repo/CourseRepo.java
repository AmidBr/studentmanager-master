package tech.getarrays.studentmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.studentmanager.model.Course;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    void deleteCourseById(Long id);

    Optional<Course> findCourseById(Long id);
}

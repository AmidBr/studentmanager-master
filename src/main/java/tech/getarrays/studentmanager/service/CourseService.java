package tech.getarrays.studentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.studentmanager.exception.UserNotFoundException;
import tech.getarrays.studentmanager.model.Course;
import tech.getarrays.studentmanager.model.Student;
import tech.getarrays.studentmanager.repo.CourseRepo;
import tech.getarrays.studentmanager.repo.StudentRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CourseService {
    private final CourseRepo courseRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course addCourse(Course course) {
        course.setCourseCode(UUID.randomUUID().toString());
        return courseRepo.save(course);
    }

    public List<Course> findAllCourses() {
        return courseRepo.findAll();
    }

    public Course updateCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course findCourseById(Long id) {
        return courseRepo.findCourseById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCourse(Long id){
        courseRepo.deleteCourseById(id);
    }
}

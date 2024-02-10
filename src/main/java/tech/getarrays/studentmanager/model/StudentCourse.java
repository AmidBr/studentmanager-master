package tech.getarrays.studentmanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class StudentCourse implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Long score;

    public StudentCourse() {
    }

    public StudentCourse(Student student, Course course, Long score) {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                '}';
    }
}

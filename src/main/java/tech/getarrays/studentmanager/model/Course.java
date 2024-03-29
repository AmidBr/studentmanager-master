package tech.getarrays.studentmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
      @Column(nullable = false, updatable = false)
    private String courseCode;

    @OneToMany(mappedBy = "course")
    private Set<StudentCourse> enrolledStudents = new HashSet<>();

/*
      @ManyToMany(mappedBy = "followedCourses")
      private List<Student> members = new ArrayList<>();

      public void addMember(Student student){
          members.add(student);
      }
*/
    public Course() {
    }

    public Course(String name, String courseCode) {
        this.name = name;
        this.courseCode = courseCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}

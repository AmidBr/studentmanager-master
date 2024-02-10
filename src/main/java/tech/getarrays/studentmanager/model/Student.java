package tech.getarrays.studentmanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String familyName;
    private String birthDate;
    private String email;
    @Column(nullable = false, updatable = false)
    private String studentCode;

    @OneToMany(mappedBy = "student")
    private Set<StudentCourse> followedCourses = new HashSet<>();

    /*
    @ManyToMany
    @JoinTable(
            name = "followed_Courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"),
            private String status;
    )
    private List<Course> followedCourses = new ArrayList<>();
    public void followCourses(Course course){
        followedCourses.add(course);
    }
    */

    public Student() {}

    public Student(String firstName, String familyName, String birthDate, String email, String studentCode) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.email = email;
        this.studentCode = studentCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                ", studentCode='" + studentCode + '\'' +
                '}';
    }
}

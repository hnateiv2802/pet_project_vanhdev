package elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@Entity(name="courseEntity")
@Table(name="courseEntity")
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="courseName")
    private String courseName;

    @Column(name="teacherName")
    private String teacherName;

    @Column(name="description")
    private String description;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;
}

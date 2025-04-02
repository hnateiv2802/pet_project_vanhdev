package elearning.entity;

import elearning.entity.key.UserCourseKey;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
@Entity(name="UserCourseEnity")
@Table(name="UserCourseEnity")
@IdClass(UserCourseKey.class)
public class UserCourseEntity implements Serializable {
    @Id
    private int userID;

    @Id
    private int courseID;

    @Column(name="rating")
    private double rating;

    @Column(name="review")
    private String review;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;
}

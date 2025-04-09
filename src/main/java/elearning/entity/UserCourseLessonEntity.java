package elearning.entity;

import elearning.entity.key.UserCourseLessonKey;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="userCourseLessonEntity")
@Table(name="userCourseLessonEntity")
@IdClass(UserCourseLessonKey.class)

public class UserCourseLessonEntity {
    @Id
    private int ucUserId;

    @Id
    private int ucCourseId;

    @Id
    private int lessonId;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;
}

package elearning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data

@Entity(name="lessonEntity")
@Table(name="lessonEntity")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="url")
    private String url;

    @Column(name="lessonOrder")
    private int lessonOrder;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;

    @Column(name="chapterId")
    private int chapterId;
}

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

    @Column(name="lessonName")
    private String lessonName;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;

    @Column(name="url")
    private String url;

    @Column(name="order")
    private int order;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;

    @Column(name="chapterID")
    private int chapterID;
}

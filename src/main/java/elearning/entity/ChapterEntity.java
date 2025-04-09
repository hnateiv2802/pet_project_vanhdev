package elearning.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity(name="chapterEntity")
@Table(name="chapterEntity")
public class ChapterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="chapterOrder")
    private int chapterOrder;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;

    // @ManyToOne
    // @JoinColumn(name = "user_id", nullable = false)
    @Column(name="courseId")
    private int courseId;
}

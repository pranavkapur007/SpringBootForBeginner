package io.springbootstarter.lesson;

import io.springbootstarter.course.Course;
import io.springbootstarter.topic.Topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// Lesson Model Object
@Entity
public class Lesson {

    @Id
    private String id;
    private String name;
    private String description;

    @ManyToOne
    private Course course;

    public Lesson() {
    }

    public Lesson(String id, String name, String description, String courseId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.course = new Course(courseId, "", "", "");
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {
        return course;
    }


}

package io.springbootstarter.lesson;

import io.springbootstarter.course.Course;
import io.springbootstarter.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService; // @autowired means that it requires injection of service

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable("courseId") String courseId) {
        return lessonService.getAllCourses(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable("id") String id) {
        return lessonService.getLesson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addCourse(@RequestBody Lesson lesson, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable("courseId") String courseId, @PathVariable("id") String id) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.updateLesson(id, lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteCourse(@PathVariable("id") String id) {
        lessonService.deleteLesson(id);
    }
}

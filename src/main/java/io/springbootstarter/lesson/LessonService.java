package io.springbootstarter.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// generally spring business service is singleton
@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllCourses(String id) {
        List<Lesson> lessons = lessonRepository.findByCourseId(id);
        return lessons;
    }

    public Lesson getLesson(String id) {
        Optional<Lesson> lessonOpt = lessonRepository.findById(id);
        if (lessonOpt.isPresent()) {
            return lessonOpt.get();
        }
        else
            return null;
    }

    public void addLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void updateLesson(String id, Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
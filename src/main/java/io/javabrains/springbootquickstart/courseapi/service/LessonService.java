package io.javabrains.springbootquickstart.courseapi.service;

import io.javabrains.springbootquickstart.courseapi.model.Lesson;
import io.javabrains.springbootquickstart.courseapi.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findAll().forEach(lessons::add);
        return lessons;
    }

    public List<Lesson> getAllLessonsByCourseId(String courseId) {
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId).forEach(lessons::add);
        return lessons;
    }

    public Lesson getLesson(String id) {
        return lessonRepository.findById(id).get();
    }

    public void addLesson(Lesson course) {
        lessonRepository.save(course);
    }

    public void updateLesson(Lesson course) {
        lessonRepository.save(course);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}

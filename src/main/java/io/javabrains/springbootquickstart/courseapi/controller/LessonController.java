package io.javabrains.springbootquickstart.courseapi.controller;

import io.javabrains.springbootquickstart.courseapi.model.Course;
import io.javabrains.springbootquickstart.courseapi.model.Lesson;
import io.javabrains.springbootquickstart.courseapi.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/lessons")
    public List<Lesson> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessonsByTopicId(@PathVariable String courseId) {
        return lessonService.getAllLessonsByCourseId(courseId);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable String id) {
        return lessonService.getLesson(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
        lesson.setCourse(new Course(courseId, "", "", topicId));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public void deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
    }

}

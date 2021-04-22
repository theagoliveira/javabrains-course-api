package io.javabrains.springbootquickstart.courseapi.repository;

import io.javabrains.springbootquickstart.courseapi.model.Lesson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    public List<Lesson> findByCourseId(String courseId);

}

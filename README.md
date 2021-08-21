# Spring Boot Quick Start

Tutorial by [Java Brains](https://www.youtube.com/channel/UCYt1sfh5464XaDBH0oH_o7Q)

- [:clapper: Playlist on YouTube](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x)
- [:pencil: Course page on javabrains.io](https://www.javabrains.io/courses/springboot-quickstart)

## Table of Contents

- [Table of Contents](#table-of-contents)
- [Description](#description)
- [Project Summary](#project-summary)
- [API Documentation](#api-documentation)
  - [Hello](#hello)
  - [Topics](#topics)
  - [Courses (by Topic ID)](#courses-by-topic-id)
  - [Lessons (by Topic ID and Course ID)](#lessons-by-topic-id-and-course-id)
  - [Bugs](#bugs)
- [Deployment](#deployment)

## Description

From the course page description:

> "Learn how to create full end-to-end Spring applications using Spring Boot"

## Project Summary

- Project: Maven
- Java: 16
- Spring Boot: 2.4.5
- Dependencies
  - Spring Web
  - Spring Boot Starter Test
  - Apache Derby
  - Spring Data JPA
  - Spring Security
  - Bucket4j Spring Boot Starter
  - Spring Cache Abstraction
  - Ehcache
- Plugins
  - Spring Boot Maven Plugin
  - Heroku Maven Plugin

## API Documentation

### Hello

#### Say Hi

##### Request

```http
GET /hello
```

##### Response (200 OK)

```
Hi!
```

### Topics

#### Get Topics

Retrieves a list of all topics.

##### Request

```http
GET /topics
```

##### Sample Response (200 OK)

```json
[
    {
        "id": "topic-a",
        "name": "Topic A Name",
        "description": "Topic A Description"
    },
    {
        "id": "topic-b",
        "name": "Topic B Name",
        "description": "Topic B Description"
    }
]
```

#### Get Topic by ID

Retrieves one topic.

##### Request

```http
GET /topics/:id
```

##### Sample Response (200 OK)

```json
{
    "id": "topic",
    "name": "Topic Name",
    "description": "Topic Description"
}
```

#### Add Topic

Add a new topic to the application.

##### Request

```http
POST /topics
```

##### Sample Request Body

```json
{
    "id": "topic",
    "name": "Topic Name",
    "description": "Topic Description"
}
```

#### Update Topic

Update topic information (name and/or description).

##### Request

```http
PUT /topics/:id
```

##### Sample Request Body

```json
{
    "id": "topic",
    "name": "New Topic Name",
    "description": "New Topic Description"
}
```

#### Delete Topic

Remove topic from the application.

##### Request

```http
DELETE /topics/:id
```

### Courses (by Topic ID)

#### Get All Courses

Retrieves a list of all courses, regardless of Topic ID.

##### Request

```http
GET /courses
```

##### Sample Response (200 OK)

```json
[
    {
        "id": "course-a",
        "name": "Course A Name",
        "description": "Course A Description",
        "topic": {
            "id": "topic-a",
            "name": "Topic A Name",
            "description": "Topic A Description"
        }
    },
    {
        "id": "course-b",
        "name": "Course B Name",
        "description": "Course B Description",
        "topic": {
            "id": "topic-b",
            "name": "Topic B Name",
            "description": "Topic B Description"
        }
    }
]
```

#### Get Courses

Retrieves a list of all courses with a specific topic.

##### Request

```http
GET /topics/:topicId/courses
```

##### Sample Response (200 OK)

```json
[
    {
        "id": "course-a",
        "name": "Course A Name",
        "description": "Course A Description",
        "topic": {
            "id": "topic-a",
            "name": "Topic A Name",
            "description": "Topic A Description"
        }
    },
    {
        "id": "course-b",
        "name": "Course B Name",
        "description": "Course B Description",
        "topic": {
            "id": "topic-a",
            "name": "Topic A Name",
            "description": "Topic A Description"
        }
    }
]
```

#### Get Course by ID

Retrieves one course.

##### Request

```http
GET /topics/:topicId/courses/:id
```

##### Sample Response (200 OK)

```json
{
    "id": "course",
    "name": "Course Name",
    "description": "Course Description"
}
```

#### Add Course

Add a new course to the application.

##### Request

```http
POST /topics/:topicId/courses
```

##### Sample Request Body

```json
{
    "id": "course",
    "name": "Course Name",
    "description": "Course Description"
}
```

#### Update Course

Update course information (name and/or description).

##### Request

```http
PUT /topics/:topicId/courses/:id
```

##### Sample Request Body

```json
{
    "id": "course",
    "name": "New Course Name",
    "description": "New Course Description"
}
```

#### Delete Course

Remove course from the application.

##### Request

```http
DELETE /topics/:topicId/courses/:id
```

### Lessons (by Topic ID and Course ID)

#### Get All Lessons

Retrieves a list of all lessons, regardless of Topic ID and Course ID.

##### Request

```http
GET /lessons
```

##### Sample Response (200 OK)

```json
[
    {
        "id": "lesson-a",
        "name": "Lesson A Name",
        "description": "Lesson A Description",
        "course": {
            "id": "course",
            "name": "Course Name",
            "description": "Course Name Description",
            "topic": {
                "id": "topic",
                "name": "Topic Name",
                "description": "Topic Name Description"
            }
        }
    }
]
```

#### Get Lessons

Retrieves a list of all lessons with a specific course and topic.

##### Request

```http
GET /topics/:topicId/courses/:courseId/lessons
```

##### Sample Response (200 OK)

```json
[
    {
        "id": "lesson-a",
        "name": "Lesson A Name",
        "description": "Lesson A Description",
        "course": {
            "id": "course",
            "name": "Course Name",
            "description": "Course Name Description",
            "topic": {
                "id": "topic",
                "name": "Topic Name",
                "description": "Topic Name Description"
            }
        }
    },
    {
        "id": "lesson-b",
        "name": "Lesson B Name",
        "description": "Lesson B Description",
        "course": {
            "..."
        }
    }
]
```

#### Get Lesson by ID

Retrieves one lesson.

##### Request

```http
GET /topics/:topicId/courses/:courseId/lessons/:id
```

##### Sample Response (200 OK)

```json
{
    "id": "lesson-a",
    "name": "Lesson A Name",
    "description": "Lesson A Description",
    "course": {
        "id": "course",
        "name": "Course Name",
        "description": "Course Name Description",
        "topic": {
            "id": "topic",
            "name": "Topic Name",
            "description": "Topic Name Description"
        }
    }
}
```

#### Add Lesson

Add a new lesson to the application.

##### Request

```http
POST /topics/:topicId/courses/:courseId/lesson
```

##### Sample Request Body

```json
{
    "id": "lesson",
    "name": "Lesson Name",
    "description": "Lesson Description",
}
```

#### Update Lesson

Update course information (name and/or description).

##### Request

```http
PUT /topics/:topicId/courses/:courseId/lessons/:id
```

##### Sample Request Body

```json
{
    "id": "lesson",
    "name": "New Lesson Name",
    "description": "New Lesson Description",
}
```

#### Delete Lesson

Remove lesson from the application.

##### Request

```http
DELETE /topics/:topicId/courses/:courseId/lessons/:id
```

### Bugs

- [Get Course by ID](#get-course-by-id) request ignores `lessonId` (no verification is done)
- [Get Lesson by ID](#get-lesson-by-id) request ignores `lessonId` and `courseId` (no verification is done)
- [Update Topic](#update-topic) request ignores `id`. so a new topic is created if a new id is provided in the request body
- [Update Course](#update-course) request ignores `id`. so a new course is created if a new id is provided in the request body
- [Update Lesson](#update-lesson) request ignores `id`. so a new lesson is created if a new id is provided in the request body
- Before a topic is deleted, all of its courses must be deleted first
- Before a course is deleted, all of its lessons must be deleted first

## Deployment

API deployed on [Heroku](https://obscure-citadel-61856.herokuapp.com/)

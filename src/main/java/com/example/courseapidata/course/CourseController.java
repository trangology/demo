package com.example.courseapidata.course;

import com.example.courseapidata.topic.Topic;
import com.example.courseapidata.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics/{id}/courses")
    public Optional<Topic> getAllCourses(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses/{id}")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
        Optional<Topic> topic = topicService.getTopic(topicId);
        course.setTopic(topic.get());
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
        Optional<Topic> topic = topicService.getTopic(topicId);
        course.setTopic(topic.get());
        courseService.updateCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id)  {
        courseService.deleteCourse(id);
    }
 }

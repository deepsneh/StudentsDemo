package com.ind.students.controller;

import com.ind.students.dto.StudentsDto;
import com.ind.students.entity.Students;
import com.ind.students.service.StudentsService;
import com.ind.students.service.StudentDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentsController {
    private final StudentsService studentsService;

    private final StudentDetailsService studentDetailsService;

    public StudentsController(StudentsService studentsService,
                              StudentDetailsService studentDetailsService) {
        this.studentsService = studentsService;
        this.studentDetailsService = studentDetailsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Students> createStudent(@RequestBody StudentsDto studentsDto) {

        log.info("create new Student api called");
        return ResponseEntity.ok(studentsService.saveStudent(studentsDto));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Students>> fetchAllStudents( @RequestParam(defaultValue = "0") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize) {

        log.info("fetch all Students api called");
        return ResponseEntity.ok(studentsService.fetchAllStudents(pageNo, pageSize));
    }

    @GetMapping("/college-details")
    private ResponseEntity<String> getCollegeDetails( @RequestParam(defaultValue = "416110") String pinCode)
    {
        log.info("fetch location string");
        return ResponseEntity.ok(studentDetailsService.getCollegesByPinCode(pinCode));
    }

}

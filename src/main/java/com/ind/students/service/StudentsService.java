package com.ind.students.service;

import com.ind.students.dto.StudentsDto;
import com.ind.students.entity.Students;
import org.springframework.data.domain.Page;

public interface StudentsService {


    Students saveStudent(StudentsDto studentsDto);

    Page<Students> fetchAllStudents(int pageNo, int pageSize);


}

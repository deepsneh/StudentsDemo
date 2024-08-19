package com.ind.students.service;

import com.ind.students.dto.StudentsDto;
import com.ind.students.entity.Students;
import com.ind.students.repository.StudentsRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class StudentsServiceImpl implements StudentsService {

    private final StudentsRepository studentsRepository;

    public StudentsServiceImpl(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @Override
    public Students saveStudent(StudentsDto studentsDto) {
        Students students =
                Students.builder()
                        .name(studentsDto.getName())
                        .email(studentsDto.getEmail())
                        .build();
         return studentsRepository.save(students);
    }

    @Override
    public Page<Students> fetchAllStudents(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return studentsRepository.findAll(pageable);
    }

}

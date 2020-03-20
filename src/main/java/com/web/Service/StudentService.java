package com.web.Service;

import com.web.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {

    public Page<Student> pageStudent(Pageable pageable);

    public List<Student> listStudent();

    public Student getStudent(String id);
}

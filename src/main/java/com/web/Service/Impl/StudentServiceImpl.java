package com.web.Service.Impl;

import com.web.Dao.StudentRepository;
import com.web.Entity.Student;
import com.web.Service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.Service.Impl
 * @ClassName: StudentServiceImpl
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/3/17 15:54
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentRepository repository;

    @Override
    public Page<Student> pageStudent(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Student> listStudent() {
        return repository.findAll();
    }

    @Override
    public Student getStudent(String id) {
        return repository.getStudentById(id);
    }
}

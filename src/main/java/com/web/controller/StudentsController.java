package com.web.controller;

import com.web.Entity.PageUtil;
import com.web.Entity.Student;
import com.web.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.controller
 * @ClassName: StudentsController
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/3/17 15:00
 */
@Controller
@RequestMapping(value = "/api/")
public class StudentsController {

    private static final Logger logger = LoggerFactory.getLogger(StudentsController.class);

    @Resource
    private StudentService studentService;

    @PostMapping(value = {"students"})
    @ResponseBody
    public Page<Student> pageStudent(@RequestBody PageUtil pageUtil){
        logger.info("page number:" + pageUtil.getPageNumber());
        logger.info("page size:" + pageUtil.getPageSize());

        Pageable pageable = new PageRequest(pageUtil.getPageNumber(), pageUtil.getPageSize());
        return studentService.pageStudent(pageable);
    }

    @GetMapping(value = {"students"})
    @ResponseBody
    public List<Student> listStudent(){
        return studentService.listStudent();
    }

    @GetMapping(value = {"student"})
    @ResponseBody
    public Student getStudent(int id){
        logger.info("student's id:" + id);
        return studentService.getStudent(id);
    }
}

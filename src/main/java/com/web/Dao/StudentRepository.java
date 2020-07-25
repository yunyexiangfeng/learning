package com.web.Dao;

import com.web.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.web.Dao
 * @ClassName: StudentRepository
 * @Description: default
 * @Author: Administrator
 * @CreateDate: 2020/3/17 15:34
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "select a from #{#entityName} a where a.id =:id")
    public Student getStudentById(@Param("id") int id);
}

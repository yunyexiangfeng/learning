package test;

import com.Application;
import com.java.compareTo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: test
 * @ClassName: SpringBootConfigApplicationTest
 * @Description: @SpringBootTest
 *                      使用classes指定启动类
 * @Author: Administrator
 * @CreateDate: 2019/12/16 19:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringBootConfigApplicationTest {
    @Resource
    Person person;

    @Test
    public void propertiesLoad(){
        System.out.println(person.toString());
    }
}


select * from student 
	join score as s1 on student.s_id = s1.s_id and s1.c_id='01' ;

select * from student 
	LEFT JOIN score as s1 on student.s_id = s1.s_id and s1.c_id='01' 
	LEFT JOIN score as s2 on student.s_id = s2.s_id and s2.c_id='02' where s1.s_score>s2.s_score;

select * from student LEFT JOIN score on student.s_id=score.s_id where score.c_id='02';

#查询"01"课程比"02"课程成绩高的学生的信息及课程分数
select student.*, s1.s_score as score01, s2.s_score as score02 from student 
	join score as s1 on student.s_id = s1.s_id and s1.c_id='01' 
	LEFT JOIN score as s2 on student.s_id = s2.s_id and s2.c_id='02' where s1.s_score > s2.s_score;

#查询"01"课程比"02"课程成绩低的学生的信息及课程分数
select student.*, s1.s_score as score01, s2.s_score as score02 from student 
	join score as s1 on student.s_id = s1.s_id and s1.c_id='01' 
	LEFT JOIN score as s2 on student.s_id = s2.s_id and s2.c_id='02' where s1.s_score < s2.s_score;


#查询平均成绩大于等于60分的同学的学生编号和学生姓名和平均成绩
select * from student join score on student.s_id=score.s_id;
select * from student LEFT join score on student.s_id=score.s_id;


select student.s_id,student.s_name, ROUND(AVG(score.s_score),2) as csp from student join score on student.s_id=score.s_id  group by student.s_id having csp > 60;

#查询平均成绩小于60分的同学的学生编号和学生姓名和平均成绩
select student.s_id,student.s_name, ROUND(AVG(score.s_score),2) as csp from student LEFT join score on student.s_id=score.s_id  group by student.s_id having csp < 60
UNION select student.s_id,student.s_name,0 as csp from student LEFT JOIN score on student.s_id=score.s_id WHERE score.s_score is NULL;



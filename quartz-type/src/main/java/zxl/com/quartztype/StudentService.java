package zxl.com.quartztype;

import com.unionpay.jdbcmodle.JdbcUtil;
import com.unionpay.jdbcmodle.model.Student;
import zxl.com.quartztype.model.Record;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService {
    public static void main(String[] args) throws Exception{
        JdbcUtil jdbcUtil = new JdbcUtil();
        try {
            List<Student> students = jdbcUtil.selectObject("SELECT * from student ",new Object[]{}, Student.class);
            System.out.println("stu:"+students.size());

            List<Record> records = jdbcUtil.selectObject("select * from t_record", null, Record.class);
            System.out.println("ss:"+records.size());
            jdbcUtil.getConnection().setAutoCommit(false);

            Student student = new Student();
            student.setId(7);
            student.setStuName("lisi");
            student.setStuAge(1);
            student.setStuDesc("浦东新区");
            List<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            int resultStu = jdbcUtil.insertObjs("student",studentList);
            System.out.println("resultStu:"+resultStu);

            List<Record> recordList = new ArrayList<>();
            Record record1 = new Record();
            record1.setId(1);
            record1.setInputTime(new Date());
            record1.setRecordDesc("test desc");
            recordList.add(record1);
            int result = jdbcUtil.insertObjs("t_record",recordList);
            System.out.println("result:"+result);
            jdbcUtil.getConnection().commit();
        }catch (Exception e){
            jdbcUtil.getConnection().rollback();
            System.out.println("回滚操作");
            e.printStackTrace();
        }
    }
}

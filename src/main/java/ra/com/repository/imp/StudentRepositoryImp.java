package ra.com.repository.imp;

import org.springframework.stereotype.Repository;
import ra.com.model.Student;
import ra.com.repository.StudentRepository;
import ra.com.util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Đánh dấu đây là thành phần Repository của SpringMVC
@Repository
public class StudentRepositoryImp implements StudentRepository {
    @Override
    public List<Student> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> listStudents = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_student()}");
            ResultSet rs = callSt.executeQuery();
            listStudents = new ArrayList<Student>();
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
                listStudents.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listStudents;
    }

    @Override
    public boolean save(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_student(?,?)}");
            callSt.setString(1, student.getStudentName());
            callSt.setInt(2, student.getAge());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public Student findById(int studentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        Student student = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_student_by_id(?)}");
            callSt.setInt(1, studentId);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudentId(rs.getInt("student_id"));
                student.setStudentName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return student;
    }

    @Override
    public boolean update(Student student) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_student(?,?,?,?)}");
            callSt.setInt(1, student.getStudentId());
            callSt.setString(2, student.getStudentName());
            callSt.setInt(3, student.getAge());
            callSt.setBoolean(4, student.isStatus());
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    @Override
    public boolean delete(int studentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_student(?)}");
            callSt.setInt(1, studentId);
            callSt.executeUpdate();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}

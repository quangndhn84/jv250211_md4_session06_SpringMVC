package ra.com.service;

import ra.com.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    boolean save(Student student);

    Student findById(int studentId);

    boolean update(Student student);

    boolean delete(int studentId);

    List<Student> search(String studentName);
}

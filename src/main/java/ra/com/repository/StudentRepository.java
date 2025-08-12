package ra.com.repository;

import ra.com.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();

    boolean save(Student student);

    Student findById(int studentId);

    boolean update(Student student);

    boolean delete(int studentId);
}

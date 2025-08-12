package ra.com.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.com.model.Student;
import ra.com.repository.StudentRepository;
import ra.com.service.StudentService;

import java.util.List;

//Đánh dấu đây là thành phần service của SpringMVC - Chứa tất cả nghiệp vụ của ứng dụng
@Service
public class StudentServiceImp implements StudentService {
    //Tiêm instance của bean có tên là StudentRepository trong container
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public boolean update(Student student) {
        return studentRepository.update(student);
    }

    @Override
    public boolean delete(int studentId) {
        return studentRepository.delete(studentId);
    }
}

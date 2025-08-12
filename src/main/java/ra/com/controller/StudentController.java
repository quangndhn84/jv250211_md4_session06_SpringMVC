package ra.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.com.model.Student;
import ra.com.service.StudentService;

import java.util.List;

//Đánh dấu là thành phần controller của SpringMVC
@Controller
//Cấu hình handleMapping: map với đường dẫn localhost:8080/StudentController
@RequestMapping("/StudentController")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //localhost:8080/StudentController/findAll - Get
    //@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @GetMapping("/findAll")
    public String findAllStudent(Model model) {
        List<Student> listStudents = studentService.findAll();
        model.addAttribute("listStudents", listStudents);
        //trả lại view để hiển thị dữ liệu
        return "students";
    }

    @GetMapping("/initCreate")
    public String initCreateStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "newStudent";
    }

    @PostMapping("/create")
    //public String createStudent(@ModelAttribute(name = "student") Student studentA)
    public String createStudent(Student student) {
        boolean result = studentService.save(student);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/initUpdate")
    //public String initUpdateStudent(Model model, @RequestParam("studentId") int id) {
    public String initUpdateStudent(Model model, int studentId) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        return "updateStudent";
    }

    @PostMapping("/update")
    public String updateStudent(Student student) {
        boolean result = studentService.update(student);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @GetMapping("/delete")
    public String deleteStudent(int studentId) {
        boolean result = studentService.delete(studentId);
        if (result) {
            return "redirect:findAll";
        } else {
            return "error";
        }
    }

    @PostMapping("/searchStudent")
    // Trong model của nó đang có listStudents - StudentNameSearch
    public String seachStudent(Model model, @RequestParam("studentNameSearch") String studentNameSeach) {
        //Thực gọi sang service thực hiện search
        List<Student> listStudent = studentService.search(studentNameSeach);
        model.addAttribute("listStudents", listStudent);
        return "students";
    }
}

package ma.souhail.SchoolApp.controllers;

import ma.souhail.SchoolApp.model.Student;
import ma.souhail.SchoolApp.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    private StudentRepo studentRepo;
    @GetMapping(path = "/studentslist")
    List<Student> StudentList(/*@RequestParam(name = "page") int page,@RequestParam(name = "size") int size*/){
        return  studentRepo.findAll(/*PageRequest.of(page,size)*/);
    }
}

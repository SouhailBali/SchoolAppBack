package ma.souhail.SchoolApp.controllers;

import ma.souhail.SchoolApp.model.Student;
import ma.souhail.SchoolApp.repositories.StudentRepo;
import ma.souhail.SchoolApp.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
public class StudentController {
    @Autowired
    private StorageService storageService;

    List<String> files = new ArrayList<String>();
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping(path = "/photoSalle/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Student student=studentRepo.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/roomBooking/rooms/"+student.getPhotoName()));
    }
    @PostMapping(path = "/uploadPhoto")
    public ResponseEntity<String> uploadPhoto(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);
            files.add(file.getOriginalFilename());

            message = "You successfully uploaded " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "FAIL to upload " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }


    @GetMapping(path = "/studentslist")
    List<Student> StudentList(/*@RequestParam(name = "page") int page,@RequestParam(name = "size") int size*/){
        return  studentRepo.findAll(/*PageRequest.of(page,size)*/);
    }
}

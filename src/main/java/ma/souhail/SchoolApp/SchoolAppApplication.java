package ma.souhail.SchoolApp;

import ma.souhail.SchoolApp.model.Student;
import ma.souhail.SchoolApp.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class SchoolAppApplication implements CommandLineRunner {
	@Autowired
	private StudentRepo studentRepo;
	public static void main(String[] args) {
		SpringApplication.run(SchoolAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
Student StudentA= new Student();
	StudentA.setAge(15);
	StudentA.setName("Souhail");
	StudentA.setSurname("Bali");
	StudentA.setPhotoName("pic");
	StudentA.setDateOfBirth(new Date(System.currentTimeMillis()));
		studentRepo.save(StudentA);
	}
}

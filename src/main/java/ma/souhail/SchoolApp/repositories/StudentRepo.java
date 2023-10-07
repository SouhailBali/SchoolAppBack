package ma.souhail.SchoolApp.repositories;

import ma.souhail.SchoolApp.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface StudentRepo extends JpaRepository<Student, Long> {
    @RestResource(path = "ById")
    Page<Student> findById(@Param("mc") Long id, Pageable pageable);

    @RestResource(path = "/All")
    Page<Student> findAll(Pageable pageable);
}

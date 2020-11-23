package pl.gregorymartin.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProjectQueryRepository {

    Project save(Project project);

    void deleteById(long projectId);

    Page<Project> findAll(Pageable page);
    Optional<Project> findById(long id);

    long count();
}

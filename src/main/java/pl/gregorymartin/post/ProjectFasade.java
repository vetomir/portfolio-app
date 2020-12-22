package pl.gregorymartin.post;

import org.springframework.data.domain.Sort;
import pl.gregorymartin.post.dto.ProjectReadModel;
import pl.gregorymartin.post.dto.ProjectWriteModel;

import java.util.List;
import java.util.Set;


public interface ProjectFasade {

    List<ProjectReadModel> getAll(int page, Sort.Direction sort, String sortBy, int items);

    ProjectReadModel getSingle(long id);

    ProjectReadModel save(ProjectWriteModel source);
    Set<Tag> saveTags(Set<Tag> tags);

    ProjectReadModel modify(long id, ProjectWriteModel source);

    void delete(long id);
}

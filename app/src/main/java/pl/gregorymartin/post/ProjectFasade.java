package pl.gregorymartin.post;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.gregorymartin.post.dto.ProjectReadModel;
import pl.gregorymartin.post.dto.ProjectWriteModel;
import pl.gregorymartin.tags.Tag;
import pl.gregorymartin.tags.TagQueryRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public
class ProjectFasade {
    private final ProjectQueryRepository projectQueryRepository;
    private final TagQueryRepository tagQueryRepository;

    public ProjectFasade(final ProjectQueryRepository projectQueryRepository, final TagQueryRepository tagQueryRepository) {
        this.projectQueryRepository = projectQueryRepository;
        this.tagQueryRepository = tagQueryRepository;
    }

    List<ProjectReadModel> getAll(int page, Sort.Direction sort, String sortBy, int items) {
        List<Project> list = projectQueryRepository.findAll(
                PageRequest.of(page, items,
                        Sort.by(sort, sortBy)
                )).getContent();

        return ProjectFactory.toDto(list);
    }

    ProjectReadModel getSingle(long id){
        return ProjectFactory.toDto(projectQueryRepository.findById(id).get());
    }

    ProjectReadModel save(ProjectWriteModel source){
        Project toSave = ProjectFactory.toEntity(source);

        toSave.setTags(saveTags(toSave.getTags()));

        Project result = projectQueryRepository.save(toSave);
        return ProjectFactory.toDto(result);
    }
    Set<Tag> saveTags(Set<Tag> tags){
        return tags.stream().map(x -> {
            Optional<Tag> tag = tagQueryRepository.getByName(x.getName());

            if(tag.isEmpty()){
                return tagQueryRepository.save(x);
            }
            else {
                return tag.get();
            }
        }).collect(Collectors.toSet());

    }
    @Transactional
    ProjectReadModel modify(long id, ProjectWriteModel source){
        Project result = ProjectFactory.toEntity(source);
        result.setId(id);


        return ProjectFactory.toDto(projectQueryRepository.save(result));
    }
    void delete(long id){
        projectQueryRepository.deleteById(id);
    }
}

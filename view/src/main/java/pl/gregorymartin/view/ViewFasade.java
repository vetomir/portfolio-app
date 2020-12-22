package pl.gregorymartin.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.gregorymartin.post.ProjectFasade;
import pl.gregorymartin.post.dto.ProjectReadModel;
import pl.gregorymartin.view.dto.HeaderReadModel;
import pl.gregorymartin.view.dto.HeaderWriteModel;

import java.util.List;

@Service
class ViewFasade {
    private final HeaderItemRepository itemRepository;
    private final ProjectFasade projectFasade;
    private final Logger logger = LoggerFactory.getLogger(ViewFasade.class);

    ViewFasade(final HeaderItemRepository itemRepository, final ProjectFasade projectFasade) {
        this.itemRepository = itemRepository;
        this.projectFasade = projectFasade;
        System.out.println("FASADE");
    }

    public List<HeaderReadModel> getAll(int page, Sort.Direction sort, String sortBy, int items) {
        List<HeaderItem> list = itemRepository.findAll(
                PageRequest.of(page, items,
                        Sort.by(sort, sortBy)
                )).getContent();


        List<HeaderReadModel> headerReadModels = ViewFactory.headerItemToDto(list);
        headerReadModels.forEach(x ->
                x.setProject(
                        projectFasade.getSingle( x.getProjectId() )));


        return headerReadModels;
    }
    public HeaderReadModel save(HeaderWriteModel source){
        HeaderItem toSave = ViewFactory.toHeaderItem(source);
        ProjectReadModel project = projectFasade.getSingle(source.getProjectId());
        if(project == null)
            throw new IllegalArgumentException("Project ID:" + source.getProjectId() + " is not exist");

        HeaderItem result = itemRepository.save(toSave);
        logger.info("Header Item, for Project with id: {}, it's create ( ID: {} ).",project.getId(), result.getId());
        System.out.println("FASADE2");
        return ViewFactory.headerItemToDto(result);
    }

    public HeaderReadModel modify(long id, HeaderWriteModel source){
        if(!itemRepository.existsById(id))
            throw new IllegalArgumentException("Header (ID:" + source.getProjectId() + ") is not exist");

        HeaderItem toSave = ViewFactory.toHeaderItem(source);
        toSave.setId(id);
        if(projectFasade.getSingle(source.getProjectId()) == null)
            throw new IllegalArgumentException("Project (ID:" + source.getProjectId() + ") is not exist");

        HeaderItem result = itemRepository.save(toSave);
        return ViewFactory.headerItemToDto(result);
    }
    public void delete(long id){
        itemRepository.deleteById(id);
    }

}

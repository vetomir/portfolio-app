package pl.gregorymartin.view.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.gregorymartin.post.dto.ProjectReadModel;

@Setter
@Getter
@Builder
public
class HeaderReadModel {
    private long id;
    private int priority;
    private long projectId;
    private ProjectReadModel project;
    private String background;
    private String style;
}

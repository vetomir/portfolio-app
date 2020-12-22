package pl.gregorymartin.view.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public
class HeaderWriteModel {
    private int priority;
    private long projectId;
    private String background;
    private String style;

    public HeaderWriteModel(final int priority, final long projectId, final String background, final String style) {
        this.priority = priority;
        this.projectId = projectId;
        this.background = background;
        this.style = style;
    }
}

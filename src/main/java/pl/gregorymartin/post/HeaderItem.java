package pl.gregorymartin.view;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
class HeaderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long projectId;
    private int priority = 0;
    private String background;
    private String style;

    public HeaderItem() {
    }

    HeaderItem(final long projectId, final int priority, final String background, final String style) {
        this.projectId = projectId;
        this.priority = priority;
        this.background = background;
        this.style = style;
    }
}

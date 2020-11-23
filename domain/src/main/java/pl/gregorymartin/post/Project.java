package pl.gregorymartin.post;

import pl.gregorymartin.tags.Tag;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String title;
    private String description;
    private String screenImgUrl;
    private String mobileImgUrl;
    private String websiteUrl;
    private String githubUrl;
    private String githubFrontUrl;
    private String todo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "projects_tags",
            joinColumns = @JoinColumn(
                    name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "tag_id", referencedColumnName = "id"))
    private Set<Tag> tags = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getScreenImgUrl() {
        return screenImgUrl;
    }

    public void setScreenImgUrl(final String screenImgUrl) {
        this.screenImgUrl = screenImgUrl;
    }

    public String getMobileImgUrl() {
        return mobileImgUrl;
    }

    public void setMobileImgUrl(final String mobileImgUrl) {
        this.mobileImgUrl = mobileImgUrl;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(final String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(final String githubUrl) {
        this.githubUrl = githubUrl;
    }

    public String getGithubFrontUrl() {
        return githubFrontUrl;
    }

    public void setGithubFrontUrl(final String githubFrontUrl) {
        this.githubFrontUrl = githubFrontUrl;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(final Set<Tag> tags) {
        this.tags = tags;
    }
}

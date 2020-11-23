package pl.gregorymartin.post.dto;


import java.util.List;

public
class ProjectReadModel {
    private long id;
    private String title;
    private String description;
    private String screenImgUrl;
    private String mobileImgUrl;
    private String websiteUrl;
    private String githubUrl;
    private String todo;
    private List<String> tags;

    public ProjectReadModel() {
    }

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

    public String getTodo() {
        return todo;
    }

    public void setTodo(final String todo) {
        this.todo = todo;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(final List<String> tags) {
        this.tags = tags;
    }
}

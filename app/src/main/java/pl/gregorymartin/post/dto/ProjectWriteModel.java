package pl.gregorymartin.post.dto;


import java.util.List;

public
class ProjectWriteModel {
    private String title;

    private String description;
    private String screenImgUrl;

    private String mobileImgUrl;

    private String websiteUrl;

    private String githubUrl;

    private String githubFrontEndUrl;

    private String todo;

    private List<String> tags;

    public ProjectWriteModel() {
    }

    public ProjectWriteModel(final String title, final String description, final String screenImgUrl, final String mobileImgUrl, final String websiteUrl, final String githubUrl, final String githubFrontEndUrl, final String todo, final List<String> tags) {
        this.title = title;
        this.description = description;
        this.screenImgUrl = screenImgUrl;
        this.mobileImgUrl = mobileImgUrl;
        this.websiteUrl = websiteUrl;
        this.githubUrl = githubUrl;
        this.githubFrontEndUrl = githubFrontEndUrl;
        this.todo = todo;
        this.tags = tags;
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

    public String getGithubFrontEndUrl() {
        return githubFrontEndUrl;
    }

    public void setGithubFrontEndUrl(final String githubFrontEndUrl) {
        this.githubFrontEndUrl = githubFrontEndUrl;
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

package testapp.jccolumbres.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubRepo {
    @SerializedName("name")
    private String repoName;

    @SerializedName("description")
    private String repoDesc;

    @SerializedName("language")
    private String repoLanguage;

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoDesc() {
        return repoDesc;
    }

    public void setRepoDesc(String repoDesc) {
        this.repoDesc = repoDesc;
    }

    public String getRepoLanguage() {
        return repoLanguage;
    }

    public void setRepoLanguage(String repoLanguage) {
        this.repoLanguage = repoLanguage;
    }

    public void GitHubRepo(String repoName,
                           String repoDesc,
                           String repoLanguage){
        this.setRepoName(repoName);
        this.setRepoDesc(repoDesc);
        this.setRepoLanguage(repoLanguage);
    }
}

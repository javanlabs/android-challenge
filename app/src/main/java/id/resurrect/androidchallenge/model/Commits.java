
package id.resurrect.androidchallenge.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Commits {

    @SerializedName("author")
    private id.resurrect.androidchallenge.model.Author Author;
    @SerializedName("comments_url")
    private String CommentsUrl;
    @SerializedName("commit")
    private id.resurrect.androidchallenge.model.Commit Commit;
    @SerializedName("committer")
    private id.resurrect.androidchallenge.model.Committer Committer;
    @SerializedName("html_url")
    private String HtmlUrl;
    @SerializedName("parents")
    private List<Parent> Parents;
    @SerializedName("sha")
    private String Sha;
    @SerializedName("url")
    private String Url;

    public id.resurrect.androidchallenge.model.Author getAuthor() {
        return Author;
    }

    public void setAuthor(id.resurrect.androidchallenge.model.Author author) {
        Author = author;
    }

    public String getCommentsUrl() {
        return CommentsUrl;
    }

    public void setCommentsUrl(String commentsUrl) {
        CommentsUrl = commentsUrl;
    }

    public id.resurrect.androidchallenge.model.Commit getCommit() {
        return Commit;
    }

    public void setCommit(id.resurrect.androidchallenge.model.Commit commit) {
        Commit = commit;
    }

    public id.resurrect.androidchallenge.model.Committer getCommitter() {
        return Committer;
    }

    public void setCommitter(id.resurrect.androidchallenge.model.Committer committer) {
        Committer = committer;
    }

    public String getHtmlUrl() {
        return HtmlUrl;
    }

    public void setHtmlUrl(String htmlUrl) {
        HtmlUrl = htmlUrl;
    }

    public List<Parent> getParents() {
        return Parents;
    }

    public void setParents(List<Parent> parents) {
        Parents = parents;
    }

    public String getSha() {
        return Sha;
    }

    public void setSha(String sha) {
        Sha = sha;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

}

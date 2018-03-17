package id.resurrect.androidchallenge.model;

import com.google.gson.annotations.SerializedName;

public class Commit {

    @SerializedName("author")
    private id.resurrect.androidchallenge.model.Author Author;
    @SerializedName("comment_count")
    private Long CommentCount;
    @SerializedName("committer")
    private id.resurrect.androidchallenge.model.Committer Committer;
    @SerializedName("message")
    private String Message;
    @SerializedName("tree")
    private id.resurrect.androidchallenge.model.Tree Tree;
    @SerializedName("url")
    private String Url;
    @SerializedName("verification")
    private id.resurrect.androidchallenge.model.Verification Verification;

    public id.resurrect.androidchallenge.model.Author getAuthor() {
        return Author;
    }

    public void setAuthor(id.resurrect.androidchallenge.model.Author author) {
        Author = author;
    }

    public Long getCommentCount() {
        return CommentCount;
    }

    public void setCommentCount(Long commentCount) {
        CommentCount = commentCount;
    }

    public id.resurrect.androidchallenge.model.Committer getCommitter() {
        return Committer;
    }

    public void setCommitter(id.resurrect.androidchallenge.model.Committer committer) {
        Committer = committer;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public id.resurrect.androidchallenge.model.Tree getTree() {
        return Tree;
    }

    public void setTree(id.resurrect.androidchallenge.model.Tree tree) {
        Tree = tree;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public id.resurrect.androidchallenge.model.Verification getVerification() {
        return Verification;
    }

    public void setVerification(id.resurrect.androidchallenge.model.Verification verification) {
        Verification = verification;
    }

}

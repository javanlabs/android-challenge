package id.resurrect.androidchallenge.api;

import java.util.List;

import id.resurrect.androidchallenge.model.Commits;
import id.resurrect.androidchallenge.model.Repository;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yoga Agung Kurnia on 3/17/2018.
 */

public interface Services {

    @GET("repos/laravolt/indonesia/commits")
    Call<List<Commits>> getCommits();

    @GET("repos/laravolt/indonesia")
    Call<Repository> getDetailRepository();
}

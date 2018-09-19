package testapp.jccolumbres.githubapi.rest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import testapp.jccolumbres.githubapi.model.GitHubUser;

public interface GitHubUserEndPoints {

    @GET("users/{user}")
    Call<GitHubUser> getUser (@Path("user") String user);
}

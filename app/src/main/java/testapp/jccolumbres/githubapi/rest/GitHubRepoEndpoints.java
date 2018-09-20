package testapp.jccolumbres.githubapi.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import testapp.jccolumbres.githubapi.model.GitHubRepo;

public interface GitHubRepoEndpoints {

    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> getRepos(@Path("user") String name);
}

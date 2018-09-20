package testapp.jccolumbres.githubapi.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import testapp.jccolumbres.githubapi.R;
import testapp.jccolumbres.githubapi.adapters.RepoAdapter;
import testapp.jccolumbres.githubapi.model.GitHubRepo;
import testapp.jccolumbres.githubapi.rest.APIClient;
import testapp.jccolumbres.githubapi.rest.GitHubRepoEndpoints;

public class Repositories extends AppCompatActivity {

    String receivedName;
    TextView username;

    RecyclerView myRecyclerView;
    RecyclerView.Adapter myAdapter;
    List<GitHubRepo> dataSource = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositories);

        Bundle extras = getIntent().getExtras();

        username = (TextView)findViewById(R.id.tvUsername);
        receivedName = extras.getString("username");
        username.setText(receivedName);

        myRecyclerView = (RecyclerView) findViewById(R.id.rv_repos);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new RepoAdapter(dataSource,R.layout.list_item_repo,getApplicationContext());
        myRecyclerView.setAdapter(myAdapter);

        loadRepositories();

    }


    public void loadRepositories(){
        GitHubRepoEndpoints apiService =
                APIClient.getClient().create(GitHubRepoEndpoints.class);
        Call<List<GitHubRepo>> call = apiService.getRepos(receivedName);
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                dataSource.clear();
                dataSource.addAll(response.body());
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {

            }
        });
    }

}

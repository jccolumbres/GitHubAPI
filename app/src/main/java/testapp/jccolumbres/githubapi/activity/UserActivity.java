package testapp.jccolumbres.githubapi.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import testapp.jccolumbres.githubapi.R;
import testapp.jccolumbres.githubapi.model.GitHubUser;
import testapp.jccolumbres.githubapi.helpers.ImageDownloader;
import testapp.jccolumbres.githubapi.rest.APIClient;
import testapp.jccolumbres.githubapi.rest.GitHubUserEndPoints;

public class UserActivity extends AppCompatActivity{

    private ImageView avatar;
    private Bitmap myImage;
    private TextView username,followers,following,logIn,email,type;
    private Button loadOwnedRepos;
    String newString;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle extras = getIntent().getExtras();

        newString = extras.getString("Sample");
        Toast.makeText(this,newString,Toast.LENGTH_SHORT).show();
        avatar = (ImageView)findViewById(R.id.ivAvatar);
        username = (TextView) findViewById(R.id.tvUsername);
        followers = (TextView) findViewById(R.id.tvFollowers);
        following = (TextView) findViewById(R.id.tvFollowing);
        logIn = (TextView) findViewById(R.id.tvLogin);
        email = (TextView) findViewById(R.id.tvEmail);
        type = (TextView) findViewById(R.id.tvType);
        loadOwnedRepos = (Button) findViewById(R.id.btnOwnedRepos);
        loadData();
    }


    public void loadData(){
        final GitHubUserEndPoints apiService =
                APIClient.getClient().create(GitHubUserEndPoints.class);
        Call<GitHubUser> call = apiService.getUser(newString);
        call.enqueue(new Callback<GitHubUser>() {
            @Override
            public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {

                ImageDownloader task = new ImageDownloader();

                try {
                    myImage = task.execute(response.body().getAvatar()).get();
                }catch (Exception e){
                    e.printStackTrace();
                }
                avatar.setImageBitmap(myImage);
                avatar.getLayoutParams().height=220;
                avatar.getLayoutParams().width=220;

                if (response.body().getName() == null){
                    username.setText("No information given");
                }else {
                    username.setText(response.body().getName());
                }
                followers.setText(response.body().getFollowers());
                following.setText(response.body().getFollowing());
                logIn.setText(response.body().getLogin());

                if (response.body().getEmail() == null){
                    email.setText("No information given");
                }else{
                    email.setText(response.body().getEmail());
                }
                type.setText(response.body().getType());

            }

            @Override
            public void onFailure(Call<GitHubUser> call, Throwable t) {

            }
        });
    }
}



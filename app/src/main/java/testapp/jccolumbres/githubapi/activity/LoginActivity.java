package testapp.jccolumbres.githubapi.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import testapp.jccolumbres.githubapi.R;

public class LoginActivity extends AppCompatActivity {

    private EditText inputUsername;
    private Button login;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputUsername = (EditText) findViewById(R.id.etInputUsername);
        login = (Button) findViewById(R.id.btnLogin);

    }

    public void getUser(View view){
        i = new Intent(this,UserActivity.class);
        i.putExtra("Sample",inputUsername.getText().toString());
        startActivity(i);
    }
}

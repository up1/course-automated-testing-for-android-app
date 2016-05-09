package demo.somkiat.demomocking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import demo.somkiat.demomocking.normal.GitHubTask;
import demo.somkiat.demomocking.retrofit2.Contributor;
import demo.somkiat.demomocking.retrofit2.GitHubService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GithubTaskListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mocking demo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                loadDataWithRetrofit2();
                loadDataFromHttpURLConnection();
            }
        });
    }

    private void loadDataFromHttpURLConnection() {
        new GitHubTask(this).execute("http://www.google.com");
    }

    private void loadDataWithRetrofit2() {
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        final Call<List<Contributor>> call =
                gitHubService.repoContributors("square", "retrofit");
        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                final TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Call<List<Contributor>> call, Throwable t) {
                final TextView textView = (TextView) findViewById(R.id.textView);
                textView.setText("onFailure");
            }

        });
    }

    @Override
    public void showResult(String result) {
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result);
    }
}

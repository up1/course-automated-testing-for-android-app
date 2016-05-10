package demo.somkiat.demomocking;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.List;

import demo.somkiat.demomocking.normal.GitHubTask;
import demo.somkiat.demomocking.retrofit2.Contributor;
import demo.somkiat.demomocking.retrofit2.GitHubService;
import demo.somkiat.demomocking.retrofit2.MyURL;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
                loadDataWithRetrofit2();
//                loadDataFromHttpURLConnection();
            }
        });
    }

    public void loadDataFromHttpURLConnection() {
        new GitHubTask(this).execute("http://www.google.com");
    }

    private Retrofit retrofit;

    public void loadDataWithRetrofit2() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyURL.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GitHubService gitHubService = retrofit.create(GitHubService.class);
        final Call<List<Contributor>> call =
                gitHubService.repoContributors("square", "retrofit");

        call.enqueue(new Callback<List<Contributor>>() {
            @Override
            public void onResponse(Call<List<Contributor>> call, Response<List<Contributor>> response) {
                final TextView textView = (TextView) findViewById(R.id.textView);
                if (response.isSuccessful()) {
                    textView.setText(response.body().toString());
                } else {
                    try {
                        Converter<ResponseBody, Contributor> errorConverter = retrofit.responseBodyConverter(Contributor.class, new Annotation[0]);
                        Contributor contributor = errorConverter.convert(response.errorBody());
                        textView.setText(contributor.toString());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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

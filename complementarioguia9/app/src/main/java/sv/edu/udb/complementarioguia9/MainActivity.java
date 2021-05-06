package sv.edu.udb.complementarioguia9;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class MainActivity extends AppCompatActivity {

    ListView repoListView;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        repoListView = findViewById(R.id.repo_list);
        progressBar = findViewById(R.id.pb_main);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create());


        Retrofit retrofit = builder.build();
        ApiGithub gitHubUser = retrofit.create(ApiGithub.class);
        Call<List<GitResponses>> call =  gitHubUser.repoForUser("erikagomez15");
        call.enqueue(new Callback<List<GitResponses>>() {
            @Override
            public void onResponse(Call<List<GitResponses>> call, Response<List<GitResponses>> response) {

                progressBar.setVisibility(View.INVISIBLE);
                List<GitResponses> list = response.body();
                GitAdapter arrayAdapter = new GitAdapter(MainActivity.this,list);
                repoListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<GitResponses>> call, Throwable t) {

                progressBar.setVisibility(View.INVISIBLE);

            }
        });

    }

}
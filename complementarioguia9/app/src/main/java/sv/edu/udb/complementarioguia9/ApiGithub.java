package sv.edu.udb.complementarioguia9;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiGithub {

    @GET("/users/{user}/repos")
    Call<List<GitResponses>> repoForUser(@Path("user") String user);



}

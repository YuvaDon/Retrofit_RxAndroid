package yuva_dondapati.demos.android.daggerretrofit.retrofit;


import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import yuva_dondapati.demos.android.daggerretrofit.model.Post;

public interface MyAPI {
    @GET("photos")
    Observable<List<Post>> getPosts();
}

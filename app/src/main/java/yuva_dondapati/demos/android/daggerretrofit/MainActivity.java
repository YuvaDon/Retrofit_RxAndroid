package yuva_dondapati.demos.android.daggerretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yuva_dondapati.demos.android.daggerretrofit.adapter.PostViewAdapter;
import yuva_dondapati.demos.android.daggerretrofit.model.Post;
import yuva_dondapati.demos.android.daggerretrofit.retrofit.MyAPI;
import yuva_dondapati.demos.android.daggerretrofit.retrofit.MyClient;

public class MainActivity extends AppCompatActivity {

   MyAPI myAPI;
   CompositeDisposable disposable = new CompositeDisposable();
   RecyclerView recyclerView;
   PostViewAdapter postViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerviews
        recyclerView = (RecyclerView)findViewById(R.id.rv1);

        //init API
        Retrofit retrofit = MyClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);
       
        fetchData();
    }

    private void fetchData() {
        disposable.add(myAPI.getPosts()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<List<Post>>() {
            @Override
            public void accept(List<Post> posts) {
                Log.d("TAG", "success");
                displayData(posts);
            }
        }));

    }

    private void displayData(List<Post> posts) {
        Log.d("TAG", "posts 0" +posts.get(0));
        postViewAdapter = new PostViewAdapter(this, posts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postViewAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        disposable.clear();
    }
}
     /*   Observable<String> animalObservable = getObservables();

        Observer<String> animalObserver = getObserver();

        animalObservable.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<String>() {
                    @Override
                    public boolean test(String s) throws Exception {
                        return s.toLowerCase().startsWith("b");
                    }
                })
                .subscribe(animalObserver);


    }

    private Observer<String> getObserver() {
        return  new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("Yuva", "in onsubscribe");
                disposable = d;
            }

            @Override
            public void onNext(String s) {
                Log.d("Yuva", "in onnext" +s);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Yuva", "in onError");
            }

            @Override
            public void onComplete() {
                Log.d("Yuva", "in onComplete");
            }
        };
    }

    private Observable<String> getObservables() {

     return Observable.just("ant","bee", "Cat", "Dog", "Fox", "bbbb", "braddkfjd");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // don't send events once the activity is destroyed
        disposable.dispose();
    }*/
  

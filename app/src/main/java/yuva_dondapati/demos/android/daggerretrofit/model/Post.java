package yuva_dondapati.demos.android.daggerretrofit.model;

public class Post {
    public  int userId;
    public  String title;
    public  int id;
    public String imageUrl;

    public Post(){

    }

    public Post(int userId, String title, int id, String imageUrl) {
        this.userId = userId;
        this.title = title;
        this.id = id;
        this.imageUrl = imageUrl;
    }
}

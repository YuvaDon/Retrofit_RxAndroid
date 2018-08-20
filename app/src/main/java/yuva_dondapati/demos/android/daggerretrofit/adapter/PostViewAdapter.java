package yuva_dondapati.demos.android.daggerretrofit.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import yuva_dondapati.demos.android.daggerretrofit.R;
import yuva_dondapati.demos.android.daggerretrofit.model.Post;

public class PostViewAdapter extends RecyclerView.Adapter<PostviewViewHolder> {
    List<Post> list;
    Context context;

    public PostViewAdapter(Context context, List<Post> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public PostviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v = inflater.inflate(R.layout.post_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PostviewViewHolder vh = new PostviewViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PostviewViewHolder holder, int position) {
   // holder.id.setText(String.valueOf(list.get(position).id));
        Log.d("TAG", list.get(position).toString()+"onbind");
        holder.id.setText(String.valueOf(list.get(position).userId));
        holder.title.setText(String.valueOf(list.get(position).title));
        holder.body.setText(String.valueOf(list.get(position).id));
        String url = list.get(position).imageUrl;
        Picasso.with(context).load(url).fit().centerCrop()
                .placeholder(R.drawable.retroplusrx)
                .error(R.drawable.retroplusrx)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        Log.d("TAG", "size"+list.size());
        return list.size();
    }
}

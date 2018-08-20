package yuva_dondapati.demos.android.daggerretrofit.adapter;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import yuva_dondapati.demos.android.daggerretrofit.R;

public class PostviewViewHolder extends RecyclerView.ViewHolder {
    TextView title, id, body;
    ImageView imageView;
    public PostviewViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.tv1);
        id = itemView.findViewById(R.id.tv2);
        body = itemView.findViewById(R.id.tv3);
        imageView = itemView.findViewById(R.id.imageview);
    }
}

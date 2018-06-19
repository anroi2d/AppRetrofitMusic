package layout.example.anroi2d.appretrofitmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.model.AlbumCurrentDay;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder>{
    Context context;
    ArrayList<AlbumCurrentDay> mangalbum;

    public AlbumAdapter(Context context, ArrayList<AlbumCurrentDay> mangalbum) {
        this.context = context;
        this.mangalbum = mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumCurrentDay album = mangalbum.get(position);
        holder.tvTenAlbum.setText(album.getTenAlbum());
        holder.tvTenCasiAlbum.setText(album.getTenCasiAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(holder.imgAlbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAlbum;
        TextView tvTenAlbum,tvTenCasiAlbum;

        public ViewHolder(View itemView) {
            super(itemView);
            imgAlbum = (ImageView) itemView.findViewById(R.id.imageviewalbum);
            tvTenAlbum = (TextView) itemView.findViewById(R.id.tv_ten_album);
            tvTenCasiAlbum = (TextView) itemView.findViewById(R.id.tv_tencasi_album);
        }
    }
}

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
import layout.example.anroi2d.appretrofitmusic.model.Baihatyeuthich;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder>{
    Context context;
    ArrayList<Baihatyeuthich> baihatArrayList;

    public BaihathotAdapter(Context context, ArrayList<Baihatyeuthich> baihatArrayList) {
        this.context = context;
        this.baihatArrayList = baihatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_baihathot,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Baihatyeuthich baihat = baihatArrayList.get(position);
        holder.tvTen.setText(baihat.getTenbaihat());
        holder.tvCasi.setText(baihat.getCasi());
        Picasso.with(context).load(baihat.getHinhbaihat()).into(holder.imgHinh);
    }

    @Override
    public int getItemCount() {
        return baihatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTen,tvCasi;
        ImageView imgHinh,imgLuotthich;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTen = itemView.findViewById(R.id.tv_ten_baihathot);
            tvCasi = itemView.findViewById(R.id.tv_tencasi_baihathot);
            imgHinh = itemView.findViewById(R.id.img_baihathot);
            imgLuotthich = itemView.findViewById(R.id.img_luotthich);

        }
    }
}

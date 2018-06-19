package layout.example.anroi2d.appretrofitmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.model.Quangcao;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListQuangcao ;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListQuangcao) {
        this.context = context;
        this.arrayListQuangcao = arrayListQuangcao;
    }

    @Override
    public int getCount() {
        return arrayListQuangcao.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
    //dinh hinh va lay du lieu


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
                LayoutInflater inflater = LayoutInflater.from(context);
                View view = inflater.inflate(R.layout.dong_banner,null);
        ImageView imageViewbgBanner = (ImageView) view.findViewById(R.id.imagebgBanner);
        ImageView imageViewSongBanner = (ImageView) view.findViewById(R.id.imv_banner);
        TextView tvTitleSongbanner = (TextView) view.findViewById(R.id.tv_title_bannerbh);
        TextView tvBannerNoiDung = (TextView) view.findViewById(R.id.tvbannerNoidung);

        Picasso.with(context).load(arrayListQuangcao.get(position).getHinhanh()).into(imageViewbgBanner);
        Picasso.with(context).load(arrayListQuangcao.get(position).getHinhBaiHat()).into(imageViewSongBanner);
        tvTitleSongbanner.setText(arrayListQuangcao.get(position).getTenBaiHat());
        tvBannerNoiDung.setText(arrayListQuangcao.get(position).getNoiDung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "da click ", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context, DanhSachBaiHat_Activity.class);
//                intent.putExtra("banner",arrayListQuangcao.get(position).getIdQuangCao());
//                context.startActivity(intent);
            }

        });

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

package layout.example.anroi2d.appretrofitmusic.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.adapter.BannerAdapter;
import layout.example.anroi2d.appretrofitmusic.model.Quangcao;
import layout.example.anroi2d.appretrofitmusic.service.ApiService;
import layout.example.anroi2d.appretrofitmusic.service.DataService;
import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_quangcao extends Fragment {
    View view;
    ViewPager viewPager;
    CircleIndicator circleIndicator;
    BannerAdapter bannerAdapter;

    Runnable runnable;
    Handler handler;
    int currentItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_banner,container,false);
        getData();
        anhxa();
        return view;
    }

    private void anhxa() {
        viewPager= (ViewPager) view.findViewById(R.id.viewpager);
        circleIndicator= (CircleIndicator) view.findViewById(R.id.indicatordefault);
    }

    private void getData() {
        DataService dataService = ApiService.getService();
        Call<List<Quangcao>> comeback = dataService.getDataBanner();
        comeback.enqueue(new Callback<List<Quangcao>>() {
            @Override
            public void onResponse(Call<List<Quangcao>> call, Response<List<Quangcao>> response) {
                ArrayList<Quangcao> banners = (ArrayList<Quangcao>) response.body();
//                Log.d("BBB",banners.get(0).getTenBaiHat());
                bannerAdapter = new BannerAdapter(getActivity(),banners);
                viewPager.setAdapter(bannerAdapter);
                circleIndicator.setViewPager(viewPager);
                handler = new Handler();
                runnable = new Runnable() {
                    @Override
                    public void run() {
                        currentItem = viewPager.getCurrentItem();
                        currentItem++;
                        if(currentItem >= viewPager.getAdapter().getCount()){
                            currentItem =0;
                        }
                        viewPager.setCurrentItem(currentItem,true);
                        handler.postDelayed(runnable,4500);
                    }
                };
                handler.postDelayed(runnable,4500);

            }

            @Override
            public void onFailure(Call<List<Quangcao>> call, Throwable t) {

            }
        });
    }
}

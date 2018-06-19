package layout.example.anroi2d.appretrofitmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.adapter.BaihathotAdapter;
import layout.example.anroi2d.appretrofitmusic.model.Baihatyeuthich;
import layout.example.anroi2d.appretrofitmusic.service.ApiService;
import layout.example.anroi2d.appretrofitmusic.service.DataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_baihat_yeuthich extends Fragment{
    View view;
    RecyclerView recyclerViewbaihathot;
    BaihathotAdapter baihathotAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_baihat_yeuthich,container,false);
        recyclerViewbaihathot = view.findViewById(R.id.recyclebaihathot);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = ApiService.getService();
        Call<List<Baihatyeuthich>> callback = dataService.getBaihatyeuthich();
        callback.enqueue(new Callback<List<Baihatyeuthich>>() {
            @Override
            public void onResponse(Call<List<Baihatyeuthich>> call, Response<List<Baihatyeuthich>> response) {
                ArrayList<Baihatyeuthich> baihatyeuthich = (ArrayList<Baihatyeuthich>) response.body();
//                Log.d("BBB",baihatyeuthich.get(0).getTenbaihat());
                baihathotAdapter = new BaihathotAdapter(getActivity(),baihatyeuthich);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewbaihathot.setLayoutManager(linearLayoutManager);
                recyclerViewbaihathot.setAdapter(baihathotAdapter);
            }

            @Override
            public void onFailure(Call<List<Baihatyeuthich>> call, Throwable t) {

            }
        });
    }
}

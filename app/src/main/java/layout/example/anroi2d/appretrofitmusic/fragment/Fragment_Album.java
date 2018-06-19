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
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.adapter.AlbumAdapter;
import layout.example.anroi2d.appretrofitmusic.model.AlbumCurrentDay;
import layout.example.anroi2d.appretrofitmusic.service.ApiService;
import layout.example.anroi2d.appretrofitmusic.service.DataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Album extends Fragment {
    View view;
    RecyclerView recyclerViewAlbum;
    TextView tvXemthemAlbum;
    AlbumAdapter albumAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_album,container,false);
        recyclerViewAlbum = view.findViewById(R.id.recycleViewAlbum);
        tvXemthemAlbum = view.findViewById(R.id.tv_xemthem_album);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = ApiService.getService();
        Call<List<AlbumCurrentDay>> callback = dataService.getAlbumCurrentDay();
        callback.enqueue(new Callback<List<AlbumCurrentDay>>() {
            @Override
            public void onResponse(Call<List<AlbumCurrentDay>> call, Response<List<AlbumCurrentDay>> response) {
                ArrayList<AlbumCurrentDay> albumCurrentDays = (ArrayList<AlbumCurrentDay>) response.body();
//                Log.d("BBB",albumCurrentDays.get(0).getTenAlbum());
                albumAdapter = new AlbumAdapter(getActivity(),albumCurrentDays);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);
                recyclerViewAlbum.setLayoutManager(linearLayoutManager);
                recyclerViewAlbum.setAdapter(albumAdapter);

            }

            @Override
            public void onFailure(Call<List<AlbumCurrentDay>> call, Throwable t) {

            }
        });
    }
}

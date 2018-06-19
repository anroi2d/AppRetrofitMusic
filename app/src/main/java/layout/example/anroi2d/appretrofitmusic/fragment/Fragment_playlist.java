package layout.example.anroi2d.appretrofitmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.adapter.PlaylistAdapter;
import layout.example.anroi2d.appretrofitmusic.model.Playlist;
import layout.example.anroi2d.appretrofitmusic.service.ApiService;
import layout.example.anroi2d.appretrofitmusic.service.DataService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_playlist extends Fragment {
    View view;
    ListView lvplaylist;
    TextView tvTitlePlaylist,tvXemThemPlaylist;
    ArrayList<Playlist> mangPlaylist;
    PlaylistAdapter playlistAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_playlist,container,false);
        tvTitlePlaylist = (TextView) view.findViewById(R.id.tv_title_playlist);
        tvXemThemPlaylist= (TextView) view.findViewById(R.id.tv_viewmore_playlist);
        lvplaylist= (ListView) view.findViewById(R.id.listview_playlist);
        GetData();
        return view;
    }

    private void GetData() {
        DataService dataService = ApiService.getService();
        Call<List<Playlist>> callback = dataService.getPlaylistCurrentDay();
        callback.enqueue(new Callback<List<Playlist>>() {
            @Override
            public void onResponse(Call<List<Playlist>> call, Response<List<Playlist>> response) {
                mangPlaylist = (ArrayList<Playlist>) response.body();
//                Log.d("BBB",mangPlaylist.get(0).getTen());
                playlistAdapter = new PlaylistAdapter(getActivity(),android.R.layout.simple_list_item_1,mangPlaylist);
                lvplaylist.setAdapter(playlistAdapter);
                setListViewHeightBasedOnChildren(lvplaylist);
            }

            @Override
            public void onFailure(Call<List<Playlist>> call, Throwable t) {

            }
        });
    }
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desireWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem!=null){
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.MATCH_PARENT));
                listItem.measure(desireWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();
            }

        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}

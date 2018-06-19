package layout.example.anroi2d.appretrofitmusic.service;

import java.util.List;

import layout.example.anroi2d.appretrofitmusic.model.AlbumCurrentDay;
import layout.example.anroi2d.appretrofitmusic.model.Baihatyeuthich;
import layout.example.anroi2d.appretrofitmusic.model.Playlist;
import layout.example.anroi2d.appretrofitmusic.model.Quangcao;
import layout.example.anroi2d.appretrofitmusic.model.Theloaitrongngay;
import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET("songbanner.php")
    Call<List<Quangcao>> getDataBanner();

    @GET("playlistforcurrentday.php")
    Call<List<Playlist>> getPlaylistCurrentDay();

    @GET("chudevatheloaitrongngay.php")
    Call<Theloaitrongngay> getTheloaiCurrentDay();

    @GET("albumhot.php")
    Call<List<AlbumCurrentDay>> getAlbumCurrentDay();

    @GET("baihatyeuthich.php")
    Call<List<Baihatyeuthich>> getBaihatyeuthich();
}

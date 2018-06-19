package layout.example.anroi2d.appretrofitmusic.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import layout.example.anroi2d.appretrofitmusic.R;
import layout.example.anroi2d.appretrofitmusic.model.Playlist;

public class PlaylistAdapter extends ArrayAdapter<Playlist> {
    public PlaylistAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }
    class ViewHoder{
        TextView tvtenplaylist;
        ImageView imgbackground,imgplaylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoder viewHoder= null;
        if(convertView==null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHoder = new ViewHoder();
            viewHoder.tvtenplaylist = (TextView) convertView.findViewById(R.id.tv_ten_playlist);
            viewHoder.imgplaylist= (ImageView) convertView.findViewById(R.id.imgv_playlist);
            viewHoder.imgbackground = (ImageView) convertView.findViewById(R.id.imgv_bg_playlist);
            convertView.setTag(viewHoder);
        }else{
            viewHoder = (ViewHoder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.with(getContext()).load(playlist.getHinhPlaylist()).into(viewHoder.imgbackground);
        Picasso.with(getContext()).load(playlist.getIcon()).into(viewHoder.imgplaylist);
        viewHoder.tvtenplaylist.setText(playlist.getTen());
        return convertView;
    }
}

package layout.example.anroi2d.appretrofitmusic;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.example.anroi2d.appretrofitmusic.adapter.MainViewPagerAdapter;
import layout.example.anroi2d.appretrofitmusic.fragment.Fragment_timkiem;
import layout.example.anroi2d.appretrofitmusic.fragment.Fragment_trangchu;

public class MainActivity extends AppCompatActivity {
    MainViewPagerAdapter mainViewPagerAdapter;
    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= (ViewPager) findViewById(R.id.myviewpager);
        tabLayout= (TabLayout) findViewById(R.id.mytablayout);

        mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_trangchu(),"Trang chủ");
        mainViewPagerAdapter.addFragment(new Fragment_timkiem(),"Tìm kiếm");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }
}

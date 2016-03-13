package cn.mycommons.tablayoutplus;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.mycommons.tablayoutplus.library.BadgedTabCustomView;
import cn.mycommons.tablayoutplus.library.TabLayoutPlus;

public class ViewPagerActivity extends AppCompatActivity {

    @Bind(R.id.tabLayout)
    TabLayoutPlus tabLayout;
    @Bind(R.id.viewPager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        ButterKnife.bind(this);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                return new DemoFragment();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return "Title" + position;
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        for (int i = 0; i < adapter.getCount(); i++) {
            BadgedTabCustomView customView = tabLayout.getTabCustomViewAt(i);
            if (customView != null) {
                customView.setTabSubText("SubTitle");
                customView.setTabCount(i);
            }
        }
    }
}
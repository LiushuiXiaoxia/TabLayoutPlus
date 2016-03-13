package cn.mycommons.tablayoutplus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.viewPager)
    void onViewPagerClick() {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    @OnClick(R.id.tabLayout)
    void onTabLayoutClick() {
        startActivity(new Intent(this, TabLayoutActivity.class));
    }

    @OnClick(R.id.icon)
    void onIconClick() {
        startActivity(new Intent(this, IconActivity.class));
    }
}

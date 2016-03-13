package cn.mycommons.tablayoutplus;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.mycommons.tablayoutplus.library.BadgedTabCustomView;
import cn.mycommons.tablayoutplus.library.TabLayoutPlus;

public class TabLayoutActivity extends AppCompatActivity {

    @Bind(R.id.tabLayout)
    TabLayoutPlus tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);

        tabLayout.addTab(tabLayout.newTabPlus());
        tabLayout.addTab(tabLayout.newTabPlus());
        tabLayout.addTab(tabLayout.newTabPlus());

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            BadgedTabCustomView customView = tabLayout.getTabCustomViewAt(i);
            if (customView != null) {
                customView.setTabText("Tab" + (i + 1));
                customView.setTabCount(i);
            }
        }

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(TabLayoutActivity.this, tab.getText() + " selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}

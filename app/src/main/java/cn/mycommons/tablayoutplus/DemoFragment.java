package cn.mycommons.tablayoutplus;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * DemoFragment <br/>
 * Created by xiaqiulei on 2016-03-12.
 */
public class DemoFragment extends Fragment {

    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        ButterKnife.bind(this, view);

        Random random = new Random();
        linearLayout.setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
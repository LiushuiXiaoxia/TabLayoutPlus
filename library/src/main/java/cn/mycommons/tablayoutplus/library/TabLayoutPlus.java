package cn.mycommons.tablayoutplus.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.TypedValue;

/**
 * TabLayoutPlus <br/>
 * Created by xiaqiulei on 2016-03-12.
 */
public class TabLayoutPlus extends TabLayout {

    static final int DEFAULT_COUNTCOLOR = Color.WHITE;

    float subTextSize;
    int countTextColor;
    float countTextSize;
    Drawable countTextBackground;

    public TabLayoutPlus(Context context) {
        super(context);
    }

    public TabLayoutPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);

    }

    public TabLayoutPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs,
                R.styleable.TabLayoutPlus,
                defStyleAttr,
                R.style.TabLayoutPlus_DAFULT
        );

        subTextSize = typedArray.getDimensionPixelSize(R.styleable.TabLayoutPlus_subTextSize, 0);

        countTextColor = typedArray.getColor(R.styleable.TabLayoutPlus_countTextColor, DEFAULT_COUNTCOLOR);
        countTextSize = typedArray.getDimensionPixelSize(R.styleable.TabLayoutPlus_subTextSize, 0);
        countTextBackground = typedArray.getDrawable(R.styleable.TabLayoutPlus_countTextBackground);

        typedArray.recycle();
    }

    @Override
    public final void setupWithViewPager(@Nullable ViewPager viewPager) {
        super.setupWithViewPager(viewPager);

        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        PagerAdapter adapter = viewPager.getAdapter();
        for (int i = 0; i < adapter.getCount(); i++) {
            TabLayout.Tab tab = getTabAt(i);
            if (tab != null) {
                BadgedTabCustomView view = initTab(tab);
                view.setSelected(i == 0);
            }
        }
    }

    private BadgedTabCustomView initTab(TabLayout.Tab tab) {
        BadgedTabCustomView customView = new BadgedTabCustomView(getContext());
        customView.tvTabText.setTextColor(getTabTextColors());
        customView.tvTabSubText.setTextColor(getTabTextColors());
        if (subTextSize > 0) {
            customView.tvTabSubText.setTextSize(TypedValue.COMPLEX_UNIT_PX, subTextSize);
        }

        customView.tvTabCount.setTextColor(countTextColor);
        if (countTextSize > 0) {
            customView.tvTabCount.setTextSize(TypedValue.COMPLEX_UNIT_PX, countTextSize);
        }
        customView.tvTabCount.setBackgroundDrawable(countTextBackground);
        customView.setTabText(tab.getText());

        tab.setCustomView(customView);

        return customView;
    }

    public Tab newTabPlus() {
        Tab tab = super.newTab();
        initTab(tab);
        return tab;
    }

    @Nullable
    public final BadgedTabCustomView getTabCustomViewAt(int index) {
        Tab tab = getTabAt(index);
        if (tab != null && tab.getCustomView() instanceof BadgedTabCustomView) {
            return (BadgedTabCustomView) tab.getCustomView();
        }
        return null;
    }
}
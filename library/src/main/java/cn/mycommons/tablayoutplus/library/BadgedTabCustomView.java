package cn.mycommons.tablayoutplus.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class BadgedTabCustomView extends RelativeLayout {

    ImageView ivTabIcon;
    TextView tvTabText;
    TextView tvTabSubText;
    TextView tvTabCount;


    public BadgedTabCustomView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        View.inflate(context, R.layout.tablayoutplus_custom_view, this);
        ivTabIcon = (ImageView) findViewById(R.id.ivTabIcon);
        tvTabText = (TextView) findViewById(R.id.tvTabText);
        tvTabSubText = (TextView) findViewById(R.id.tvTabSubText);
        tvTabCount = (TextView) findViewById(R.id.tvTabCount);

        setTabText(null);
        setTabCount(0);
    }

    public void setTabCount(int count) {
        if (count > 0) {
            tvTabCount.setText(String.valueOf(count));
        } else {
            tvTabCount.setText(null);

        }
        tvTabCount.setVisibility(count > 0 ? View.VISIBLE : View.GONE);
    }

    public void setTabText(CharSequence text) {
        tvTabText.setText(text);
        tvTabText.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
    }

    public void setTabSubText(CharSequence text) {
        tvTabSubText.setText(text);
        tvTabSubText.setVisibility(TextUtils.isEmpty(text) ? View.GONE : View.VISIBLE);
    }

    public void setTabIcon(int resId) {
        ivTabIcon.setImageResource(resId);
        ivTabIcon.setVisibility(resId > 0 ? View.VISIBLE : View.GONE);
    }

    public void setTabIcon(Uri uri) {
        ivTabIcon.setImageURI(uri);
        ivTabIcon.setVisibility(uri != null ? View.VISIBLE : View.GONE);
    }

    public void setTabIcon(Drawable drawable) {
        ivTabIcon.setImageDrawable(drawable);
        ivTabIcon.setVisibility(drawable != null ? View.VISIBLE : View.GONE);
    }

    public void setTabIcon(Bitmap bm) {
        ivTabIcon.setImageBitmap(bm);
        ivTabIcon.setVisibility(bm != null ? View.VISIBLE : View.GONE);
    }

    public ImageView getTabIcon() {
        return ivTabIcon;
    }

    public TextView getTabText() {
        return tvTabText;
    }

    public TextView getTabSubText() {
        return tvTabSubText;
    }

    public TextView getTabCount() {
        return tvTabCount;
    }
}
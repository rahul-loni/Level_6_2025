package com.example.otp_auth;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context context;
    public  int[] Images={
            R.drawable.add,
            R.drawable.bal,
            R.drawable.dip,
            R.drawable.p2,
            R.drawable.p1,
            R.drawable.log};
    public ImageAdapter (Context context){
        this.context=context;
    }
    @Override
    public int getCount() {
        return Images.length;
    }
    @Override
    public Object getItem(int i) {
        return Images[i];
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView=new ImageView(context);
        imageView.setScaleType(imageView.getScaleType());
        imageView.setImageResource(Images[i]);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(150,150));
        return imageView;
    }
}

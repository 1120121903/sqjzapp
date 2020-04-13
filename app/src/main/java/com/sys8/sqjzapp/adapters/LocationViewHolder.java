package com.sys8.sqjzapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

public class LocationViewHolder extends BaseViewHolder {
        private TextView tvTimeLineText;
        private ImageView imageUser;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTimeLineText = itemView.findViewById(R.id.item_timeline_text);
        imageUser = itemView.findViewById(R.id.item_location_img);

    }

    @Override
    void setData(TimelineItem item) {
        LocationItem locationItem = item.getLocationItem();
        tvTimeLineText.setText(locationItem.getTimeLineText());

        if(locationItem.getImgUserBitMap()!=null){
            imageUser.setImageBitmap(locationItem.getImgUserBitMap());
        }else{
            Glide.with(itemView.getContext()).load(locationItem.getImgUser()).into(imageUser);
        }
    }
}

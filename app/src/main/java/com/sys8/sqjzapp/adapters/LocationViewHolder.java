package com.sys8.sqjzapp.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.sys8.sqjzapp.R;
import com.sys8.sqjzapp.module.LocationItem;
import com.sys8.sqjzapp.module.TimelineItem;

public class LocationViewHolder extends BaseViewHolder {
        private TextView tvAddress;
        private TextView tvTime;
        private ImageView imageUser;

    public LocationViewHolder(@NonNull View itemView) {
        super(itemView);
        tvTime = itemView.findViewById(R.id.item_location_time_text);
        tvAddress = itemView.findViewById(R.id.item_location_address);
        imageUser = itemView.findViewById(R.id.item_location_img);

    }

    @Override
    void setData(TimelineItem item) {
        LocationItem locationItem = item.getLocationItem();
        tvAddress.setText(locationItem.getAddress());
        tvTime.setText(locationItem.getTime());
       // Glide.with();
        //imageUser.setImageBitmap(itemView.getContext().load(locationItem.getImgUser()));
    }
}

package com.amap.map3d.demo.route;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.TextureMapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.services.route.DrivePath;
import com.amap.map3d.demo.R;
import com.amap.map3d.demo.util.AMapUtil;
import com.amap.map3d.demo.util.ToastUtil;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixin on 2018/4/24.
 */

class StrategyAdapter extends RecyclerView.Adapter<StrategyAdapter.ViewHolder> {
    private  List<DrivePath> mDrivePathList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle,tvTime,tvDistance;

        public ViewHolder (View view)
        {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvTime = (TextView) view.findViewById(R.id.tvTime);
            tvDistance = (TextView) view.findViewById(R.id.tvDistance);
        }

    }

    public StrategyAdapter (List <DrivePath> DrivePathList){
        mDrivePathList = DrivePathList;
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_strategy,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DrivePath drivePath = mDrivePathList.get(position);
        int dis = (int) drivePath.getDistance();
        int dur = (int) drivePath.getDuration();
        holder.tvTitle.setText(drivePath.getStrategy());
        holder.tvTime.setText( AMapUtil.getFriendlyTime(dur));
        holder.tvDistance.setText(AMapUtil.getFriendlyLength(dis));

    }


    @Override
    public int getItemCount(){
        return mDrivePathList.size();
    }
}

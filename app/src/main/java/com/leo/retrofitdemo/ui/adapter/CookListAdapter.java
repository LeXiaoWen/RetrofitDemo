package com.leo.retrofitdemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leo.retrofitdemo.R;
import com.leo.retrofitdemo.api.ApiContancts;
import com.leo.retrofitdemo.bean.CookListBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 2017/3/7.
 */

public class CookListAdapter extends RecyclerView.Adapter<CookListAdapter.ViewHolder>{

    private List<CookListBean.TngouBean> mList = new ArrayList<>();
    private Context mContext;
    private final LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CookListAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_cook_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mCookName.setText(mList.get(position).getName());
        holder.mCookDescription.setText(mList.get(position).getDescription());
        Picasso
                .with(mContext)
                .load(ApiContancts.Image_BASE_URL+mList.get(position).getImg())
                .into(holder.mCookImage);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mCookImage;
        private final TextView mCookName;
        private final TextView mCookDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mCookImage = (ImageView) itemView.findViewById(R.id.cook_image);
            mCookName = (TextView) itemView.findViewById(R.id.cook_name);
            mCookDescription = (TextView) itemView.findViewById(R.id.cook_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                       mListener.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public void addAll(List<CookListBean.TngouBean> list){
        mList.addAll(list);
        notifyDataSetChanged();
    }

    public  interface OnItemClickListener {
        void onClick(int position);
    }
}

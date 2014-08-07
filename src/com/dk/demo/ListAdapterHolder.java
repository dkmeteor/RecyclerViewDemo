package com.dk.demo;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapterHolder extends RecyclerView.Adapter<ListAdapterHolder.ViewHolder> {

    private List<TestData> mDatas;
    OnItemClickListener mItemClickListener;

    public ListAdapterHolder(ArrayList<TestData> datas) {
        mDatas = datas;
    }

    public void addItem(TestData item) {
        mDatas.add(mDatas.size(), item);
        notifyItemInserted(mDatas.size());

    }

    public void removeItem(int index) {
        mDatas.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View sView = mInflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(sView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mContent.setText(mDatas.get(position).getContent());
        holder.mImage.setImageResource(mDatas.get(position).getAvatar());

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView mContent;
        ImageView mImage;

        public ViewHolder(View view) {
            super(view);
            mImage = (ImageView) view.findViewById(R.id.list_image);
            mContent = (TextView) view.findViewById(R.id.list_content);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }

    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

}

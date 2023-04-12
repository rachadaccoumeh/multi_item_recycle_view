package com.rachad.multirecycleviewitem;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter {

    private final List<String> titleList;
    private final List<String> descriptionList;
    private ItemClickListener mClickListener;

    public MyRecyclerViewAdapter(List<String> titleList, List<String> descriptionList) {
        this.titleList = titleList;
        this.descriptionList = descriptionList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }
        return 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.different_item_1, parent, false);
            return new ViewHolder1(view);
        } else if (viewType == 1) {
            view = layoutInflater.inflate(R.layout.deiiferent_item_2, parent, false);
            return new ViewHolder2(view);
        }
        view = layoutInflater.inflate(R.layout.recycle_view_row, parent, false);

        return new ViewHolderB(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {

        } else if (position == 1) {

        } else {
            ViewHolderB viewHolderB = (ViewHolderB) holder;
            viewHolderB.titleTextView.setText(titleList.get(position));
            viewHolderB.descriptionTextView.setText(descriptionList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    class ViewHolderB extends RecyclerView.ViewHolder {
        TextView titleTextView, descriptionTextView;

        public ViewHolderB(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.textViewTitle);
            descriptionTextView = itemView.findViewById(R.id.textViewDescription);
        }

    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
        }
    }

    String getItem(int id) {
        return titleList.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}



package com.example.final_project;

//Arsam Firoozfar
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.itemViewHolder> {

    final private ListItemClickListener mOnClickListener;
    private static int viewHolderCount;
    private int mNumberItems;


    public interface ListItemClickListener{
        public void onListItemClick(int i, View itemView);
    }
    public itemAdapter(int items, ListItemClickListener item) {

        mNumberItems = items;
        viewHolderCount = 0;
        mOnClickListener = item;

    }

    @Override
    public itemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.item_list;
        LayoutInflater inflater = LayoutInflater.from(context);


        View view = inflater.inflate(layoutIdForListItem, viewGroup, false);
        itemViewHolder viewHolder = new itemViewHolder(view);

        viewHolderCount++;

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(itemViewHolder holder, int position) {

        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }


    class itemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Will display which ViewHolder is displaying this data
        TextView viewHolder;

        public itemViewHolder(View itemView) {
            super(itemView);


            viewHolder = (TextView) itemView.findViewById(R.id.view_holder_instance);
            itemView.setOnClickListener(this);

        }

        void bind(int listIndex) {
            viewHolder.setText(MainActivity.activityArray.get(listIndex).type);
        }
        @Override
        public void onClick(View v){
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition,v);
        }

    }
}

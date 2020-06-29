package com.example.parcelable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Data> dataArrayList;
    private OnItemClickListener listener;

    public interface OnItemClickListener{ void onItemClick(int position);}

    void setOnItemClickListener(OnItemClickListener listener){ this.listener = listener; }

    RecyclerAdapter(ArrayList<Data> dataArrayList) { this.dataArrayList = dataArrayList; }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Data data = dataArrayList.get(position);
        holder.imageView.setImageResource(data.getImageView());
        holder.textView1.setText(data.getText1());
        holder.textView2.setText(data.getText2());
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView1;
        TextView textView2;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            textView1 = itemView.findViewById(R.id.TextView1Id);
            textView2 = itemView.findViewById(R.id.TextView2Id);
            imageView = itemView.findViewById(R.id.ImageViewId);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

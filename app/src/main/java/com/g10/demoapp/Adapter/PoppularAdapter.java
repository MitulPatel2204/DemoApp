package com.g10.demoapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.g10.demoapp.Pogo.PopularPogo;
import com.g10.demoapp.Pogo.Productpogo;
import com.g10.demoapp.R;

import java.util.List;

public class PoppularAdapter extends RecyclerView.Adapter<PoppularAdapter.ViewHolder> {

    private List<PopularPogo> list;
    private Context rContext;

    public PoppularAdapter(List<PopularPogo> list, Context rContext) {
        this.list = list;
        this.rContext = rContext;
    }

    @NonNull
    @Override
    public PoppularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layou_popbooks, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PoppularAdapter.ViewHolder holder, int position) {
        final PopularPogo pogo = list.get(position);
        String image = pogo.getPimage();
        holder.pbookName.setText(pogo.getPname());
        holder.pbookAuthor.setText(pogo.getPauthor());
        holder.pdesc.setText(pogo.getPdescription());


        // holder.tvQty.setText("0");
        String Image = "https://intellect-mitul.000webhostapp.com/Images/" + image;
        try {
            Glide.with(rContext).load(Image).into(holder.pbookImage);
            Log.e("Getpimage ", Image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView pbookName,pbookAuthor,pdesc;
        private ImageView pbookImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pbookName =itemView.findViewById(R.id.pbookName);
            pbookAuthor =itemView.findViewById(R.id.pbookAuthor);
            pdesc =itemView.findViewById(R.id.pdesc);
            pbookImage =itemView.findViewById(R.id.pbookImage);
        }
    }
}

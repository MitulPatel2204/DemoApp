package com.g10.demoapp.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.TextViewOnReceiveContentListener;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.g10.demoapp.Pogo.Productpogo;
import com.g10.demoapp.R;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Productpogo> list;
    private Context rContext;
    Float ratingNumber;

    public ProductAdapter(List<Productpogo> list, Context rContext) {
        this.list = list;
        this.rContext = rContext;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        final Productpogo pogo = list.get(position);
        String image = pogo.getImage();
        holder.bookName.setText(pogo.getBookname());
        holder.bookAuthor.setText(pogo.getBookauthor());
        holder.bookPrice.setText(pogo.getBookprice());
        holder.totalrating.setText(pogo.getTotalrating());
       holder.rating.setRating(pogo.getRating());

        // holder.tvQty.setText("0");
        String Image = "https://intellect-mitul.000webhostapp.com/Images/" + image;
        try {
            Glide.with(rContext).load(Image).into(holder.bookImage);
              Log.e("Getimage ", Image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView bookName,bookAuthor,bookPrice,totalrating;
        private ImageView bookImage;
        private RatingBar rating;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookName =itemView.findViewById(R.id.bookName);
            bookAuthor =itemView.findViewById(R.id.bookAuthor);
            bookPrice =itemView.findViewById(R.id.bookPrice);
            totalrating =itemView.findViewById(R.id.totalrating);
            bookImage =itemView.findViewById(R.id.bookImage);
            rating =itemView.findViewById(R.id.rating);
        }
    }
}

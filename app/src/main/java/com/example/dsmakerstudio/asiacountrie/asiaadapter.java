package com.example.dsmakerstudio.asiacountrie;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class asiaadapter extends RecyclerView.Adapter<asiaadapter.viewholder> {

    private List<asiamodel> asiamodelList;

    public asiaadapter(List<asiamodel> asiamodelList) {
        this.asiamodelList = asiamodelList;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.asiacountry,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.setData(asiamodelList.get(position).getFlag(), asiamodelList.get(position).getName(),position);


    }

    @Override
    public int getItemCount() {
        return asiamodelList.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder {
         TextView title;
        CircleImageView img;
        public viewholder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.setname);
            img=itemView.findViewById(R.id.setImg);
        }

        private void setData(final String url, final String title, final int position) {


            Glide.with(itemView.getContext()).load(url).into(img);
            this.title.setText(title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(itemView.getContext(), details.class);
                    intent.putExtra("position",position);
                    itemView.getContext().startActivity(intent);

                }


            });


        }

    }
}

package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class adapter extends RecyclerView.Adapter<adapter.viewholder> {
    List<model> list=new ArrayList<>();
    LayoutInflater layoutInflater;
    private onitemClicked onitemClicked;
    public interface onitemClicked
    {
        void onitemclicke(int position);
    }
    public void setonitemclicke(onitemClicked itemClicked)
    {
        this.onitemClicked=itemClicked;
    }


    public adapter(List<model> list,Context context) {
        this.list = list;
        layoutInflater=LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view = layoutInflater.inflate(R.layout.item,viewGroup,false);



        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final viewholder viewholder, int i) {
        final model model=list.get(i);
        viewholder.overview.setText(model.getOverview());
        viewholder.title.setText(model.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class viewholder extends RecyclerView.ViewHolder {
        TextView title;
        TextView overview;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.text_title);
            overview=itemView.findViewById(R.id.text_overview);
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    title.setText("Clicked");
                }
            });

        }




    }
}

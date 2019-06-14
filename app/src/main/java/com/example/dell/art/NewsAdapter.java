package com.example.dell.art;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> implements Filterable{

    Context mContext;
    List<NewsItem> mData;
    Animation fade;
    List<NewsItem> mDataFiltered;

    public NewsAdapter(Context mContext, List<NewsItem> mData) {
        this.mContext = mContext;
        this.mData = mData;
        this.mDataFiltered = mData;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.item_news,viewGroup,false);
        return new NewsViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int position) {
        newsViewHolder.tv_title.setText(mDataFiltered.get(position).getTitle());
        newsViewHolder.tv_description.setText(mDataFiltered.get(position).getContent());
        newsViewHolder.tv_date.setText(mDataFiltered.get(position).getTitle());
        newsViewHolder.img_user.setImageResource(mDataFiltered.get(position).getUserPhoto());

        newsViewHolder.img_user.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_transition_position));

        newsViewHolder.container.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.fade_scale_animation));

        newsViewHolder.setItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                if(mDataFiltered.get(pos).getTitle().equals("Square One")){
                    Intent intent = new Intent(mContext,SquareOne.class);
                    intent.putExtra("actionBarTitle", "SquareOne");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }
                else if (mDataFiltered.get(pos).getTitle().equals("Edison")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Edison.class);

                    intent.putExtra("actionBarTitle", "Edison");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }
                else if (mDataFiltered.get(pos).getTitle().equals("Turing")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Turing.class);
                    intent.putExtra("actionBarTitle", "Turing");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }
                else if (mDataFiltered.get(pos).getTitle().equals("Explore Hub")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Explore_Hub.class);
                    intent.putExtra("actionBarTitle", "Explore Hub");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                } else if (mDataFiltered.get(pos).getTitle().equals("Fleming")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Fleming_Block.class);
                    intent.putExtra("actionBarTitle", "Fleming Block");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }else if (mDataFiltered.get(pos).getTitle().equals("Architecture")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Architecture_Block.class);
                    intent.putExtra("actionBarTitle", "Architecture Block");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }else if (mDataFiltered.get(pos).getTitle().equals("Newton")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Newton_Block.class);
                    intent.putExtra("actionBarTitle", "Newton Block");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }else if (mDataFiltered.get(pos).getTitle().equals("Babbage Block")){
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Babbage_Block.class);
                    intent.putExtra("actionBarTitle", "Babbage Block");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }else if (mDataFiltered.get(pos).getTitle().equals("Galellio Block")) {
                    //start NewActivity with title for actionbar and text for textview
                    Intent intent = new Intent(mContext, Gallelio_Block.class);
                    intent.putExtra("actionBarTitle", "Gallelio Block");
                    mContext.startActivity(intent);
                    Animatoo.animateSlideLeft(mContext);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataFiltered.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String key = constraint.toString();

                if(key.isEmpty()){
                    mDataFiltered = mData;
                }
                else{
                    List<NewsItem> listFiltered = new ArrayList<>();
                    for(NewsItem row:mData){
                        if(row.getTitle().trim().toLowerCase().contains(key.trim().toLowerCase())){
                            listFiltered.add(row);
                        }
                    }
                    mDataFiltered = listFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mDataFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                mDataFiltered = (List<NewsItem>)results.values;
                notifyDataSetChanged();

            }
        };
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tv_title,tv_description,tv_date;
        CircularImageView img_user;
        RelativeLayout container;
        itemClickListener itemClickListener;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            container = itemView.findViewById(R.id.relativeLayout);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            tv_date = itemView.findViewById(R.id.tv_date);
            img_user = itemView.findViewById(R.id.img_user);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(v,getLayoutPosition());
        }
        public void setItemClickListener(itemClickListener ic){
            this.itemClickListener = ic;
        }
    }




}

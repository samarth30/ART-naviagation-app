package com.example.dell.art;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.mikhaellopez.circularimageview.CircularImageView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Inflater;

public class ListViewAdapter extends BaseAdapter {
    Context mcontext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;

    public ListViewAdapter(Context context, List<Model> modellist) {
        mcontext = context;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mcontext);
        arrayList = new ArrayList<Model>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder {
        TextView mTitleTv, mDescTv;
        CircularImageView mIconIv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row, null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconIv = view.findViewById(R.id.mainicon);
            holder.mIconIv.setAnimation(AnimationUtils.loadAnimation(mcontext,R.anim.fade_transition_position));
            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDescription());
        holder.mIconIv.setImageResource(modellist.get(position).getIcon());
        holder.mIconIv.setAnimation(AnimationUtils.loadAnimation(mcontext,R.anim.fade_transition_position));
        holder.mTitleTv.setAnimation(AnimationUtils.loadAnimation(mcontext,R.anim.fade));
        view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //code later
                    if (modellist.get(position).getTitle().equals("Squareone")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, SquareOne.class);
                        intent.putExtra("actionBarTitle", "SquareOne");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }
                    else if (modellist.get(position).getTitle().equals("Edison")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Edison.class);

                        intent.putExtra("actionBarTitle", "Edison");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }
                    else if (modellist.get(position).getTitle().equals("Turing")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Turing.class);
                        intent.putExtra("actionBarTitle", "Turing");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }
                    else if (modellist.get(position).getTitle().equals("Explore Hub")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Explore_Hub.class);
                        intent.putExtra("actionBarTitle", "Explore Hub");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    } else if (modellist.get(position).getTitle().equals("Fleming Block")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Fleming_Block.class);
                        intent.putExtra("actionBarTitle", "Fleming Block");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }else if (modellist.get(position).getTitle().equals("Architecture Block")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Architecture_Block.class);
                        intent.putExtra("actionBarTitle", "Architecture Block");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }else if (modellist.get(position).getTitle().equals("Newton Block")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Newton_Block.class);
                        intent.putExtra("actionBarTitle", "Newton Block");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }else if (modellist.get(position).getTitle().equals("Babbage Block")){
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Babbage_Block.class);
                        intent.putExtra("actionBarTitle", "Babbage Block");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }else if (modellist.get(position).getTitle().equals("Gallelio Block")) {
                        //start NewActivity with title for actionbar and text for textview
                        Intent intent = new Intent(mcontext, Gallelio_Block.class);
                        intent.putExtra("actionBarTitle", "Gallelio Block");
                        mcontext.startActivity(intent);
                        Animatoo.animateSlideLeft(mcontext);
                    }

                }
        });
        return view;
    }

    public void filter(String chartext) {
        chartext = chartext.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (chartext.length() == 0) {
            modellist.addAll(arrayList);
        } else {
            for (Model model : arrayList) {
                if (model.getTitle().toLowerCase(Locale.getDefault()).contains(chartext)) {
                    modellist.add(model);
                }
            }

        }
        notifyDataSetChanged();

    }
}
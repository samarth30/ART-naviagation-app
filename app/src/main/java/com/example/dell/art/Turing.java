package com.example.dell.art;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class Turing extends AppCompatActivity {
    ListView MyTuringListView;
    String[] mgates = {"Basement Left Gate", "Basement Right Gate", "First Floor Main Stairs", "FIRST FLOOR SIDE STAIR","SECOND FLOOR RIGHT STAIR","SECOND FLOOR LEFT STAIR","THIRD FLOOR RIGHT STAIR","THIRD FLOOR LEFT STAIR","FOURTH FLOOR RIGHT STAIR","FOURTH FLOOR LEFT STAIR","FIFHT FLOOR RIGHT STAIR","FIFTH FLOOR LEFT STAIR"};
    int[] images = {R.drawable.flower, R.drawable.flower, R.drawable.flower, R.drawable.flower, R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower,R.drawable.flower};
    int[] mbackground = {R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turing);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MyTuringListView = findViewById(R.id.MyTuringListView);




        MyAdapter MyTuringAdapter =new MyAdapter(this,mgates,images,mbackground);

        MyTuringListView.setAdapter(MyTuringAdapter);

        MyTuringListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent Turing_Basement_left_Gate = new Intent(Turing.this, Turing_Basement_left_Gate.class);
                    startActivity(Turing_Basement_left_Gate);
                    Animatoo.animateSlideLeft(Turing.this);
                } else if (position == 1) {
                    Intent Turing_Basement_Right_Gate = new Intent(Turing.this,Turing_Basement_Right_Gate.class);
                    startActivity(Turing_Basement_Right_Gate);
                    Animatoo.animateSlideLeft(Turing.this);
                } else if (position == 2) {
                    Intent Turing_FirstFloor_MainStair = new Intent(Turing.this, Turing_FirstFloor_MainStair.class);
                    startActivity(Turing_FirstFloor_MainStair);
                    Animatoo.animateSlideLeft(Turing.this);
                } else if (position == 3) {
                    Intent Turing_firstFloor_sideStair = new Intent(Turing.this, Turing_firstFloor_sideStair.class);
                    startActivity(Turing_firstFloor_sideStair);
                    Animatoo.animateSlideLeft(Turing.this);
                } else if (position == 4) {
                    Intent Turing_secondFloor_RightStair = new Intent(Turing.this, Turing_secondFloor_RightStair.class);
                    startActivity(Turing_secondFloor_RightStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 5){
                    Intent Turing_secondFloor_LeftStair = new Intent(Turing.this, Turing_secondFloor_LeftStair.class);
                    startActivity(Turing_secondFloor_LeftStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 6){
                    Intent Turing_ThirdFloor_RightStair = new Intent(Turing.this, Turing_ThirdFloor_RightStair.class);
                    startActivity(Turing_ThirdFloor_RightStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 7){
                    Intent Turing_ThirdFloor_LeftStair = new Intent(Turing.this, Turing_ThirdFloor_LeftStair.class);
                    startActivity(Turing_ThirdFloor_LeftStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 8){
                    Intent Turing_FourthFloor_LeftStair = new Intent(Turing.this, Turing_FourthFloor_LeftStair.class);
                    startActivity(Turing_FourthFloor_LeftStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 9){
                    Intent Turing_FourthFloor_RightStair = new Intent(Turing.this, Turing_FourthFloor_RightStair.class);
                    startActivity(Turing_FourthFloor_RightStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 10){
                    Intent Turing_FifthFloor_LeftStair = new Intent(Turing.this,Turing_FifthFloor_LeftStair.class);
                    startActivity(Turing_FifthFloor_LeftStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }else if(position == 11){
                    Intent Turing_FifthFloor_RightStair = new Intent(Turing.this, Turing_FifthFloor_RightStair.class);
                    startActivity(Turing_FifthFloor_RightStair);
                    Animatoo.animateSlideLeft(Turing.this);
                }
            }
        });
    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        //        String rDescription[];
        int rImgs[];
        int rBackground[];

        MyAdapter(Context c,String title[],int imgs[],int background[]) {
            super(c, R.layout.row, R.id.card_text, title);
            this.context = c;
            this.rTitle = title;
//            this.rDescription = description;
            this.rImgs = imgs;
            this.rBackground = background;
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.cardview,parent,false);
            ImageView images = row.findViewById(R.id.card_image);
            TextView myTitle = row.findViewById(R.id.card_text);
            ImageView background = row.findViewById(R.id.background);
//            TextView myDescription = row.findViewById(R.id.textview2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            background.setImageResource(rBackground[position]);
//            myDescription.setText(rDescription[position]);

            myTitle.setAnimation(AnimationUtils.loadAnimation(Turing.this,R.anim.fade_transition_position));
            return row;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Animatoo.animateSlideRight(this);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}


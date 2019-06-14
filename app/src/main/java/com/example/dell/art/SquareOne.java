package com.example.dell.art;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;

public class SquareOne extends AppCompatActivity {
    ListView MySquareOneListView;
    String[] mgates = {"GROUND FLOOR: GATE 1", "GROUND FLOOR: GATE 2", "FIRST FLOOR: GATE 1", "FIRST FLOOR: GATE 2", "SECOND FLOOR: GATE"};
    int[] images = {R.drawable.flower, R.drawable.sg, R.drawable.flower, R.drawable.sg, R.drawable.flower};
    int[] mbackground = {R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient,R.drawable.black_gradient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_square_one);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        MySquareOneListView = findViewById(R.id.MySquareoneListView);

        MyAdapter MySquareOneAdapter =new MyAdapter(this,mgates,images,mbackground);


        MySquareOneListView.setAdapter(MySquareOneAdapter);

        MySquareOneListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent GroundFloorGate1 = new Intent(SquareOne.this, GroundFloorGate1.class);
                    startActivity(GroundFloorGate1);
                    Animatoo.animateSlideLeft(SquareOne.this);
                } else if (position == 1) {
                    Intent GroundFloorGate2 = new Intent(SquareOne.this, GroundFloorGate2.class);
                    startActivity(GroundFloorGate2);
                    Animatoo.animateSlideLeft(SquareOne.this);
                } else if (position == 2) {
                    Intent FirstFloorGate1 = new Intent(SquareOne.this, FirstFloorGate1.class);
                    startActivity(FirstFloorGate1);
                    Animatoo.animateSlideLeft(SquareOne.this);
                } else if (position == 3) {
                    Intent FirstFloorGate2 = new Intent(SquareOne.this, FirstFloorGate2.class);
                    startActivity(FirstFloorGate2);
                    Animatoo.animateSlideLeft(SquareOne.this);
                } else if (position == 4) {
                    Intent SecondFloorGate1 = new Intent(SquareOne.this, SecondFloorGate1.class);
                    startActivity(SecondFloorGate1);
                    Animatoo.animateSlideLeft(SquareOne.this);
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


//        MySquareOneListView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id){
//                        if(position == 0){
//                            Intent GroundFloorGate1 = new Intent(SquareOne.this,GroundFloorGate1.class);
//                            startActivity(GroundFloorGate1);
//                        }else if(position == 1){
//                            Intent GroundFloorGate2 = new Intent(SquareOne.this,GroundFloorGate2.class);
//                            startActivity(GroundFloorGate2);
//                        }else if(position == 2){
//                            Intent FirstFloorGate1 = new Intent(SquareOne.this,FirstFloorGate1.class);
//                            startActivity(FirstFloorGate1);
//                        }else if(position == 3){
//                            Intent FirstFloorGate2 = new Intent(SquareOne.this,FirstFloorGate2.class);
//                            startActivity(FirstFloorGate2);
//                        }else if(position == 4){
//                            Intent SecondFloorGate1 = new Intent(SquareOne.this,SecondFloorGate1.class);
//                            startActivity(SecondFloorGate1);
//                        }
//                    }
//                }
//        );


//        class MyAdapter extends ArrayAdapter<String> {
//            Context context;
//            String myTitles[];
//            int[] images;
//
//            MyAdapter(Context context, String[] titles, int[] images) {
//                super(context, R.layout.cardview, R.id.card_text);
//
//                this.context = context;
//                this.myTitles = titles;
//                this.images = images;
//
//            }
//
//            @NonNull
//            @Override
//            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                LayoutInflater layoutInflater = (LayoutInflater) getApplication().getSystemService(context.LAYOUT_INFLATER_SERVICE);
//                View card = layoutInflater.inflate(R.layout.cardview, parent, false);
//                ImageView icon = (ImageView) findViewById(R.id.card_image);
//                TextView mytitle = (TextView) findViewById(R.id.card_text);
//                icon.setImageResource(images[position]);
//                mytitle.setText(myTitles[position]);
//
//                return card;
//
//            }
//        }
//    }
//

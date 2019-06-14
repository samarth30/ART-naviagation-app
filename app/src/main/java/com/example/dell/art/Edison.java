package com.example.dell.art;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class Edison extends AppCompatActivity {
    ListView MyEdisonListView;
    String[] mgates = {"Ground Floor Main Gate", "Ground Floor Back Gate", "Ground Floor Back Gate", "Basement", " First Floor"};
    int[] images = {R.drawable.sg, R.drawable.flower, R.drawable.sg, R.drawable.flower, R.drawable.sg};
    int[] mbackground = {R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edison);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        onBackPressed();

        MyEdisonListView = findViewById(R.id.MyEdisonListView);

        MyAdapter MyEdisonAdapter = new MyAdapter(this, mgates, images, mbackground);


        MyEdisonListView.setAdapter(MyEdisonAdapter);

        MyEdisonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent GroundFloorGate1 = new Intent(Edison.this, Edison_Ground_Floor_Main_Gate.class);
                    startActivity(GroundFloorGate1);
                    Animatoo.animateSlideLeft(Edison.this);
                } else if (position == 1) {
                    Intent GroundFloorGate2 = new Intent(Edison.this, Edison_ground_floor_back_gate.class);
                    startActivity(GroundFloorGate2);
                    Animatoo.animateSlideLeft(Edison.this);
                } else if (position == 2) {
                    Intent FirstFloorGate1 = new Intent(Edison.this, Edison_ground_floor_sideGate.class);
                    startActivity(FirstFloorGate1);
                    Animatoo.animateSlideLeft(Edison.this);
                } else if (position == 3) {
                    Intent FirstFloorGate2 = new Intent(Edison.this, Edison_basement.class);
                    startActivity(FirstFloorGate2);
                    Animatoo.animateSlideLeft(Edison.this);
                } else if (position == 4) {
                    Intent SecondFloorGate1 = new Intent(Edison.this, Edison_first_floor.class);
                    startActivity(SecondFloorGate1);
                    Animatoo.animateSlideLeft(Edison.this);
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

        MyAdapter(Context c, String title[], int imgs[], int background[]) {
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
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.cardview, parent, false);
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


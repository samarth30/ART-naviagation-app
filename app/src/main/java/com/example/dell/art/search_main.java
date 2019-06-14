package com.example.dell.art;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

public class search_main extends AppCompatActivity {
    RecyclerView NewsRecyclerView;
    NewsAdapter newsAdapter;
    List<NewsItem> mData;
    AutoCompleteTextView searchinput;
    List<CountryItem> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_search_main);

        //adding up animations

        searchinput = findViewById(R.id.editText);

        NewsRecyclerView = findViewById(R.id.news_rv);
        mData = new ArrayList<>();
        filter();

        newsAdapter = new NewsAdapter(this,mData);
        NewsRecyclerView.setAdapter(newsAdapter);
        NewsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //adding custom suggestions
        fillCountryList();

        //ONclick method

        // Autosuggestion
//        AutoCompleteCountryAdapter autosuggestion = new AutoCompleteCountryAdapter(this,countryList);
//
//        searchinput.setAdapter(autosuggestion);

        searchinput.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count){
                newsAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void filter(){
        mData.add(new NewsItem("Square One","art app is very useful made by developers to rome around chitkara.\nthey can use thier own location as well,art app is very useful made by \ndevelopers to rome around chitkara.they can use thier own location as well,\nart app is very useful made by developers to rome around chitkara.they can use thi\ner own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Edison","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Turing","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Explore Hub","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Fleming","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Architecture","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Newton","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Babbage Block","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Galellio Block","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Nokia 1120","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("facebook","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("instagram","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));
        mData.add(new NewsItem("Watsapp","art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well,art app is very useful made by developers to rome around chitkara.they can use thier own location as well","samarth",R.drawable.driver));

    }
    private void fillCountryList(){
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Square One",R.drawable.driver));
        countryList.add(new CountryItem("Edison",R.drawable.flower));
        countryList.add(new CountryItem("Turing",R.drawable.sg));
        countryList.add(new CountryItem("Explore Hub",R.drawable.meal));
        countryList.add(new CountryItem("Fleming",R.drawable.payment));
        countryList.add(new CountryItem("Architecture",R.drawable.payment));
        countryList.add(new CountryItem("Newton",R.drawable.payment));
        countryList.add(new CountryItem("Babbage Block",R.drawable.payment));
        countryList.add(new CountryItem("Galellio Block",R.drawable.payment));
        countryList.add(new CountryItem("facebook",R.drawable.payment));
        countryList.add(new CountryItem("instagram",R.drawable.payment));
        countryList.add(new CountryItem("Watsapp",R.drawable.payment));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if(id == R.id.action_search){
//           searchinput.setVisibility(View.VISIBLE);
//           toolbar.setVisibility(View.INVISIBLE);
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
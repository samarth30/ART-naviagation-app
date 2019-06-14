package com.example.dell.art;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

import java.util.ArrayList;
import java.util.List;

public class HomeDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    private List<CountryItem> countryList;

    ArrayList<Model> arrayList = new ArrayList<Model>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_drawer);

//        Button button = (Button)findViewById(R.id.searchChitkara);

        ActionBar actionBar = getSupportActionBar();
        if (getSupportActionBar() != null) {
            actionBar.setTitle("Items List");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        title = new String[]{"Squareone", "Edison", "Turing", "Explore Hub", "Fleming Block", "Architecture Block", "Newton Block", "Babbage Block", "Gallelio Block"};
        description = new String[]{"Squareone detail...", "Newton detail...", "Tesla detail...", "Edison detail...", "Fleming Block......", "Architecture Block........", "Newton Block......", "Babbage Block......", "Gallelio Block......."};
        icon = new int[]{R.drawable.meal, R.drawable.payment, R.drawable.driver, R.drawable.meal, R.drawable.driver, R.drawable.driver, R.drawable.meal, R.drawable.meal, R.drawable.driver};

        listView = findViewById(R.id.listView);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }


        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);


//
//        // Autoduggestion
//        fillCountryList();
//
////        CircularImageView circularImageView = (CircularImageView)findViewById(R.id.)
//        AutoCompleteTextView editText = findViewById(R.id.actv1);
//
//        AutoCompleteCountryAdapter adapterAutoComplete = new AutoCompleteCountryAdapter(this, countryList);
////
//        editText.setAdapter(adapterAutoComplete);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_drawer, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
//        final SearchView searchView = (SearchView)myActionMenuItem.getActionView();
////        final AutoCompleteCountryAdapter adapterAutoComplete = new AutoCompleteCountryAdapter(this, countryList);
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
////                 searchView.setSuggestionsAdapter(AutoCompleteTextView);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                if (TextUtils.isEmpty(s)){
//                    adapter.filter("");
//                    listView.clearTextFilter();
//                }
//                else {
//                    adapter.filter(s);
//                }
//                return true;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.action_settings){
            //do your functionality here
            return true;
        }
        if(id == R.id.action_search){
             Intent intent = new Intent(HomeDrawer.this,search_main.class);
             startActivity(intent);
            Animatoo.animateZoom(HomeDrawer.this);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.call) {
            // Handle the camera action
        } else if (id == R.id.tools) {

        } else if (id == R.id.share) {

          Intent shareIntent = new Intent(Intent.ACTION_SEND);
          shareIntent.setType("Text/Plain");
          String shareBody = "Your body here";
          String shareSubject = "Your subject here";
          shareIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
          shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);

          startActivity(Intent.createChooser(shareIntent,"Share Using"));
        } else if (id == R.id.sendlocation) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void fillCountryList(){
        countryList = new ArrayList<>();
        countryList.add(new CountryItem("Explore hub",R.drawable.driver));
        countryList.add(new CountryItem("Edison",R.drawable.flower));
        countryList.add(new CountryItem("square one",R.drawable.sg));
        countryList.add(new CountryItem("Turing",R.drawable.meal));
        countryList.add(new CountryItem("Architecture",R.drawable.payment));
        countryList.add(new CountryItem("Fleming",R.drawable.payment));
        countryList.add(new CountryItem("Newton",R.drawable.payment));
        countryList.add(new CountryItem("Demorgan",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
        countryList.add(new CountryItem("Babbage",R.drawable.payment));
    }
}

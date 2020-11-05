package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mentalhealth.Fragments.BlogFragment;
import com.example.mentalhealth.Fragments.GameFragment;
import com.example.mentalhealth.Fragments.ProfilFragment;
import com.example.mentalhealth.Fragments.ProgretFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private TabLayout tableLayout;
    private ViewPager viewPager;
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tableLayout =findViewById(R.id.tabLayout);
        viewPager= findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new BlogFragment(),"Blog");
        viewPagerAdapter.addFragment(new GameFragment(),"Game");
        viewPagerAdapter.addFragment(new ProgretFragment(),"Progres");
        viewPagerAdapter.addFragment(new ProfilFragment(),"Profil");



        viewPager.setAdapter(viewPagerAdapter);
        tableLayout.setupWithViewPager(viewPager);

        //Hooks
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView =(NavigationView)findViewById(R.id.nav_view);
        toolbar=findViewById(R.id.toolbar);

        //toolbar
        setSupportActionBar(toolbar);

        //Navigation Drawer Menu
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

    }

    //Allow opening and closing the navigator bar
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                Intent intent1= new Intent(Home.this, Home.class);
                startActivity(intent1);
                break;
            case R.id.nav_Services:
                break;
            case R.id.nav_Logout:
                FirebaseAuth.getInstance().signOut();
                Intent AppStart = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(AppStart);
                break;
        }
        return true ;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private ArrayList<Fragment> fragements;
        private ArrayList<String> titles;

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragements.get(position);
        }

        @Override
        public int getCount() {
            return fragements.size();
        }

         ViewPagerAdapter(FragmentManager fm){
            super(fm);
            this.fragements = new ArrayList<>();
            this. titles = new ArrayList<>();
        }

        public void addFragment(Fragment fragment, String title){
            this.fragements.add(fragment);
            this.titles.add(title);
        }

        public CharSequence getPageTitle(int position){
            return titles.get(position);
        }
    }

}
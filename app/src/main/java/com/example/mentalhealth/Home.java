package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.mentalhealth.Fragments.BlogFragment;
import com.example.mentalhealth.Fragments.GameFragment;
import com.example.mentalhealth.Fragments.ProfilFragment;
import com.example.mentalhealth.Fragments.ProgretFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private TabLayout tableLayout;
    private ViewPager viewPager;
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
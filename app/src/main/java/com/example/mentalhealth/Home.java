package com.example.mentalhealth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseUser userr;
    DatabaseReference myref;
    private TextView printspace;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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


        printspace = findViewById(R.id.welcome_text);

        userr = FirebaseAuth.getInstance().getCurrentUser();
        myref = FirebaseDatabase.getInstance().getReference("MyUsers").child(userr.getUid());

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userA = snapshot.getValue(User.class);
                printspace.setText("Welcome to Home Page");

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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
                Intent loginScreen = new Intent(getApplicationContext(), loginScreen.class);
                startActivity(loginScreen);
                break;
        }
        return true ;
    }
}

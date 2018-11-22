package dev.sis.mute;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Diccionario");
                    DiccionarioFragment fragment = new DiccionarioFragment();
                    android.support.v4.app.FragmentTransaction tran =
                            getSupportFragmentManager().beginTransaction();
                    tran.replace(R.id.contenedor, fragment);
                    tran.commit();
                    return true;
                case R.id.navigation_dashboard:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Traductor");
                    TraductorFragment fragment2 = new TraductorFragment();
                    android.support.v4.app.FragmentTransaction tran2 =
                            getSupportFragmentManager().beginTransaction();
                    tran2.replace(R.id.contenedor, fragment2);
                    tran2.commit();
                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Traductor");
        TraductorFragment fragment2 = new TraductorFragment();
        android.support.v4.app.FragmentTransaction tran2 =
                getSupportFragmentManager().beginTransaction();
        tran2.replace(R.id.contenedor, fragment2);
        tran2.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contenedor);
            fragment.onActivityResult(requestCode, resultCode, data);
        }catch(Exception x){
            Toast.makeText(MainActivity.this, x.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}

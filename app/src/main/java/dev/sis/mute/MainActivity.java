package dev.sis.mute;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionMenu;

import helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.diccionariomenu:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Diccionario");
                    item.isChecked();
                    DiccionarioFragment fragment = new DiccionarioFragment();
                    android.support.v4.app.FragmentTransaction tran =
                            getSupportFragmentManager().beginTransaction();
                    tran.replace(R.id.contenedor, fragment);
                    tran.commit();
                    return true;
                case R.id.traductormenu:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Traductor");
                    item.isChecked();
                    TraductorFragment fragment2 = new TraductorFragment();
                    android.support.v4.app.FragmentTransaction tran2 =
                            getSupportFragmentManager().beginTransaction();
                    tran2.replace(R.id.contenedor, fragment2);
                    tran2.commit();
                    return true;
                case R.id.listasmenu:

                    return true;

                case R.id.historialmenu:

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation =  findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);


        actionBar = getSupportActionBar();
        actionBar.setTitle("Traductor");
        navigation.setSelectedItemId(R.id.traductormenu);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //and this to handle actions
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        if (item.getItemId() == R.id.action_settings) {

            Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

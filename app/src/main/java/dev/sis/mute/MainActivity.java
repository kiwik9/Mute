package dev.sis.mute;


import Utils.MutePreferences;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Set;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import helpers.BottomNavigationViewHelper;

public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;
    private MutePreferences prefs;
    BottomNavigationView navigation;
    FragmentManager fragmentManager;
    SharedPreferences prefsss;
    FragmentTransaction fragmentTransaction;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.diccionariomenu:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Diccionario");
                    item.isChecked();
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    DiccionarioFragment starredFragment = new DiccionarioFragment();
                    fragmentTransaction.replace(R.id.contenedor, starredFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.traductormenu:
                    actionBar = getSupportActionBar();
                    actionBar.setTitle("Diccionario");
                    item.isChecked();
                    fragmentManager = getSupportFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    TraductorFragment starredFragment2 = new TraductorFragment();
                    fragmentTransaction.replace(R.id.contenedor, starredFragment2);
                    fragmentTransaction.commit();
                    return true;
                case R.id.listasmenu:

                    FirebaseAuth.getInstance().signOut();
                    prefs.setString(MutePreferences.USUARIO_LOGUEADO, null);
                    Intent xd = new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(xd);
                    finish();

                    return true;

                case R.id.historialmenu:

                     xd = new Intent(MainActivity.this,JuegosActivity.class);
                    startActivity(xd);
                    finish();
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

        notificaciones();
        actionBar = getSupportActionBar();
        actionBar.setTitle("Traductor");
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        TraductorFragment starredFragment2 = new TraductorFragment();
        fragmentTransaction.replace(R.id.contenedor, starredFragment2);
        fragmentTransaction.commit();
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

    @Override
    protected void onResume() {
        super.onResume();
        prefs = new MutePreferences(this);
        String currentUser = prefs.getString(MutePreferences.USUARIO_LOGUEADO,null);
        if(currentUser == null){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }

    public void notificaciones(){
        NotificationCompat.Builder mBuilder;
        NotificationManager mNotifyMgr =(NotificationManager) getApplicationContext().getSystemService(NOTIFICATION_SERVICE);
        int icono = R.drawable.imgdicc;
        Intent intent = new Intent(MainActivity.this, JuegosActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0,intent, 0);
        mBuilder =new NotificationCompat.Builder(getApplicationContext())
                .setContentIntent(pendingIntent)
                .setSmallIcon(icono)
                .setContentTitle("Mute-Game")
                .setContentText("Sigue aprendiendo!")
                .setVibrate(new long[] {100, 250, 100, 500})
                .setAutoCancel(true);
        mNotifyMgr.notify(1, mBuilder.build());
    }

}

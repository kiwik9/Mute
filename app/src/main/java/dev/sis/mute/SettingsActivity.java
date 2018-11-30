package dev.sis.mute;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCambiarContraseña;
    Spinner Estilo;
    SharedPreferences.Editor editor;
    SharedPreferences setPref;
    TextView txtCorreoSet,txtNombreSet;
    Switch checkJuego,chekApren;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        txtCorreoSet = findViewById(R.id.txtCorreoSet);
        txtNombreSet = findViewById(R.id.txtNombreRegistro);
        checkJuego = findViewById(R.id.notificacionJuego);
        chekApren = findViewById(R.id.notificacionesParacontinuar);
         prefs =
                getSharedPreferences("SettinsPreferences",Context.MODE_PRIVATE);

        txtCorreoSet.setText(prefs.getString("email",null));
        //txtNombreSet.setText(prefs.getString("nombre",null));
        if(prefs.getString("notjuego",null) == "desactivado")
            checkJuego.setChecked(false);
        else
            checkJuego.setChecked(true);
        if(prefs.getString("notcon",null) == "desactivado")
            chekApren.setChecked(false);
        else
            chekApren.setChecked(true);

        checkJuego.setOnClickListener(this);

    }


    @Override
    public boolean onNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.notificacionesParacontinuar:


                break;

            case R.id.notificacionJuego:


                break;
        }
    }
}

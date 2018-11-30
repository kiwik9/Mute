package dev.sis.mute;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JuegosActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnJuego1;
    Button btnJuego2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juegos);

        btnJuego1 = findViewById(R.id.btnsolitario);
        btnJuego2 = findViewById(R.id.btnversus);
        btnJuego1.setOnClickListener(this);
        btnJuego2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsolitario:
                Intent star =new Intent(JuegosActivity.this,MemoriaActivity.class);
                startActivity(star);
                break;

            case R.id.btnversus:
                star =new Intent(JuegosActivity.this,Memoria2Activity.class);
                startActivity(star);
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

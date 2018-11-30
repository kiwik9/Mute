package dev.sis.mute;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Utils.MutePreferences;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText usuario,pass;
    Button btnlogin,btnRegistro;
    TextView goRegistro;
    MutePreferences prefs;
    private FirebaseAuth auth;
    SharedPreferences setPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        prefs = new MutePreferences(this);
        usuario = findViewById(R.id.txtUser);
        pass = findViewById(R.id.txtPass);
        goRegistro = findViewById(R.id.btnGoResgistro);
        goRegistro.setOnClickListener(this);
        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(this);
        setPref = getSharedPreferences("SettinsPreferences",Context.MODE_PRIVATE);
        prefs.getString("email", null);
        prefs.getString("nombre",null);
        prefs.getString("notjuego", "desactivado");
        prefs.getString("notcon","desactivado");
        prefs.getString("notificaciones",null);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnLogin:
                loginProcess();
                break;
            case R.id.btnGoResgistro:
                Intent intent = new Intent(this, RegistroActivity.class);
                startActivity(intent);
                break;

        }
    }

    public void loginProcess(){

        if(TextUtils.isEmpty(usuario.getText().toString())){
            Toast.makeText(getApplicationContext(), "Ingrese el correo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass.getText().toString())){
            Toast.makeText(getApplicationContext(), "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(usuario.getText().toString(),pass.getText().toString())
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(LoginActivity.this, user.toString(),
                            Toast.LENGTH_SHORT).show();
                    prefs.setString(MutePreferences.USUARIO_LOGUEADO, "Admin");
                    DatabaseReference dbUsuarios =
                            FirebaseDatabase.getInstance().getReference()
                                    .child("usuarios")
                                    .child(auth.getUid());

                    SharedPreferences.Editor editor = setPref.edit();
                    editor.putString("email", usuario.getText().toString());
                    editor.putString("nombre", dbUsuarios.child("nombre").getKey().toString());
                    editor.putString("notjuego", "desactivado");
                    editor.putString("notcon", "desactivado");

                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Error al iniciar sesion",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}

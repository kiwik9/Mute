package dev.sis.mute;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import models.listas;
        import models.usuarios;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.FirebaseApp;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseAuthException;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.provider.FirebaseInitProvider;

        import java.util.ArrayList;
        import java.util.List;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText usuarioReg, passReg,nombreReg;
    private Button btnRegistro;
    private FirebaseAuth auth;
    private List<listas> x ;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        auth = FirebaseAuth.getInstance();
        x=new ArrayList<>();
        usuarioReg = findViewById(R.id.txtUserRegistro);
        passReg = findViewById(R.id.txtPassRegistro);
        nombreReg = findViewById(R.id.txtNombreRegistro);
        btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(this);

    }

    @Override
    public boolean onNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegistro:
                registroProcess();
                break;
        }
    }

    public void registroProcess(){

        if(TextUtils.isEmpty(usuarioReg.getText().toString())){
            Toast.makeText(getApplicationContext(), "Ingrese el correo", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passReg.getText().toString())){
            Toast.makeText(getApplicationContext(), "Ingrese la contraseña", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(nombreReg.getText().toString())){
            Toast.makeText(getApplicationContext(), "Ingrese su nombre", Toast.LENGTH_SHORT).show();
            return;
        }
        if(passReg.getText().toString().length()<6){
            Toast.makeText(getApplicationContext(), "La contraseña almenos tiene que tener 6 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(usuarioReg.getText().toString(),passReg.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = auth.getCurrentUser();
                            mDatabase = FirebaseDatabase.getInstance().getReference();

                            x.add(new listas("lista"));
                            writeNewUser(user.getUid(),nombreReg.getText().toString(),usuarioReg.getText().toString(),x);
                            Toast.makeText(RegistroActivity.this, user.toString(),
                                    Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(RegistroActivity.this, "Autentificacion Fallida.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }

    private void writeNewUser(String userId, String name, String email,List<listas> lista) {
        usuarios user = new usuarios(name, email,lista);
        mDatabase.child("usuarios").child(userId).setValue(user);
    }
}

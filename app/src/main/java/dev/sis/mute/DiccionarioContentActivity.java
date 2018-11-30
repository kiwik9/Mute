package dev.sis.mute;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapters.DiccionarioDatosAdapter;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import models.DiccionarioDato;


public class DiccionarioContentActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private DiccionarioDatosAdapter mAdapter;
    private List<DiccionarioDato> mProductList;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario_content);

        mRecyclerView = findViewById(R.id.DiccionarioListData);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        id = getIntent().getExtras().getInt("id");
        mProductList = new ArrayList<>();
        getdatacontenct(id);

        mAdapter = new DiccionarioDatosAdapter(mProductList,this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void getdatacontenct(int id){

        switch (id){
            case 0:
                mProductList.add(new DiccionarioDato(R.drawable.letraa,"A"));
                mProductList.add(new DiccionarioDato(R.drawable.letrab,"B"));
                mProductList.add(new DiccionarioDato(R.drawable.letrac,"C"));
                mProductList.add(new DiccionarioDato(R.drawable.letrad,"D"));
                mProductList.add(new DiccionarioDato(R.drawable.letrae,"E"));
            break;

            case 1:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Rinoceronte"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Conejo"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Gato"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Arana"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Ganzo"));
                break;

            case 2:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Lunes"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Martes"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Miercoles"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Jueves"));
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Viernes"));
                break;

            case 3:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Dato"));
                break;

            case 4:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Dato"));
                break;

            case 5:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Dato"));
                break;

            case 6:
                mProductList.add(new DiccionarioDato(R.drawable.imgdicc,"Dato"));
                break;

        }

    }
}

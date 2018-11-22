package dev.sis.mute;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapters.DiccionarioAdapter;
import models.Diccionario;


public class DiccionarioFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private DiccionarioAdapter mAdapter;
    private List<Diccionario> mProductList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_diccionario, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.DiccionarioList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Populate the products
        mProductList = new ArrayList<>();
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Alfabeto"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Animales"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Fecha, Tiempo y Números"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Vida Diaria"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Medicina"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Animales"));
        mProductList.add(new Diccionario(R.drawable.imgdicc,"Tecnologia"));

        //set adapter to recyclerview
        mAdapter = new DiccionarioAdapter(mProductList,getContext());
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}
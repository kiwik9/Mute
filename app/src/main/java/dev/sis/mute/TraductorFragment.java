package dev.sis.mute;


import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import helpers.BottomNavigationViewHelper;


public class TraductorFragment extends Fragment {
    EditText textoTraductor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_traductor, container, false);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.navigationtraductor);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        textoTraductor = view.findViewById(R.id.textoTraductor);


        try{
            String fuente = "fonts/dedos2.TTF";
            Typeface fuenteMute = Typeface.createFromAsset(getActivity().getAssets(), fuente);
            textoTraductor.setTypeface(fuenteMute);
        }
        catch (Exception x)
        {
            Toast.makeText(getContext(), x.toString(), Toast.LENGTH_SHORT).show();
        }

        return view;

    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.i_music:

                    return true;

                case R.id.i_backup:

                    return true;

                case R.id.i_empty:

                    return true;

                case R.id.i_favor:

                    return true;

                case R.id.i_visibility:

                    return true;

            }
            return false;
        }
    };

}

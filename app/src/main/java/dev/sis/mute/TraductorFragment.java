package dev.sis.mute;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
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

import java.util.ArrayList;
import java.util.Locale;

import helpers.BottomNavigationViewHelper;
import services.TSSManager;

import static android.app.Activity.RESULT_OK;


public class TraductorFragment extends Fragment {
    EditText textoTraductor;
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    TSSManager ttsManager = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_traductor, container, false);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.navigationtraductor);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        textoTraductor = view.findViewById(R.id.textoTraductor);
        ttsManager = new TSSManager();
        ttsManager.init(getContext());

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

    private void startVoiceInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-ES");
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Ingrese el texto para la traduccion");
        try {

            getActivity().startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getContext(),
                    "Tú dispositivo no soporta el reconocimiento por voz",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        Toast.makeText(getContext(),
                "Paso por aqui",
                Toast.LENGTH_SHORT).show();
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    textoTraductor.setText(result.get(0));
                }
                break;
            }

        }
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
                    startVoiceInput();
                    return true;

                case R.id.i_favor:
                    String text = textoTraductor.getText().toString();
                    ttsManager.initQueue(text);
                    return true;

                case R.id.i_visibility:

                    return true;

            }
            return false;
        }
    };

    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }

}

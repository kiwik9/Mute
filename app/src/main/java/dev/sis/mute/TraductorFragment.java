package dev.sis.mute;


import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;;
import android.widget.Toast;

import com.github.clans.fab.FloatingActionButton;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import services.TSSManager;

import static android.app.Activity.RESULT_OK;


public class TraductorFragment extends Fragment implements View.OnClickListener {
    EditText textoTraductor;
    private static final int REQ_CODE_SPEECH_INPUT = 100;
    TSSManager ttsManager = null;
    private SpaceNavigationView spaceNavigationView;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_traductor, container, false);


        textoTraductor = view.findViewById(R.id.textoTraductor);
        ttsManager = new TSSManager();
        ttsManager.init(getContext());

        fab1 = view.findViewById(R.id.fab1);
        fab2 = view.findViewById(R.id.fab2);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);

        try{
            String fuente = "fonts/dedos2.TTF";
            Typeface fuenteMute = Typeface.createFromAsset(getActivity().getAssets(), fuente);
            textoTraductor.setTypeface(fuenteMute);
        }
        catch (Exception x)
        {
            Toast.makeText(getContext(), x.toString(), Toast.LENGTH_SHORT).show();

        }

        spaceNavigationView = view.findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("Sync", R.drawable.ic_sync));
        spaceNavigationView.addSpaceItem(new SpaceItem("Copiar", R.drawable.ic_content_copy));
        spaceNavigationView.addSpaceItem(new SpaceItem("Voz", R.drawable.ic_volume_up_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("Texto", R.drawable.ic_text));
        spaceNavigationView.showIconOnly();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                startVoiceInput();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                switch (itemIndex)
                {
                    case 0:
                        textoTraductor.setText("");

                        break;

                    case 1:
                        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
                        ClipData clip = ClipData.newPlainText("Copiado", textoTraductor.getText());
                        clipboard.setPrimaryClip(clip);
                        Toast.makeText(getContext(), clip.toString()+"Paso", Toast.LENGTH_SHORT).show();
                        break;

                    case 2:
                        String text = textoTraductor.getText().toString();
                        ttsManager.initQueue(text);
                        break;

                    case 3:

                        break;
                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                /*
                Toast.makeText(getContext(), itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                */
            }
        });

        return view;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        spaceNavigationView.onSaveInstanceState(outState);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.fab1:
                Toast.makeText(getContext(),
                        "Compartir",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.fab2:


                break;
        }
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

    public void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }



}

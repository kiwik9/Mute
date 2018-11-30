package adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import dev.sis.mute.DiccionarioContentActivity;
import dev.sis.mute.R;
import dev.sis.mute.RegistroActivity;
import models.DiccionarioDato;

public class DiccionarioDatosAdapter extends RecyclerView.Adapter<DiccionarioDatosAdapter.DiccionarioViewHolder> {


    private List<DiccionarioDato> diccionarioList;
    Context context;

    public DiccionarioDatosAdapter(List<DiccionarioDato> diccionarioList, Context context) {
        this.diccionarioList = diccionarioList;
        this.context = context;
    }

    public DiccionarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflate the layout file
        View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.diccionario_cart_data, parent, false);
        DiccionarioViewHolder gvh = new DiccionarioViewHolder(groceryProductView);
        return gvh;
    }

    public void onBindViewHolder(DiccionarioViewHolder holder, final int position) {
        holder.imgDiccionario.setImageResource(diccionarioList.get(position).getDiccionarioImageDatos());
        holder.txtProductName.setText(diccionarioList.get(position).getNombreDiccionario());

        holder.txtProductName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    public int getItemCount() {
        return diccionarioList.size();
    }

    public class DiccionarioViewHolder extends RecyclerView.ViewHolder {
        ImageView imgDiccionario;
        TextView txtProductName;

        public DiccionarioViewHolder(View view) {
            super(view);
            imgDiccionario = view.findViewById(R.id.idNombreImagen);
            txtProductName = view.findViewById(R.id.idNombre);
        }
    }
}

package models;

import java.util.List;

public class usuarios {

    String nombre;
    String correo;
    List<listas> listas;

    public usuarios(String nombre, String correo, List<listas> lista) {
        this.nombre = nombre;
        this.correo = correo;
        this.listas = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<listas> getLista() {
        return listas;
    }

    public void setLista(List<listas> lista) {
        this.listas = lista;
    }
}

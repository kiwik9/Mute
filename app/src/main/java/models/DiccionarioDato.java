package models;

public class DiccionarioDato {
    public int diccionarioImageDatos;
    public String nombreDiccionario;

    public DiccionarioDato(int productImage, String productName) {
        this.diccionarioImageDatos = productImage;
        this.nombreDiccionario = productName;
    }

    public int getDiccionarioImageDatos() {
        return diccionarioImageDatos;
    }

    public void setDiccionarioImageDatos(int diccionarioImageDatos) {
        this.diccionarioImageDatos = diccionarioImageDatos;
    }

    public String getNombreDiccionario() {
        return nombreDiccionario;
    }

    public void setNombreDiccionario(String nombreDiccionario) {
        this.nombreDiccionario = nombreDiccionario;
    }
}

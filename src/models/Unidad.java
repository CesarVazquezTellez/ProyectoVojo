package models;

public class Unidad {
    private int id_unidad;
    private int id_operador;
    private String modelo;
    private String marca;
    private String placas;
    private int id_propietario;
    private int capacidad;
    private int anio;

    public Unidad(int id_unidad, int id_operador, String modelo, String marca, String placas, int id_propietario, int capacidad, int anio) {
        this.id_unidad = id_unidad;
        this.id_operador = id_operador;
        this.modelo = modelo;
        this.marca = marca;
        this.placas = placas;
        this.id_propietario = id_propietario;
        this.capacidad = capacidad;
        this.anio = anio;
    }

    public int getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(int id_unidad) {
        this.id_unidad = id_unidad;
    }

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public int getId_propietario() {
        return id_propietario;
    }

    public void setId_propietario(int id_propietario) {
        this.id_propietario = id_propietario;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

}

package models;

public class Usuarios {
    private int id_usuario;
    private String nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String telefono;
    private String correo_electronico;
    private int id_rol;

    public Usuarios(int id_usuario, String nombre, String primer_apellido, String segundo_apellido, String telefono,
            String correo_electronico, int id_rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.primer_apellido = primer_apellido;
        this.segundo_apellido = segundo_apellido;
        this.telefono = telefono;
        this.correo_electronico = correo_electronico;
        this.id_rol = id_rol;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPrimer_apellido() {
        return primer_apellido;
    }
    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }
    public String getSegundo_apellido() {
        return segundo_apellido;
    }
    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCorreo_electronico() {
        return correo_electronico;
    }
    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    public int getId_rol() {
        return id_rol;
    }
    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }
     

}
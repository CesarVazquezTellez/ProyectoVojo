package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuariosDAO {
    private Connection conn;

    public UsuariosDAO(Connection conn) {
        this.conn = conn;
    }

    public int insertarUsuarios(Usuarios usuarios) {

        String sql = "INSERT INTO usuarios (id_usuario, nombre, primer_apellido, segundo_apellido, telefono, correo_electronico, id_rol) VALUES (?, ?, ?, ?, ?, ?, ?)";
        int rows = 0;
        

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, usuarios.getId_usuario());
            stmt.setString(2, usuarios.getNombre());
            stmt.setString(3, usuarios.getPrimer_apellido());
            stmt.setString(4, usuarios.getSegundo_apellido());
            stmt.setString(5, usuarios.getTelefono());
            stmt.setString(6, usuarios.getCorreo_electronico());
            stmt.setInt(7, usuarios.getId_rol());
            rows = stmt.executeUpdate();
        } catch(SQLException e){ 
            System.out.println("Error al insertar el usuario: "+ e.getMessage());
        }
        return rows;
    }
}

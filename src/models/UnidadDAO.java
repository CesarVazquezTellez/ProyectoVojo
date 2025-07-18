package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UnidadDAO {
    private Connection conn;

    public UnidadDAO(Connection conn) {
        this.conn = conn;
    }

    public int insertarUnidad(Unidad unidad) {

        String sql = "INSERT INTO unidades (id_unidad, id_operador, modelo, marca, placas, id_propietario, capacidad, anio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        int rows = 0;
        

        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, unidad.getId_unidad());
            stmt.setInt(2, unidad.getId_operador());
            stmt.setString(3, unidad.getModelo());
            stmt.setString(4, unidad.getMarca());
            stmt.setString(5, unidad.getPlacas());
            stmt.setInt(6, unidad.getId_propietario());
            stmt.setInt(7, unidad.getCapacidad());
            stmt.setInt(8, unidad.getAnio());
            rows = stmt.executeUpdate();
        } catch(SQLException e){ 
            System.out.println("Error al insertar carrera: "+ e.getMessage());
        }
        return rows;
    }
}

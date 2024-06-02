package dal;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAL {
    // método que sirve para leer los registros de la tabla
    public static ArrayList<Producto> obtenerTodos() throws SQLException{
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prod;

        try{
            String sql = "SELECT Id, Nombre, Precio, Cantidad FROM Productos";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ResultSet rs = ComunDB.obtenerResultSet(ps);
            while (rs.next()){
                prod = new Producto(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4));
                productos.add(prod);
            }
            conexion.close();
            ps.close();
            rs.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return productos;
    }

    // método que permite guardar un nuevo producto
    public static int guardar(Producto producto) throws SQLException{
        int result = 0;
        try{
            String sql = "INSERT INTO Productos(Nombre, Precio, Cantidad) VALUES(?, ?, ?)";
            Connection conexion = ComunDB.obtenerConexion();
            PreparedStatement ps = ComunDB.crearPreparedStatement(conexion, sql);
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getCantidad());
            result = ps.executeUpdate();
            conexion.close();
            ps.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

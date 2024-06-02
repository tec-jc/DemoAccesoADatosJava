package dal;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class ComunDB {
    private static String cadenaConexion = "jdbc:mysql://localhost:3306/tienda?user=root&password=AdminRoot2024";

    public static Connection obtenerConexion() throws SQLException{
        DriverManager.registerDriver(new Driver());
        Connection conexion = DriverManager.getConnection(cadenaConexion);
        return conexion;
    }

    public static PreparedStatement crearPreparedStatement(Connection con, String sql) throws SQLException{
        PreparedStatement ps = con.prepareStatement(sql);
        return ps;
    }

    public static ResultSet obtenerResultSet(PreparedStatement ps) throws SQLException{
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}

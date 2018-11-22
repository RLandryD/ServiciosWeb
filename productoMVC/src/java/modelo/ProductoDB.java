package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Producto;

public class ProductoDB {

    public List<Producto> getAll() {
        try {
            String sql = "SELECT * FROM PRODUCTO";
            PreparedStatement preparedStatement
                    = Conexion.getInstance().prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            List<Producto> list = new LinkedList<>();
            Producto producto;
            while (rs.next()) {
                producto = new Producto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("precio")
                );
                list.add(producto);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("Error all producto: " + e.getMessage());
            return null;
        }
    }

    public void deleteProducto(int id) {
        PreparedStatement preparedStatement = null;
        String sql = null;
        sql = "delete from producto where id='" + id + "'";
        try {
            preparedStatement = Conexion.getInstance().prepareStatement(sql);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Ocurrio un error al eliminar producto:" + ex.getMessage());
        }
    }
}

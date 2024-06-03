package gui;

import dal.ProductoDAL;
import entidades.Producto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlProductos {
    public static void main(String[] args) throws SQLException {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto prod;
        int opcion;
        Scanner sc = new Scanner(System.in);

        System.out.println("***** MENU *****");
        System.out.println("Ver registros          --> 1");
        System.out.println("Nuevo registro         --> 2");
        System.out.println("*****************");
        System.out.println("Ingrese la operación que desea realizar");
        opcion = sc.nextInt();

        switch (opcion){
            case 1:
                productos = ProductoDAL.obtenerTodos();
                // recorrido de la lista para mostrar el contenido
                for(Producto pr : productos){
                    System.out.println(pr.getId() + " " + pr.getNombre() + " " +
                            pr.getPrecio() + " " + pr.getCantidad());
                }
                break;
            case 2:
                prod = new Producto();
                System.out.println("Ingrese el nombre del producto");
                prod.setNombre(sc.next());

                System.out.println("Ingrese el precio del producto");
                prod.setPrecio(sc.nextDouble());

                System.out.println("Ingrese la cantidad de producto disponible");
                prod.setCantidad(sc.nextInt());

                ProductoDAL.guardar(prod);
                System.out.println("El registro se guardó con éxito");
                break;
            default:
                System.out.println("Error, operación no válida");
        }
    }
}

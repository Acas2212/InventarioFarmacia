/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication31;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author angel
 */
public class JavaApplication31 {

    private static inventariofarmacia inventario = new inventariofarmacia();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Inventario Farmacia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton btnAgregar = new JButton("Agregar Producto");
        JButton btnConsultar = new JButton("Consultar Producto");
        JButton btnMostrar = new JButton("Mostrar Inventario");
        JButton btnVender = new JButton("Vender Producto");
        JButton btnActualizar = new JButton("Actualizar Precio");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnAgregar);
        panel.add(btnConsultar);
        panel.add(btnMostrar);
        panel.add(btnVender);
        panel.add(btnActualizar);
        panel.add(btnSalir);

        btnAgregar.addActionListener(e -> agregarProducto());
        btnConsultar.addActionListener(e -> consultarProducto());
        btnMostrar.addActionListener(e -> inventario.mostrarInventario());
        btnVender.addActionListener(e -> venderProducto());
        btnActualizar.addActionListener(e -> actualizarPrecio());
        btnSalir.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }

    private static void agregarProducto() {
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        String codigo = JOptionPane.showInputDialog("Código de barras:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio unitario:"));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Cantidad en stock:"));

        ProdcutoTDO producto = new ProdcutoTDO(nombre, codigo, precio, stock);
        inventario.agregarProducto(producto);
    }

    private static void consultarProducto() {
        String codigo = JOptionPane.showInputDialog("Ingrese código de barras:");
        ProdcutoTDO p = inventario.buscarProductoPorCodigo(codigo);
        if (p != null) {
            JOptionPane.showMessageDialog(null, String.format(
                    "Nombre: %s\nCódigo: %s\nPrecio: %.2f\nStock: %d",
                    p.getNombre(), p.getCodigoBarras(), p.getPrecioUnitario(), p.getCantidadStock()
            ));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        }
    }

    private static void venderProducto() {
        String codigo = JOptionPane.showInputDialog("Código de barras:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a vender:"));
        inventario.venderProducto(codigo, cantidad);
    }

    private static void actualizarPrecio() {
        String codigo = JOptionPane.showInputDialog("Código de barras:");
        double nuevoPrecio = Double.parseDouble(JOptionPane.showInputDialog("Nuevo precio:"));
        inventario.actualizarPrecio(codigo, nuevoPrecio);
    }

    static class java {

        public java() {
        }

        void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication31;

import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class inventariofarmacia {
     private ProdcutoTDO[] productos = new ProdcutoTDO[100];
    private int contadorProductos = 0;

    public void agregarProducto(ProdcutoTDO producto) {
        if (contadorProductos < productos.length) {
            productos[contadorProductos++] = producto;
            JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Inventario lleno.");
        }
    }

    public ProdcutoTDO buscarProductoPorCodigo(String codigoBarras) {
        for (int i = 0; i < contadorProductos; i++) {
            if (productos[i].getCodigoBarras().equals(codigoBarras)) {
                return productos[i];
            }
        }
        return null;
    }

    public void mostrarInventario() {
        StringBuilder sb = new StringBuilder("Inventario:\n");
        for (int i = 0; i < contadorProductos; i++) {
            ProdcutoTDO p = productos[i];
            sb.append(String.format("Nombre: %s | Código: %s | Precio: %.2f | Stock: %d\n",
                p.getNombre(), p.getCodigoBarras(), p.getPrecioUnitario(), p.getCantidadStock()));
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void venderProducto(String codigo, int cantidad) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param codigo
     * @param nuevoPrecio
     */
    public void actualizarPrecio(String codigo, double nuevoPrecio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

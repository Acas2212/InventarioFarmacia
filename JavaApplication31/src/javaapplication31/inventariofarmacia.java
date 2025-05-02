package javaapplication31;

import javax.swing.JOptionPane;

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

    public boolean venderProducto(String codigo, int cantidad) {
        ProdcutoTDO producto = buscarProductoPorCodigo(codigo);
        if (producto != null && producto.getCantidadStock() >= cantidad) {
            producto.setCantidadStock(producto.getCantidadStock() - cantidad);
            JOptionPane.showMessageDialog(null, "Venta realizada con éxito.");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Stock insuficiente o producto no encontrado.");
        return false;
    }

    public boolean actualizarPrecio(String codigo, double nuevoPrecio) {
        ProdcutoTDO producto = buscarProductoPorCodigo(codigo);
        if (producto != null) {
            producto.setPrecioUnitario(nuevoPrecio);
            JOptionPane.showMessageDialog(null, "Precio actualizado.");
            return true;
        }
        JOptionPane.showMessageDialog(null, "Producto no encontrado.");
        return false;
    }
}

package views;

import DAO.ProductDAO;
import models.Product;
import utils.ConsoleHelper;

public class ProductView {
    public static void registerProduct() {
        String id = ConsoleHelper.readString("Introduce el id del producto: ");
        String name = ConsoleHelper.readString("Introduce el nombre del producto: ");
        int stock = ConsoleHelper.readInteger("Introduce el stock disponible: ");
        double price = ConsoleHelper.readIDouble("Introduce el precio del producto: ");
        int IVA = ConsoleHelper.readInteger("Introduce el IVA del producto: ");

        boolean isRegistered = new ProductDAO().registerProduct(new Product(id, name, stock, price, IVA));

        if (!isRegistered) {
            System.out.printf("%n%n[!] El producto ya esta registrado%n");
            return;
        }

        System.out.printf("%n%n[+] Producto registrado correctamente%n%n");

        ConsoleHelper.readString("Pulse enter para volver al menu");
    }

    public static void updateProduct() {

        Product p = null;
        int updateOpt;

        printAllProducts();

        do {
            String id = ConsoleHelper.readString("Introduce el id del producto a actualizar: ");
            p = new ProductDAO().getProductByID(id);
        } while (p == null);

        do {
            ConsoleHelper.printUpdateProductMenu();
            updateOpt = ConsoleHelper.choseOption(0, 3);

            switch (updateOpt) {
                case 1 -> updateProductStock(p);
                case 2 -> updateProductPrice(p);
                case 3 -> updateProductIVA(p);
            }

        } while (updateOpt != 0);

        System.out.printf("%n%n[+] Producto actualizado correctamente%n");
        ConsoleHelper.readString("Pulse enter para volver al menu");

    }

    public static void deleteProduct() {
        Product p = null;

        printAllProducts();

        do {
            String id = ConsoleHelper.readString("Introduce el id del producto a eliminar: ");
            p = new ProductDAO().getProductByID(id);
        } while (p == null);

        new ProductDAO().deleteProduct(p);

        System.out.printf("%n%n[+] Producto eliminado correctamente%n");
        ConsoleHelper.readString("Pulse enter para volver al menu");

    }

    private static void updateProductIVA(Product p) {
        int IVA = ConsoleHelper.readInteger("Introduce el nuevo IVA para el producto: ");

        new ProductDAO().modifyProductIVA(p, IVA);
    }

    private static void updateProductPrice(Product p) {
        double price = ConsoleHelper.readInteger("Introduce el nuevo precio para el producto: ");

        new ProductDAO().modifyProductPrice(p, price);
    }

    private static void updateProductStock(Product p) {
        int stock = ConsoleHelper.readInteger("Introduce el nuevo stock para el producto: ");

        new ProductDAO().modifyProductStock(p, stock);
    }

    private static void printAllProducts() {
        System.out.printf("%n%nListado de productos registrados%n");
        System.out.printf("%-20s %-20s %-20s %-20s %s%n", "ID", "Name", "Stock", "Price", "IVA");
        for (Product p : new ProductDAO().getAllProducts()) {
            System.out.printf("\t[%s] %-20s %-20s %-20s %s%n", p.getId(), p.getName(), p.getStock(), p.getPrice(), p.getIVA());
        }
        System.out.println();
    }

}

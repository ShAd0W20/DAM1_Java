package views;

import DAO.ProductDAO;
import DAO.ShoppingCartDAO;
import DAO.UserDAO;
import models.Product;
import models.ShoppingCart;
import models.ShoppingCartProduct;
import models.User;
import org.jetbrains.annotations.NotNull;
import utils.ConsoleHelper;
import utils.ExportBillToPDF;

public class ShopView {

    public static boolean mainShopMenu() {
        System.out.println("Bienvenido, primero de todo tendrás que iniciar sesión");

        User u = null;

        do {
            String dni = ConsoleHelper.readString("Introduce tu DNI: ");
            String password = ConsoleHelper.readString("Introduce la contraseña: ");

            u = new User(dni, password);

            u = new UserDAO().login(u);

            if (u == null) {
                System.out.println("\n\n[!] Al parecer no estas registrado\n");
                return false;
            } else if (u.getEmail() == null) {
                System.out.println("\n\n[!] Contraseña incorrecta\n");
            }
        } while (u == null || u.getEmail() == null);

        loggedInShop(u);
        return true;

    }

    private static void loggedInShop(User u) {
        ShoppingCart cart = new ShoppingCart();

        System.out.printf("%nBienvenido a la tienda online! %n%nEstos son los productos disponibles: %n");

        buyMenu(cart);

        modifyProducts(cart);

        printFinalBill(cart, u);

        ConsoleHelper.readString("\n[+] Pulse enter para volver al menu");
    }

    private static void buyMenu(@NotNull ShoppingCart cart) {
        int shopOpt;
        do {
            Product p = null;
            printAllProducts();

            while (p == null) {
                String productCode = ConsoleHelper.readString("\nEscriba el nombre del producto: ");
                p = new ProductDAO().getProductByName(productCode);
            }

            int productQuantity = ConsoleHelper.readInteger("\nIntroduce la cantidad deseada: ");
            int productStock = new ProductDAO().getProductStock(p);

            while (productStock < productQuantity) {
                productQuantity = ConsoleHelper.readInteger(String.format("%nIntroduce la cantidad deseada actualmente disponemos de [%s] unidades: ", productStock));
            }

            cart.addProductToCart(new ShoppingCartProduct(p, productQuantity));

            printActualCart(cart);

            ConsoleHelper.printShopContinueShopping();
            shopOpt = ConsoleHelper.choseOption(0, 1);

        } while (shopOpt != 0);
    }

    private static void printAllProducts() {
        System.out.println();
        for (Product p : new ProductDAO().getAllProducts()) {
            if (p.getStock() > 0) {
                System.out.printf("\t[%s] %s -> %s€/k %n", p.getId(), p.getName(), p.getPrice());
            }
        }
    }

    private static void printActualCart(@NotNull ShoppingCart cart) {
        System.out.printf("%n%n[+] Carrito:%n");

        for (ShoppingCartProduct product : cart.getAllProducts()) {
            System.out.printf("\t[%s] %s -> %s€ | %s unidades %n", product.getProduct().getId(), product.getProduct().getName(), product.getProduct().getPrice(), product.getQuantity());
        }
        System.out.println();
    }

    private static void modifyProducts(@NotNull ShoppingCart cart) {
        int modifyProducts;

        do {
            ShoppingCartProduct product = null;
            String productName = "";

            System.out.printf("%nDesea modificar la cantidad de algun producto? %n[1] Si %n[0] No%n");
            modifyProducts = ConsoleHelper.choseOption(0, 1);

            if (modifyProducts == 0) return;

            System.out.printf("%n%nActualmente tiene estos productos en la cesta: %n");
            printActualCart(cart);

            while (product == null) {
                productName = ConsoleHelper.readString("Escriba el nombre del producto a modificar la cantidad: ");
                product = cart.searchProductInCartByName(productName);
            }

            System.out.printf("%nActualmente tiene [%s] unidades del producto %s%n", product.getQuantity(), productName);

            int newQuantity = ConsoleHelper.readInteger("Introduzca la nueva cantidad: ");

            int productStock = new ProductDAO().getProductStock(product.getProduct());

            while (productStock < newQuantity) {
                newQuantity = ConsoleHelper.readInteger(String.format("%nIntroduce la nueva cantidad deseada actualmente disponemos de [%s] unidades: ", productStock));
            }

            cart.modifyProductQuantity(productName, newQuantity);

            System.out.printf("%n%n[+] Producto modificado correctamente!%n");

        } while (modifyProducts != 0);

    }

    private static void printFinalBill(@NotNull ShoppingCart cart, User u) {
        double totalPrice = 0.0;
        String data = "";

        new ShoppingCartDAO().addProductsToShoppingCart(cart, u);

        for (ShoppingCartProduct product : cart.getAllProducts()) {
            new ProductDAO().modifyProductStock(product);
            totalPrice += calculateProductPriceWithIVA(product.getProduct().getPrice() * product.getQuantity(), product.getProduct().getIVA());
            data += String.format("%-20s %-20s %-20s %-20s %s€%n",
                    product.getProduct().getName(),
                    String.format("%.2f€", product.getProduct().getPrice()),
                    product.getQuantity(),
                    String.format("%.2f", (double) product.getProduct().getIVA() / 100),
                    String.format("%.2f", product.getProduct().getPrice() * product.getQuantity())
            );
        }

        billFormat(data, totalPrice);

        ExportBillToPDF.export(cart, totalPrice);

    }

    private static void billFormat(String data, double totalPrice) {
        System.out.println("*".repeat(120));
        System.out.printf("%60s%n", "FACTURA");
        System.out.println("*".repeat(120));

        System.out.println();
        System.out.println("-".repeat(120));

        System.out.printf("%-20s %-20s %-20s %-20s %s%n", "Nombre", "Precio", "Cantidad", "IVA", "Total");

        System.out.print(data);

        System.out.println("-".repeat(120));
        System.out.printf("%nPRECIO TOTAL: %s€%n%n", String.format("%.2f", totalPrice));
    }

    private static double calculateProductPriceWithIVA(double totalPrice, int IVA) {
        return (totalPrice + (totalPrice * (double) IVA / 100));
    }
}

package main.java.views;

import main.java.DAO.ProductDAO;
import main.java.DAO.SellsDAO;
import main.java.DAO.UserDAO;
import main.java.models.Bill;
import main.java.models.Product;
import main.java.models.ShoppingCartProduct;
import org.jetbrains.annotations.NotNull;
import main.java.utils.ConsoleHelper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SellsView {
	public static void viewUserBill() {
        System.out.println(String.format("%-20s %-20s %-20s %n", "ID Factura", "DNI cliente", "Nombre"));
        System.out.println(new SellsDAO().getAllBills());

        String billOwner = ConsoleHelper.readString("Introduce el dni del cliente: ");
        String billid = ConsoleHelper.readString("Introduce el identificador de la factura: ");

        Bill bill = new SellsDAO().getBillFromUser(billOwner, billid);

        if (bill == null) {
            System.out.printf("%n%n[!] Factura no encontrada %nPulse enter para volver al menu%n");
            return;
        }

        printBill(bill);
        ConsoleHelper.readString("\nPulse enter para volver al menu\n");
    }

    public static void viewAllBillsFromUser() {
    	viewAllUsers();

        String billOwner = ConsoleHelper.readString("\nIntroduce el dni del cliente: ");

        ArrayList<Bill> userBills = new SellsDAO().getAllBillsFromUser(billOwner);

        if (userBills == null) {
            System.out.printf("%n%n[!] Facturs no encontradas %nPulse enter para volver al menu%n");
            return;
        }

        System.out.printf("%n%n");

        for (Bill bill : userBills) {
            printBill(bill);
        }

        ConsoleHelper.readString("\nPulse enter para volver al menu\n");

    }

    public static void viewAllBillsBetweenDates() {
    	viewAllUsers();
        String billOwner = ConsoleHelper.readString("\nIntroduce el dni del cliente: ");
        LocalDate startDate = ConsoleHelper.readLocalDate("Introduce la fecha de inicio: ");
        LocalDate endDate = ConsoleHelper.readLocalDate("Introduce la fecha final: ");

        ArrayList<Bill> userBills = new SellsDAO().getAllBillsFromUserBetweenDates(billOwner, startDate, endDate);

        if (userBills == null) {
            System.out.printf("%n%n[!] Facturas no encontradas %n");
            ConsoleHelper.readString("Pulse enter para volver al menu");
            return;
        }

        if (userBills.isEmpty()) {
            System.out.printf("%n%n[!] Facturas no encontradas para esas fechas %n");
            ConsoleHelper.readString("Pulse enter para volver al menu");
            return;
        }

        System.out.printf("%n%n");

        for (Bill bill : userBills) {
            printBill(bill);
        }

        ConsoleHelper.readString("Pulse enter para volver al menu");

    }

    public static void viewProductStatistics() {
        printAllProducts();
        String productName = ConsoleHelper.readString("Introduce el nombre del producto: ");

        System.out.println(new SellsDAO().getProductStatistics(productName));
        ConsoleHelper.readString("Pulse enter para volver al menu");
    }

    public static void viewAllProductStatistics() {
        System.out.println(new SellsDAO().getAllProductsStatistics());
        ConsoleHelper.readString("Pulse enter para volver al menu");
    }

    private static void printBill(@NotNull Bill bill) {
        double totalPrice = 0.0;
        StringBuilder data = new StringBuilder();

        for (ShoppingCartProduct product : bill.getProducts()) {
            totalPrice += calculateProductPriceWithIVA(product.getProduct().getPrice() * product.getQuantity(), product.getProduct().getIVA());
            data.append(String.format("%-20s %-20s %-20s %-20s %s€%n",
                    product.getProduct().getName(),
                    String.format("%.2f€", product.getProduct().getPrice()),
                    product.getQuantity(),
                    String.format("%.2f", (double) product.getProduct().getIVA() / 100),
                    String.format("%.2f", product.getProduct().getPrice() * product.getQuantity())
            ));
        }

        billFormat(data.toString(), totalPrice, bill.getBillID(), bill.getBillDate());
    }

    private static void billFormat(String data, double totalPrice, String billid, LocalDate billdate) {
        System.out.println("*".repeat(120));
        System.out.printf("%60s %5s %10s%n", "FACTURA", billid, billdate.format(DateTimeFormatter.ofPattern("d/M/y")));
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
    
    private static void viewAllUsers() {
    	System.out.printf("%n%n[+] Listado de usuarios registrados%n");
		System.out.printf("%n%-20s %-20s %-20s %-20s %-20s%n", "DNI", "Name", "Email", "Phone", "Address");
		
		new UserDAO()
		.getAllUsers()
		.forEach((u) -> System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", u.getDni(), u.getName(), u.getEmail(), u.getPhone(), u.getAddress()));
    }

    public static void printAllProducts() {
        System.out.printf("%n%nListado de productos registrados%n");
        System.out.printf("%-20s %-20s %-20s %-20s %s%n", "ID", "Name", "Stock", "Price", "IVA");
        for (Product p : new ProductDAO().getAllProducts()) {
            System.out.printf("%-20s %-20s %-20s %-20s %s%n", String.format("[%s]", p.getId()), p.getName(), p.getStock(), p.getPrice(), p.getIVA());
        }
        System.out.println();
    }
}

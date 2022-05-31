package main.java.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import main.java.models.ShoppingCart;
import main.java.models.User;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ExportBillToPDF {

	public static void export(ShoppingCart cart, double totalPrice, User u) {
		try {
			Document document = new Document();
			String billName = String.format("%s_%s_%s.pdf", "Bill", u.getDni(), LocalDate.now().toString());

			PdfWriter.getInstance(document, new FileOutputStream(billName));
			document.open();
			document.add(new Paragraph(String.format("%n")));
			
			document.add(new Paragraph(String.format("%n%-20s %n%-20s %n%-20s %n%-20s %n%-20s %n%-20s %n%-20s %n%-20s %n%-20s %n%-20s%n", "DNI", u.getDni(), "Name", u.getName(), "Email",  u.getEmail(), "Phone", u.getPhone(), "Address", u.getAddress())));
			
			document.add(new Paragraph(String.format("%n")));
			
			document.add(new Paragraph("*".repeat(110)));
			document.add(new Paragraph(String.format("%70s %10s", "FACTURA - ", LocalDate.now().format(DateTimeFormatter.ofPattern("d/M/y")))));
			document.add(new Paragraph("*".repeat(110)));
			

			PdfPTable table = new PdfPTable(5);
			PdfPCell columnHeader;
			// Fill table columns.
			columnHeader = new PdfPCell(new Phrase("Nombre"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("Precio"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("Cantidad"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("IVA"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);

			columnHeader = new PdfPCell(new Phrase("Total"));
			columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(columnHeader);

			table.setHeaderRows(1);
			// Fill table rows.
			for (int row = 0; row < cart.getAllProducts().size(); row++) {

				table.addCell(cart.getAllProducts().get(row).getProduct().getName());
				table.addCell(String.format("%s€", cart.getAllProducts().get(row).getProduct().getPrice()));
				table.addCell(String.format("%s", cart.getAllProducts().get(row).getQuantity()));
				table.addCell(String.format("%.2f", (double) cart.getAllProducts().get(row).getProduct().getIVA() / 100));
				table.addCell(String.format("%.2f€", cart.getAllProducts().get(row).getProduct().getPrice() * cart.getAllProducts().get(row).getQuantity()));
			}
			document.add(table);

			document.add(new Paragraph(""));
			document.add(new Paragraph(String.format("%nPRECIO TOTAL: %s€%n%n", String.format("%.2f", totalPrice))));

			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
	}
}

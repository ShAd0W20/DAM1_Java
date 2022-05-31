package utils;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import models.ShoppingCart;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ExportBillToPDF {

    public static void export(ShoppingCart cart, double totalPrice) {
        try {
            Document document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream("VirtualShopClient\\src\\main\\resources\\Bill.pdf"));
            document.open();

            document.add(new Paragraph("*".repeat(110)));
            document.add(new Paragraph(String.format("%70s", "FACTURA")));
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
                table.addCell(String.format("%.2f", (double)cart.getAllProducts().get(row).getProduct().getIVA() / 100));
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

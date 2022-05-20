package main;

import controller.Controllers;
import java.io.File;
import java.util.ArrayList;
import model.FileOperations;
import model.InvoiceHeader;
import view.View;

public class Main {

    public static void main(String[] args) {
        ArrayList<InvoiceHeader> invoices = new ArrayList<>();
        View view = new View();
        view.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        view.setVisible(true);
        view.setLocations();
        new Controllers(invoices, view);
        FileOperations fileOperations = new FileOperations(view);
        fileOperations.selectedInvoiceHeader = new File("resources/InvoiceHeader.csv");
        fileOperations.selectedInvoiceLine = new File("resources/InvoiceLine.csv");
        Controllers.invoices = fileOperations.readFile();
        Controllers.calculateTotal(Controllers.invoices);
        Controllers.loadTable(view, Controllers.invoices);
        fileOperations.getMaxNumberOfExistedInvoices(Controllers.numberOfCurrentInvoices, Controllers.invoices);
    }
}

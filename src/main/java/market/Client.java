package market;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private List<Sale> sales;

    public Client() {
        this.sales = new ArrayList<>();
    }

    public void register(Sale sale){
        this.name = sale.getClient();
        sales.add(sale);
    }

    public String getName() {
        return name;
    }

    public double getTotalExpenses() {
        double total=0;
        for (Sale sale : sales) {
            total += sale.getTotalPrice();
        }
        return total;
    }

    public int getTotalProductsBought() {
        int total = 0;
        for (Sale sale : sales) {
            total += sale.getQuantitySold();
        }
        return total;
    }

    public void showData() {
        System.out.println("------------------------");
        System.out.print("Client Name: ");
        System.out.println(this.name);
        System.out.print("Total Expenses: R$ ");
        System.out.println(getTotalExpenses());
        System.out.print("Total Products Bought: ");
        System.out.println(getTotalProductsBought());
        System.out.print("Sales: ");
        System.out.println();
        for (Sale sale : sales) {
            sale.showData(true, false, true, true, true);
        }
    }
    public void showData(boolean withName, boolean withTotalExpenses, boolean withProductsBought, boolean withSales) {
        System.out.println("------------------------");
        if (withName) {
            System.out.print("Client Name: ");
            System.out.println(this.name);
        }
        if (withTotalExpenses) {
            System.out.print("Total Expenses: R$ ");
            System.out.println(getTotalExpenses());
        }
        if (withProductsBought) {
            System.out.print("Total Products Bought: ");
            System.out.println(getTotalProductsBought());
        }
        if (withSales) {
            System.out.print("Sales: ");
            System.out.println();
            for (Sale sale : sales) {
                sale.showData(true, false, true, true, true);
            }
        }
    }
}

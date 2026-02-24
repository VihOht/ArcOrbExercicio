package main;

import files.FileManager;
import market.Market;
import market.Sale;

import java.util.List;

public class Main {

    static void main(String[] args) {
        // TESTING
        Market market = new Market();
        market.registerSales(FileManager.VENDAS1);

        System.out.print("Total Income: ");
        System.out.println(market.getAllIncome());
        System.out.print("Quantity of Products Sold: ");
        System.out.println(market.getAllSold());
        System.out.print("Mean Price by Sale: ");
        System.out.println(market.getMeanSalePrice());


    }
}

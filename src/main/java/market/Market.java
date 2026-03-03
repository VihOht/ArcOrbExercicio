package market;

import utils.FileManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {
    HashMap<String, Client> clients = new HashMap<>();

    HashMap<String, Product> products = new HashMap<>();

    List<Sale> sales = new ArrayList<>();


    public void registerSales(String vendasFile) {
        // Create a List of String Arrays whose content are each data of a CSV line;
        List<String[]> vendasData = FileManager.ReadCSV(vendasFile);

        for (String[] data : vendasData) {
            try {
                // Create and register the sale on the market;
                Sale sale = new Sale();
                sale.registerSale(data);
                this.sales.add(sale);

                // I hope the trash collect works;

                // If the client does not exist, register it, if not just register the sale;
                Client clientObj = clients.get(sale.getClient());
                if (clientObj == null) {
                    clientObj = new Client();
                    clientObj.register(sale);
                    this.clients.putIfAbsent(sale.getClient(), clientObj);
                } else {
                    clientObj.register(sale);
                }

                // If the product does not exist, register it, if not just register the sale;

                Product productObj = products.get(sale.getProductName());

                if (productObj == null) {

                    productObj = new Product();
                    productObj.register(sale.getProductName(), sale.getPrice(), sale.getQuantitySold());
                    this.products.putIfAbsent(sale.getProductName(), productObj);
                } else {
                    productObj.register(sale.getProductName(), sale.getPrice(), sale.getQuantitySold());
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }


    // General Statistics
    public void showAllIncome() {
        double total = 0;
        for(Sale sale : sales) {
            total += sale.getTotalPrice();
        }
        System.out.println("------------------------");
        System.out.print("Total Income: R$ ");
        System.out.println(total);
        System.out.println();
    }

    public void showAllSold() {
        int total = 0;
        for(Sale sale : sales) {
            total += sale.getQuantitySold();
        }
        System.out.println("------------------------");
        System.out.print("Total Income: ");
        System.out.println(total);
        System.out.println();
    }
    public void showMeanSalePrice() {
        double totalPrice = 0;
        for (Sale sale : sales) {
            totalPrice += sale.getTotalPrice();
        }
        System.out.println("------------------------");
        System.out.print("Total Income: R$ ");
        System.out.println(totalPrice / sales.size());
        System.out.println();
    }

    // Sale Methods
    public List<Sale> getSales(){
        return sales;
    }

    public void showAllSales() {
        for (Sale sale : sales) {
            sale.showData();
        }
    }

    public void showFirstSale() {
        sales.getFirst().showData();
    }

    public void showLastSale() {
        sales.getLast().showData();
    }

    // Client Methods
    public void showClientWithMostExpense() {
        Client clientWithMostExpense = null;
        double mostExpense=0;
        for (Map.Entry<String, Client> clientEntry : this.clients.entrySet()) {
            Client client = clientEntry.getValue();
            if (clientWithMostExpense == null) {
                clientWithMostExpense = client;
                mostExpense = client.getTotalExpenses();
            }
            if (client.getTotalExpenses() > mostExpense) {
                clientWithMostExpense = client;
                mostExpense = client.getTotalExpenses();
            }
        }
        if (clientWithMostExpense != null) {
            clientWithMostExpense.showData();    
        }

    }

    public void showClientWithLeastExpense() {
        Client clientWithLeastExpense = null;
        double leastExpense=0;

        for (Map.Entry<String, Client> clientEntry : this.clients.entrySet()) {
            Client client = clientEntry.getValue();
            if (clientWithLeastExpense == null) {
                clientWithLeastExpense = client;
                leastExpense = client.getTotalExpenses();
            }
            if (client.getTotalExpenses() < leastExpense) {
                clientWithLeastExpense = client;
                leastExpense = client.getTotalExpenses();
            }
        }
        if (clientWithLeastExpense != null) {
            clientWithLeastExpense.showData();
        } else {
            System.out.println("No client found");
        }

    }

    public void showAllClients() {
        for (Map.Entry<String, Client> clientEntry : this.clients.entrySet()) {
            clientEntry.getValue().showData(true, true, true, false);
        }
    }

    // Product Methods

    public void showAllProducts() {
        for (Map.Entry<String, Product> productEntry : products.entrySet()) {
            productEntry.getValue().showData();
        }
    }

    public void showMostSoldProduct() {
        Product mostSoldProduct = null;
        int mostQuantity=0;
        for (Map.Entry<String, Product> productEntry : products.entrySet()) {
            Product product = productEntry.getValue();
            if (product.getQuantitySold() > mostQuantity) {
                mostSoldProduct = product;
                mostQuantity = product.getQuantitySold();
            }
        }
        if (mostSoldProduct != null) {
            mostSoldProduct.showData();
        }
    }

    public void showMostProfitableProduct() {
        Product mostProfitableProduct = null;
        double mostProfit=0;
        for (Map.Entry<String, Product> productEntry : products.entrySet()) {
            Product product = productEntry.getValue();
            if (product.getTotalSold() > mostProfit) {
                mostProfitableProduct = product;
                mostProfit = product.getTotalSold();
            }
        }
        if (mostProfitableProduct != null) {
            mostProfitableProduct.showData();
        }
    }

}

package market;

import utils.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Market {
    // Create a List for all the possible sales;
    private final List<Sale> sales = new ArrayList<>();

    // Create a List for all users;
    private final List<Client> clients = new ArrayList<>();

    // Create a List for all products;
    private final List<Product> products = new ArrayList<>();

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
                // Create a client placeholder object;
                Client clientObj = new Client();
                boolean clientExists = false;

                // Create a product placeholder object;
                Product productObj = new Product();
                boolean productExists = false;

                for (Client client : this.clients) {
                    // Try to find an existing Client, if found this clientObj becomes it, mark that it does not exist;
                    if (client.getName().equals(sale.getClient())) {
                        clientExists = true;
                        clientObj = client;
                        break;
                    }
                }

                for (Product product : this.products) {
                    // Try to find an existing Product, if found this productObj becomes it, mark that it does not exist;
                    if (product.getName().equals(sale.getProductName())) {
                        productExists = true;
                        productObj = product;
                        break;
                    }
                }

                // If the client does not exist, register it, if not just register the sale;
                if (!clientExists) {
                    clientObj.register(sale);
                    this.clients.add(clientObj);
                } else {
                    clientObj.register(sale);
                }

                // If the product does not exist, register it, if not just register the sale;
                if (!productExists) {
                    productObj.register(sale.getProductName(), sale.getPrice(), sale.getQuantitySold());
                    this.products.add(productObj);
                } else {
                    productObj.register(sale.getProductName(), sale.getPrice(), sale.getQuantitySold());
                }

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }


    // General Statistics
    public double getAllIncome() {
        double total = 0;
        for(Sale sale : sales) {
            total += sale.getTotalPrice();
        }
        return total;
    }

    public int getAllSold() {
        int total = 0;
        for(Sale sale : sales) {
            total += sale.getQuantitySold();
        }
        return total;
    }
    public double getMeanSalePrice() {
        double totalPrice = 0;
        for (Sale sale : sales) {
            totalPrice += sale.getTotalPrice();
        }
        return  totalPrice / sales.size();
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

    // Client Methods
    public void showClientWithMostExpense() {
        Client clientWithMostExpense = null;
        double mostExpense=0;
        for (Client client : this.clients) {
            if (client.getTotalExpenses() > mostExpense) {
                clientWithMostExpense = client;
                mostExpense = client.getTotalExpenses();
            }
        }
        if (clientWithMostExpense != null) {
            clientWithMostExpense.showData();    
        }

    }

    public void showAllClients() {
        for (Client client : this.clients) {
            client.showData();
        }
    }

    // Product Methods

    public void showAllProducts() {
        for (Product product : products) {
            product.showData();
        }
    }

    public void showMostSoldProduct() {
        Product mostSoldProduct = null;
        int mostQuantity=0;
        for (Product product : products) {
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
        for (Product product : products) {
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

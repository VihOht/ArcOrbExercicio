package market;

public class Sale {
    private int saleCode;
    private String client;
    private String product;
    private int quantity;
    private double price;
    private String data;

    public void registerSale(String[] saleData){
        this.saleCode = Integer.parseInt(saleData[0]);
        this.client = saleData[1];
        this.product = saleData[2];
        this.quantity = Integer.parseInt(saleData[3]);
        this.price = Double.parseDouble(saleData[4]);
        this.data = saleData[5];
    }

    public void showData() {
        System.out.println("------------------------");
        System.out.print("Product name: ");
        System.out.println(product);
        System.out.print("Client name: ");
        System.out.println(client);
        System.out.print("Product quantity: ");
        System.out.println(quantity);
        System.out.print("Product Price: R$ ");
        System.out.println(price);
        System.out.print("Data: ");
        System.out.println(data);
        System.out.println();
    }

    public void showData(boolean withProductName, boolean withClientName, boolean withProductQuantity, boolean withProductPrice, boolean withData) {
        System.out.println("------------------------");
        if (withProductName) {
            System.out.print("Product name: ");
            System.out.println(product);
        }
        if (withClientName) {
            System.out.print("Client name: ");
            System.out.println(client);
        }
        if (withProductQuantity) {
            System.out.print("Product quantity: ");
            System.out.println(quantity);
        }
        if (withProductPrice) {
            System.out.print("Product Price: R$ ");
            System.out.println(price);
        }
        if (withData) {
            System.out.print("Data: ");
            System.out.println(data);
        }
        System.out.println();
    }

    public double getTotalPrice() {
        return this.quantity * this.price;
    }

    public double getPrice() {
        return this.price;
    }

    public String getProductName() {
        return this.product;
    }

    public int getQuantitySold() {
        return this.quantity;
    }

    public String getClient() {
        return client;
    }
}

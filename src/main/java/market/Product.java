package market;

public class Product {
    private String name;
    private double averagePrice;
    private int quantitySold;

    public void register(String name, double price, int quantitySold) {
        this.name = name;
        if (averagePrice == 0) {
            this.averagePrice = price;
        } else {
            // Gets the mean price value in case the same product is sold with different prices;
            this.averagePrice = ((this.averagePrice * this.quantitySold) + (price * quantitySold)) / (this.quantitySold + quantitySold);
        }
        this.quantitySold += quantitySold;
    }

    public void showData() {
        System.out.println("------------------------");
        System.out.print("Product Name: ");
        System.out.println(name);
        System.out.print("Avarage Price: R$ ");
        System.out.println(averagePrice);
        System.out.print("Quantity Sold: ");
        System.out.println(quantitySold);
        System.out.print("Total Profity: R$ ");
        System.out.println(quantitySold * averagePrice);
        System.out.println();
    }

    public String getName() {
        return name;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public double getTotalSold() {
        return this.averagePrice * this.quantitySold;
    }

}

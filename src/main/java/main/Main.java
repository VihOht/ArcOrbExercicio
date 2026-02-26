package main;

import utils.FileManager;
import market.Market;

public class Main {

    static void main(String[] args) {
        // TESTING
        Market market = new Market();
        market.registerSales(FileManager.VENDAS1);

        InputManager inputManager = new InputManager(market);
        inputManager.initInteraction();

    }
}

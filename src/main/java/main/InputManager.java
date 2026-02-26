package main;

import market.Client;
import market.Market;
import market.Sale;
import utils.TimeManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    private Market market;
    private List<String[]> logs = new ArrayList<>();
    private Scanner scanner;
    private String state = "0";
    private String response = "";
    private String promptMessage = INITIAL_PROMPT;
    private String priorPrompt = INITIAL_PROMPT;
    private boolean exit = false;

    private static String INITIAL_PROMPT = """
            Welcome to your market manage
            What scope would you like to see?
            0: Exit
            1: Sales
            2: Clients
            3: Products
            4: Overall Statistics
            5: Logs""";

    private static String LOGS_PROMPT = """
            What logs would you like to see?
            0: Go Back
            1: First Log
            2: Last Log
            3: All Logs""";

    private static String SALES_PROMPT = """
            What operation would you like to do?
            0: Go Back
            1: See last sale
            2: See first sale
            3: See all sales
            """;

    private static String CLIENT_PROMPT = """
            0: Go Back
            1: See Client with most expenses
            2: See Client with least expenses
            3: See All Clients
            """;

    private static String PRODUCT_PROMPT = """
            0: Go Back
            1: See most sold Product
            2: See most profitable Product
            3: See All Products
            """;

    private static String GENERAL_PROMPT = """
            0: Go Back
            1: See all income
            2: See total items sold
            3: See average sale price
            """;

    public InputManager(Market market) {
           this.market = market;
           this.scanner = new Scanner(System.in);
    }

    private void getResponse() {
        this.response = this.scanner.next();
        String timeStamp = TimeManager.getCurrentTime();
        if (timeStamp != null) {
            String[] log = new String[]{timeStamp, "Prompt Message:", this.promptMessage, "Response:", this.response};
            this.logs.add(log);
        }
    }



    private void decisionLoop() {
        while (!this.exit) {
            System.out.println(this.promptMessage);
            System.out.print(": ");
            this.getResponse();
            this.update();
        }
    }

    private void changeState() {
        System.out.println("STATE: " + this.state);
        switch (this.state) {
            case "0":
                switch (this.response) {
                    case "0":
                        this.state = "00";
                        break;
                    case "1":
                        this.state = "1";
                        break;
                    case "2":
                        this.state = "2";
                        break;
                    case "3":
                        this.state = "3";
                        break;
                    case "4":
                        this.state = "4";
                        break;
                    case "5":
                        this.state = "5";
                        break;
                }
                break;
            case "1":
                switch (this.response) {
                    case "0":
                        this.state = "0";
                        break;
                    case "1":
                        this.state = "11";
                        break;
                    case "2":
                        this.state = "12";
                        break;
                    case "3":
                        this.state = "13";
                        break;
                }
                break;
            case "2":
                switch (this.response) {
                    case "0":
                        this.state = "0";
                        break;
                    case "1":
                        this.state = "21";
                        break;
                    case "2":
                        this.state = "22";
                        break;
                    case "3":
                        this.state = "23";
                        break;
                }
                break;
            case "3":
                switch (this.response) {
                    case "0":
                        this.state = "0";
                        break;
                    case "1":
                        this.state = "31";
                        break;
                    case "2":
                        this.state = "32";
                        break;
                    case "3":
                        this.state = "33";
                        break;
                }
                break;
            case "4":
                switch (this.response) {
                    case "0":
                        this.state = "0";
                        break;
                    case "1":
                        this.state = "41";
                        break;
                    case "2":
                        this.state = "42";
                        break;
                    case "3":
                        this.state = "43";
                        break;
                }
                break;
            case "5":
                switch (this.response) {
                    case "0":
                        this.state = "0";
                        break;
                    case "1":
                        this.state = "51";
                        break;
                    case "2":
                        this.state = "52";
                        break;
                    case "3":
                        this.state = "53";
                        break;
                }
                break;
        }

    }

    private void update() {
        this.changeState();
        switch (this.state) {
            case "0":
                this.changePrompt(INITIAL_PROMPT);
                break;
            case "00":
                this.exit = true;
                break;
            case "1":
                this.changePrompt(SALES_PROMPT);
                break;
            case "11":
                market.showLastSale();
                this.state = "1";
                break;
            case "12":
                market.showFirstSale();
                this.state = "1";
                break;
            case "13":
                market.showAllSales();
                this.state = "1";
                break;
            case "2":
                this.changePrompt(CLIENT_PROMPT);
                break;
            case "21":
                this.market.showClientWithMostExpense();
                this.state = "2";
                break;
            case "22":
                this.market.showClientWithLeastExpense();
                this.state = "2";
                break;
            case "23":
                this.market.showAllClients();
                this.state = "2";
                break;
            case "3":
                this.changePrompt(PRODUCT_PROMPT);
                break;
            case "31":
                this.market.showMostSoldProduct();
                this.state = "3";
                break;
            case "32":
                this.market.showMostProfitableProduct();
                this.state = "3";
                break;
            case "33":
                this.market.showAllProducts();
                this.state = "3";
                break;
            case "4":
                this.changePrompt(GENERAL_PROMPT);
                break;
            case "41":
                this.market.showAllIncome();
                this.state = "4";
                break;
            case "42":
                this.market.showAllSold();
                this.state = "4";
                break;
            case "43":
                this.market.showMeanSalePrice();
                this.state = "4";
                break;
            case "5":
                this.changePrompt(LOGS_PROMPT);
                break;
            case "51":
                this.seeLog(1);
                this.state = "5";
                break;
            case "52":
                this.seeLog(2);
                this.state = "5";
                break;
            case "53":
                this.seeLog(3);
                this.state = "5";
                break;
        }
    }

    public void initInteraction() {
        decisionLoop();
    }

    private void changePrompt(String prompt) {
        this.priorPrompt = this.promptMessage;
        this.promptMessage = prompt;
    }

    private void seeLog(int option) {
        if (option == 1) {
            String[] texts = logs.getFirst();
            for(String text : texts){
                System.out.println(text);
            }
            System.out.println();
        }
        if (option == 2) {
            String[] texts = logs.getLast();
            for(String text : texts){
                System.out.println(text);
            }
            System.out.println();
        }
        if (option == 3) {
            for (String[] texts : logs) {
                for(String text : texts){
                    System.out.println(text);
                }
                System.out.println();
            }
        }
    }
}

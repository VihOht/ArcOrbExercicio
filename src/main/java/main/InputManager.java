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
    private String priorState = this.state;
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

    private void setState(String state) {
        this.priorState = this.state;
        this.state = state;
    }

    private void switchState() {
        String state = this.state;
        this.state = this.priorState;
        this.priorState = state;
    }

    private void changeState() {
        switch (this.state) {
            case "0":
                switch (this.response) {
                    case "0":
                        this.setState("00");
                        break;
                    case "1":
                        this.setState("1");
                        break;
                    case "2":
                        this.setState("2");
                        break;
                    case "3":
                        this.setState("3");
                        break;
                    case "4":
                        this.setState("4");
                        break;
                    case "5":
                        this.setState("5");
                        break;
                    case "40028922":
                        this.setState("40028922");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            case "1":
                switch (this.response) {
                    case "0":
                        this.setState("0");
                        break;
                    case "1":
                        this.setState("11");
                        break;
                    case "2":
                        this.setState("12");
                        break;
                    case "3":
                        this.setState("13");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            case "2":
                switch (this.response) {
                    case "0":
                        this.setState("0");
                        break;
                    case "1":
                        this.setState("21");
                        break;
                    case "2":
                        this.setState("22");
                        break;
                    case "3":
                        this.setState("23");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            case "3":
                switch (this.response) {
                    case "0":
                        this.setState("0");
                        break;
                    case "1":
                        this.setState("31");
                        break;
                    case "2":
                        this.setState("32");
                        break;
                    case "3":
                        this.setState("33");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            case "4":
                switch (this.response) {
                    case "0":
                        this.setState("0");
                        break;
                    case "1":
                        this.setState("41");
                        break;
                    case "2":
                        this.setState("42");
                        break;
                    case "3":
                        this.setState("43");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            case "5":
                switch (this.response) {
                    case "0":
                        this.setState("0");
                        break;
                    case "1":
                        this.setState("51");
                        break;
                    case "2":
                        this.setState("52");
                        break;
                    case "3":
                        this.setState("53");
                        break;
                    default:
                        this.setState("404");
                        break;
                }
                break;
            default:
                this.setState("404");
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
                this.switchState();
                break;
            case "12":
                market.showFirstSale();
                this.switchState();
                break;
            case "13":
                market.showAllSales();
                this.switchState();
                break;
            case "2":
                this.changePrompt(CLIENT_PROMPT);
                break;
            case "21":
                this.market.showClientWithMostExpense();
                this.switchState();
                break;
            case "22":
                this.market.showClientWithLeastExpense();
                this.switchState();
                break;
            case "23":
                this.market.showAllClients();
                this.switchState();
                break;
            case "3":
                this.changePrompt(PRODUCT_PROMPT);
                break;
            case "31":
                this.market.showMostSoldProduct();
                this.switchState();
                break;
            case "32":
                this.market.showMostProfitableProduct();
                this.switchState();
                break;
            case "33":
                this.market.showAllProducts();
                this.switchState();
                break;
            case "4":
                this.changePrompt(GENERAL_PROMPT);
                break;
            case "41":
                this.market.showAllIncome();
                this.switchState();
                break;
            case "42":
                this.market.showAllSold();
                this.switchState();
                break;
            case "43":
                this.market.showMeanSalePrice();
                this.switchState();
                break;
            case "5":
                this.changePrompt(LOGS_PROMPT);
                break;
            case "51":
                this.seeLog(1);
                this.switchState();
                break;
            case "52":
                this.seeLog(2);
                this.switchState();
                break;
            case "53":
                this.seeLog(3);
                this.switchState();
                break;
            case "40028922":
                System.out.println("MEME: É o bonde do yuri que vai dar playstation 2\n");
                break;
            case "404":
                System.out.println("Option Not Found 404;\nPlease select the *Number* of your operation.\n");
                switchState();
                break;
        }
    }

    public void initInteraction() {
        decisionLoop();
    }

    private void changePrompt(String prompt) {
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

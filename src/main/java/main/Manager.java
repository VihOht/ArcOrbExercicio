package main;

import market.Market;
import utils.TimeManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Manager {
    private Market market;
    private HashMap<String, String> logs = new HashMap<>();
    private Scanner scanner;
    private String response = "";

    public Manager(Market market) {
           this.market = market;
           this.scanner = new Scanner(System.in);
    }

    private void getResponse() {
        this.response = this.scanner.next();
        String timeStamp = TimeManager.getCurrentTime();
        if (timeStamp != null) {
            this.logs.putIfAbsent(timeStamp, this.response);
        }
    }

    private void decisionLoop() {
        while (!this.response.equals("Exit")) {
            System.out.println("What do you want to do?");
            System.out.print(": ");
            if (this.response.equals("Ping")) {
                System.out.println("Pong");
            }
            if (this.response.equals("Log")) {
            }
            getResponse();
        }
    }

    public void initInteraction() {
        decisionLoop();
    }
}

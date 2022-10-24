package com.tako;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.tako.items.Item;
import com.tako.player.Player;



// encapsulation カプセル化　setter getter 
class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Item SHIELD = new Item("Shield", 20, 0, 2);
    private static Item IRON_DAGGER =  new Item("Iron Dagger", 30, 4, 0);
    private static Item RUSTY_IRON_DAGGER = new Item("Rusty Iron Dagger", 20, 3, 0);
    private static Item RUSTY_IRON_WAR_AXE =  new Item("Rusty Iron War Axe",30, 5, 0);
    private static Item IRON_BOW =  new Item("Iron Bow", 20, 4, 0);
    private static Item STEEL_BOW = new Item("Steel Bow", 25, 5, 0);
    private static Item HELMET =   new Item("Helmet", 10, 0, 1);

    private static Item[] items = {
        SHIELD,
        IRON_DAGGER,
        RUSTY_IRON_DAGGER,
        RUSTY_IRON_WAR_AXE,
        IRON_BOW,
        STEEL_BOW,
        HELMET      
    };
    public static void main(String[] args) throws Exception {
        // System.out.println("Player 1, what is your name?");
        // Player p1 = new Player(br.readLine());

        // System.out.println("Player 2, what is your name?");
        // Player p2 = new Player(br.readLine());
        Player p1 = new Player("Erik", 100, false);
        Player p2 = new Player("Natsuhop", 100, false);

        buyItems(p1);
        buyItems(p2);

        // Fight!
        while (true) {
            // P1 attacks
            int attack = p1.attack();
            int damage = p2.takeDamage(attack);

            if (attack == 0) {
                System.out.println( "Oops!..." + p1.getName() + " misses!");
            } else {
                System.out.println(p1.getName() + " hits " + p2.getName() + " for " + attack + ". " + p2.getName() + " takes " + damage + " damage and has " + p2.getHp() + " HP left");
            }

           
            // P2 attacks
            attack = p2.attack();
            damage = p1.takeDamage(attack);

            if (attack == 0) {
                System.out.println( "Oops!..." + p2.getName() + " misses!");
            } else {
                System.out.println(p2.getName() + " hits " + p1.getName() + " for " + attack + ". " + p1.getName() + " takes " + damage + " damage and has " + p1.getHp() + " HP left");
            }

            if (p1.getHp() <= 0 && p2.getHp() <= 0) {
                System.out.println("Tie!");
                break;
            } else if (p1.getHp() <= 0) {
                System.out.println(p2.getName() + " wins!");
                break;
            } else if (p2.getHp() <= 0) {
                System.out.println(p1.getName() + " wins!");
                break;
            }  else if (p1.getHp() <= 10 && p1.getApple() == false) {
                System.out.println(p1.getName() + " Do you eat a apple? ");
                String answer = br.readLine(); 
                if (answer.equals("y")) {
                    p1.recoverHP();
                    p1.haveApple();
                }
            } else if (p2.getHp() <= 10 && p2.getApple() == false) {
                System.out.println(p2.getName() +  " Do you eat a apple? ");
                String answer = br.readLine();
                if (answer.equals("y")) {
                    p2.recoverHP();
                    p2.haveApple();
                }
            }

        }
    }

    private static void buyItems(Player player) throws Exception {
        while (true) {
            System.out.println(player.getName() + ", What do you want to buy?");
            for (int i = 0; i < items.length; i++) {
                if (player.getMoney() >= items[i].getCost()) {
                    System.out.println((i+1) + " - " + items[i].toString());
                }
            }
            System.out.println("0 - Done");
            // player money
            System.out.println("Player's money: " + player.getMoney());
            int answer = Integer.valueOf(br.readLine());
            if (answer == 0) {
                return;
            }
            if (answer >= 2 && answer <= 6 && player.getItems().contains(IRON_DAGGER) || answer >= 2 && answer <= 6 && player.getItems().contains(RUSTY_IRON_DAGGER) ||
                answer >= 2 && answer <= 6 && player.getItems().contains(RUSTY_IRON_WAR_AXE) || answer >= 2 && answer <= 6 && player.getItems().contains(IRON_BOW) ||
                answer >= 2 && answer <= 6 && player.getItems().contains(STEEL_BOW) || answer == 1 && player.getItems().contains(SHIELD) ||  answer == 7 && player.getItems().contains(HELMET)) {
                System.out.println("You can't buy it."); 
            } else {
                player.buyItem(items[answer-1]);
            }
        }
    }
}
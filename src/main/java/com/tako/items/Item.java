package com.tako.items;

// Visibility
// private: only this class can use it
// public: everybody can use it
// <nothing>: "package private", only visible from the same package (folder)

public class Item {
    private String name;
    private int cost;
    private int attack;
    private int armor;

    public Item(String name, int cost, int attack, int armor) {
        this.name = name;
        this.cost = cost;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }


    public String toString() {
        return name + " [" + cost + "g]";
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

}

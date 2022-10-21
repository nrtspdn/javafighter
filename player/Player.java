package player;
import java.util.ArrayList;
import items.Item;

public class Player {
    private String name;
    private ArrayList<Item> items = new ArrayList<>();
    private int money = 100;
    private int attackMin = 1;
    private int attackMax = 3;
    private int hp = 30;

    public Player(String name, int  money) {
        this.name = name;
        this.money = money;
    }

    public int attack() {
        int min = attackMin;
        int max = attackMax;
        for (Item item: items) {
            min += item.getAttack();
            max += item.getAttack();
        }

        if (Math.random() < 0.05) {
            return 0; 
        } else {
            return (int) (Math.random() * (max - min + 1) + min);
        }
        //return (int) (Math.random() * 0); // miss 5/100 == 1/20   attack 95/100 = 19/20

        //return (int) (Math.random() * (max - min + 1) + min); // normal attack     
        
    }

    public void buyItem(Item item) throws Exception {
        if (money < item.getCost()) {
            throw new Exception("Not enough money to buy " + item.getName());
        }
        money -= item.getCost(); // check if we have enough item
        items.add(item);
    }

    public int takeDamage(int damage) {
        int armor = 0;
        for (Item item: items) {
            armor += item.getArmor();
        }

        if (damage > armor) {
            hp -= damage - armor;
            return damage - armor;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getHp() {
        return hp;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}

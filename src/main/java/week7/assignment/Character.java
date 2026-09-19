package week7.assignment;

public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health = Math.max(0, health - amount);
    }

    public void heal(int amount) {
        health = Math.min(maxHealth, health + amount);
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character character = new Character(100);
        character.takeDamage(30);
        System.out.println("Health: " + character.getHealth());
        character.heal(50);
        System.out.println("Health: " + character.getHealth());
        character.takeDamage(150);
        System.out.println("Health: " + character.getHealth());
    }
}

// This class pairs with MarioKart.java
// Player objects simply hold name and lives attributes with a few getter/setter methods

public class Player {
    String name;
    int lives;

    public Player(String name) {
        this.name = name;
        this.lives = 2;
    }

    public String getName() {
        return this.name;
    }

    public void loseLife() {
        this.lives--;
    }
    
    public boolean checkLives() {
        return this.lives > 0;
    }
}

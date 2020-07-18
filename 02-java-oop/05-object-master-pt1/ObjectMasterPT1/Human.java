package ObjectMasterPT1;
public class Human{

    private int strength;
    private int stealth;
    private int intelligence;
    private int health;

    public Human(int strength, int stealth, int intelligence, int health){
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }

    public void setStrength(int str){
        this.strength = str;
    }

    public int getStrength(){
        return this.strength;
    }

    public void setStealth(int stlth){
        this.stealth = stlth;
    }

    public int getStealth(){
        return this.stealth;
    }

    public void setIntellegence(int intel){
        this.intelligence = intel;
    }

    public int getIntellegence(){
        return this.intelligence;
    }

    public void setHealth(int hp){
        this.health = hp;
    }

    public int getHealth(){
        return this.health;
    }

    public int attack(Human player){
        player.health -= this.strength;
        System.out.println("Current Health: " + player.health);
        return health;
    }

}


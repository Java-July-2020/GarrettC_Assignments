package ObjectMasterPT2;

public class Ninja extends Human {

    public Ninja() {
        super(3,10,3,100);
    }

    public int steal(Human player){
        player.health -= this.stealth;
        this.health += this.stealth;
        System.out.println("Ninja Cast Steal");
        return health;
    }

    public void runAway(){
        this.health -= 10;
        System.out.println("Ninja Ran Away");
    }
    
}
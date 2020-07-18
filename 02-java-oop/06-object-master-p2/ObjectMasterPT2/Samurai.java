package ObjectMasterPT2;

public class Samurai extends Human{

    public static int samuraiCount = 0;

    public Samurai(){
        super(3,3,3,200);
        samuraiCount++;
    }

    public int deathBlow(Human player){
        player.health = 0;
        this.health /= 2;
        System.out.println("Samurai hit Death Blow");
        return health;
    }
    
    public void meditate(){
        this.health = this.health + (this.health/2);
        System.out.println("Samurai Cast Meditate");
    }

    public static int howMany(){
        return samuraiCount;
    }
}
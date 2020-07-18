package ObjectMasterPT2;
public class Wizard extends Human{
    
    public Wizard(){
        super(3,3,8,50);
    }

    public int healHuman(Human player){
        player.health += this.intellegence;
        System.out.println("Wizard Cast Holy Light");
        return health;
    }

    public int fireBall(Human player){
        player.health -= this.intellegence*3;
        System.out.println("Wizard Cast Fireball");
        return health;
    }
}
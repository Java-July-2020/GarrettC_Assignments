package ObjectMasterPT2;

public class HumanTest {
    public static void main(String[] args) {

        Wizard gandalf = new Wizard();
        System.out.println("Gandalfs Current HP: " + gandalf.health);
        System.out.println("Int: " + gandalf.intellegence);

        Ninja ryuHayabusa = new Ninja();
        System.out.println("Ryu Hayabusa Current HP: " + ryuHayabusa.health);
        System.out.println("Stlth: " + ryuHayabusa.stealth);

        Samurai wolf = new Samurai();
        System.out.println("Wolfs Current HP: " + wolf.health);

        gandalf.healHuman(ryuHayabusa);
        System.out.println("Ryu Hayabusa Current HP: " + ryuHayabusa.health);

        gandalf.fireBall(ryuHayabusa);
        System.out.println("Ryu Hayabusa Current HP: " + ryuHayabusa.health);

        ryuHayabusa.steal(wolf);
        System.out.println("Wolfs Current HP: " + wolf.health);
        System.out.println("Ryu Hayabusa Current HP: " + ryuHayabusa.health);

        ryuHayabusa.runAway();
        System.out.println("Ryu Hayabusa Current HP: " + ryuHayabusa.health);

        wolf.deathBlow(gandalf);
        System.out.println("Gandalf Current HP: " + gandalf.health);
        System.out.println("Wolf Current HP: " + wolf.health);

        wolf.meditate();
        System.out.println("Wolf Current HP: " + wolf.health);
        
        Samurai.howMany();
        System.out.println("Current Number of Samurai: " + Samurai.howMany());


    }
    
}
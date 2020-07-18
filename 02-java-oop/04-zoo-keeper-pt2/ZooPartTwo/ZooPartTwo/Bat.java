package ZooPartTwo;

public class Bat extends Mammal {
    
    public Bat(){
        super(300);
    }

    public void fly(){
        System.out.println("Woosh!");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("nom nom nom");
        this.energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("ahhhhhhh crackle crackle");
        this.energyLevel += 100;
    }

    public void currentEnergy(){
        super.displayEnergy(energyLevel);
    }
}
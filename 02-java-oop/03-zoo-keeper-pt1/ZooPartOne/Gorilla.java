package ZooPartOne;

public class Gorilla extends Mammal{

    public Gorilla(){
        super(100);
    }

    public void throwSomething(){
        System.out.println("The Gorilla Threw A Rock");
        this.energyLevel -= 5;
    }

    public void eatBananas(){
        System.out.println("The Gorilla Ate A Banana");
        this.energyLevel += 10;
    }

    public void climb(){
        System.out.println("The Gorilla Climbed A Tree");
        this.energyLevel -= 10;
    }

    public void currentEnergy(){
        super.displayEnergy(energyLevel);
    }
}
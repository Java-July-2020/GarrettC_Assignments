package ZooPartTwo;
public class Mammal {
    protected int energyLevel;

    public Mammal(int energyLevel){
        this.energyLevel = energyLevel;
    }

    public void setEnergy(int engy){
        this.energyLevel = engy;
    }

    public int getEnergy(){
        return this.energyLevel;
    }

    public int displayEnergy(int energy){
        this.energyLevel = energy;
        System.out.println("Current Energy Level: " + energy);
        return energy;
    }  
}
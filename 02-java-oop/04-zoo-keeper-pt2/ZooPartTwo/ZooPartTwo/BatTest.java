package ZooPartTwo;

public class BatTest {
    public static void main(String[] args) {
        Bat draculaBat = new Bat();
        draculaBat.attackTown();
        draculaBat.eatHumans();
        draculaBat.fly();
        draculaBat.attackTown();
        draculaBat.fly();
        draculaBat.attackTown();
        draculaBat.eatHumans();
        draculaBat.currentEnergy();
    }
}
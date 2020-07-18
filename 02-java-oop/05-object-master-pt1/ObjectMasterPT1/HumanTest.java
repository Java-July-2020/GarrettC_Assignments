package ObjectMasterPT1;

public class HumanTest {
    public static void main(String[] args) {
        Human playerOne = new Human(3,3,3,10);

        System.out.println("STR: " + playerOne.getStrength());
        System.out.println("INT: " + playerOne.getIntellegence());
        System.out.println("STLTH: " + playerOne.getStealth());
        System.out.println("HP: " + playerOne.getHealth());

        playerOne.attack(playerOne);
    }
}
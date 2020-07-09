import java.lang.Math;

public class PythagoreanTheorem{
    public static void main(String[] args) {
        // int legA = 10;
        // int legB = 20;
        // System.out.println(Math.hypot(legA, legB));
    }
    public static double calculateHypotenuse(int legA, int legB){
        return Math.sqrt((legA*legA)+(legB*legB));
    }
}
public class FizzBuzz{
    public static void main(String[] args) {
        FizzBuzzTest();
    }

    public static String fizzBuzz(int num) {
    if (num % 5 == 0 && num % 3 == 0)
        return "FizzBuzz";
    if (num % 5 == 0)
        return "Fizz";
    if (num % 3 == 0)
        return "Buzz";
    return Integer.toString(num);
    }

    public static void FizzBuzzTest(){
        for (int i = 0; i < 100; i++){
            String result = fizzBuzz(i);
            String output = String.format("Number: %d :: Result: %s", i, result);
            System.out.println(output);
        }
    }
}
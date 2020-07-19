import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Puzzling{
    public static void main(String[] args) {
        int[] num = {3,5,1,2,7,9,8,13,25,32};
        int sum = getSum(num);
        System.out.println("Sum:"+sum);
        int y = 10;
        System.out.println(greaterThan(num, y));
        String[] arr = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        System.out.println(Arrays.toString(shuffleNames(arr)));
        System.out.println(nameLength(arr));
        System.out.println(alphabet());
        System.out.println(randomArray());
        System.out.println(Arrays.toString(randomArrayTwo()));
        System.out.println(randomString());
        System.out.println(Arrays.toString(randomStringArray()));
    }

    public static int getSum(int[] num){
        int sum = 0;
        for(int i = 0; i < num.length; i++){
            sum += num[i];
        }
        return sum;
    }
    
    public static ArrayList<Integer> greaterThan(int[] num, int y){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++){
            if(num[i] > y)
            arr.add(num[i]);
        }
        return arr;
    }

    public static String[] shuffleNames(String[] names){
        Random rand = new Random();
        // ArrayList<String> arr = new ArrayList<String>();
        for( int i = 0; i < names.length; i++){
            int randomName = rand.nextInt(names.length);
            String temp = names[randomName];
            names[randomName] = names[i];
            names[i] = temp;
        }
        // for(int i = 0; i < names.length; i++){
        //     arr.add(names[i]);
        // }
        return names;
    }

    public static ArrayList<String> nameLength(String[] names){
        ArrayList<String> arr = new ArrayList<String>();
        for(int i = 0; i < names.length; i++){
            if(names[i].length() > 5)
            arr.add(names[i]);
        }
        return arr;
    }
    
    public static String alphabet(){
        String letters = "abcdefghijklmnopqrstuvwxyz";
        String firstLast = "";
        char[] alphabet = letters.toCharArray();
        ArrayList<Character> charList = new ArrayList<Character>();
        for( char ch : alphabet){
            charList.add(ch);
        }
        Collections.shuffle(charList);

        firstLast += charList.get(0);
        firstLast += charList.get(25);
        System.out.println(charList);
        return firstLast;
    }

    public static ArrayList<Integer> randomArray(){
        Random r = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int randomNum;
        for(int i = 0; i < 10; i++) {
            randomNum = 55 + r.nextInt(46);
            arr.add(randomNum);
        }
        return arr;
    }

    public static int[] randomArrayTwo(){
        int[] arr= new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 55 + (int) (Math.random() * 100);
        }

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++){
            if (i == 0 || i == arr.length - 1){
                System.out.println(arr[i]);
            }
        }
        return arr;
    }
    public static String randomString(){
        StringBuilder newString = new StringBuilder(5); 
        String randomWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < 5; i++){
            int index = (int)(randomWord.length() * Math.random());
            newString.append(randomWord.charAt(index));
        }
        String newWord = String.valueOf(newString.toString());
        return newWord;
    }

    public static String[] randomStringArray(){
        String[] newArray = new String[10];
        String randomWord = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < newArray.length; i++){
            StringBuilder newString = new StringBuilder(5);
            for (int j = 0; j < 5; j++){
                int word = (int)(randomWord.length() * Math.random());
                newString.append(randomWord.charAt(word));
            }

            newArray[i] = String.valueOf(newString.toString());
        }
        return newArray;
    }
}
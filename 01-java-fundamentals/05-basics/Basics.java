import java.util.ArrayList;
public class Basics{
    public static void main(String[] args){
        pr1Thru255();
        prOdds();
        int[] num = {1,2,3,4,5,6,7,8};
        int[] nums = {1,5,10,-2};
        int sum = getSum(nums);
        System.out.println("Sum:"+sum);
        iterateArray(num);
        int max = findMax(nums);
        System.out.println("Max:"+max);
        findAverage(nums);
        oddArray();
        int y = 4;
        greaterThanY(num, y);
        System.out.println(squareValue(nums));
        System.out.println(greaterThanY(num, y));
        System.out.println(elimNeg(nums));
        maxMinAverage(nums);
        System.out.println(shiftValues(nums));

    }

    public static void pr1Thru255(){
        for(int i = 0; i <= 255; i++){
            System.out.println(i);
        }
    }

    public static void prOdds(){
        for(int i = 0; i <= 255; i++){
            if(i % 2 != 0){
                System.out.println(i);
            }
        }
    }

    public static int getSum(int[] num){
        int sum = 0;
        for (int i = 0; i < num.length; i++){
            sum += num[i];
        }
        return sum;
    }

    public static void iterateArray(int[] num){
        for (int i = 0; i < num.length; i++){
            System.out.println(num);
        }
        for (int intTemp: num){
            System.out.println(intTemp);
        }
    }

    public static int findMax(int[] nums) {
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > maxValue){
                maxValue = nums[i];
            }
        }
        return maxValue;
    }
    public static double findAverage(int[] num){
        int sum = getSum(num);
        double avg = (double)sum/num.length;
        System.out.println("Average:"+avg);
        return avg;
    }

    public static ArrayList<Integer> oddArray() {
		ArrayList<Integer> num = new ArrayList<Integer>();
		for(int i = 0; i <= 255; i++) {
			if(i % 2 != 0)
				num.add(i);
        }
        System.out.println(num);
		return num;
    }
    public static ArrayList<Integer> greaterThanY(int[] num, int y){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++){
            if(num[i] > y)
            arr.add(num[i]);
        }
        return arr;
    }

    public static ArrayList<Integer> squareValue(int[] nums){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            arr.add(nums[i] * nums[i]);
        }
        return arr;
    }
    
    public static ArrayList<Integer> elimNeg(int[] nums){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0) {
                arr.add(nums[i]);    
            }else if (nums[i] < 0){
                arr.add(0);
                
            }
        }
        return arr;
    }

    public static int findMin(int[] nums) {
        int minValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < minValue){
                minValue = nums[i];
            }
        }
        return minValue;
    }
    public static void maxMinAverage(int[] nums){
        int min = findMin(nums);
        int max = findMax(nums);
        double avg = findAverage(nums);
        System.out.println(String.format("Max: %d, Min: %d, Average: %f", max, min, avg));
    }

    public static ArrayList<Integer> shiftValues(int[] nums){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < nums.length-1; i++){
            arr.add(nums[i+1]);
        }
        arr.add(0);
        return arr;
    }
}
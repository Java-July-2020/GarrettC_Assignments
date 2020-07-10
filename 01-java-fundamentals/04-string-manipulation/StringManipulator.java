public class StringManipulator{

    public static void main(String[] args) {
        trimAndConcatTest();
        getIndexOrNullTest();
        getIndexOrNull2Test();
        conCatSubstringTest();

    }

    public String trimAndConcat(String firstWord, String secondWord){
        firstWord = firstWord.trim();
        secondWord = secondWord.trim();
        return firstWord.concat(secondWord);
    }

    public static void trimAndConcatTest(){
        StringManipulator manipulator = new StringManipulator();
        String str = manipulator.trimAndConcat("Hello", "World");
        System.out.println(str);
    }

    public Integer getIndexOrNull(String str, char letter) {
        if (str.indexOf(letter) >= 0){
            return str.indexOf(letter);
        } else{
            return null;
        }
    }

    public static void getIndexOrNullTest(){

        StringManipulator manipulator = new StringManipulator();
        char letter = 'o';
        Integer a = manipulator.getIndexOrNull("Coding", letter);
        Integer b = manipulator.getIndexOrNull("Hello World", letter);
        Integer c = manipulator.getIndexOrNull("Hi", letter);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public Integer getIndexOrNull2(String str1, String str2){

        if (str1.indexOf(str2) >= 0){
            return str1.indexOf(str2);
        } else{
            return null;
        }
    }
    
    public static void getIndexOrNull2Test(){

        StringManipulator manipulator = new StringManipulator();
        String word = "Hello";
        String subString = "llo";
        String notSubString = "world";
        Integer aa = manipulator.getIndexOrNull2(word, subString);
        Integer bb = manipulator.getIndexOrNull2(word, notSubString);
        System.out.println(aa);
        System.out.println(bb);
    }

    public String concatSubstring(String str3, int d, int e, String str4){
        str3 = str4.substring(d, e);
        return str3.concat(str4);
    }

    public static void conCatSubstringTest(){
        StringManipulator manipulator = new StringManipulator();
        String word = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word);
    }

}
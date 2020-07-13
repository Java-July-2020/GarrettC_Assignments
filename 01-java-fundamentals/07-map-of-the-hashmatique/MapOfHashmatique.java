import java.util.HashMap;
public class MapOfHashmatique{
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Papa's Got A Brand New Bag - James Brown", "Come here sister, Papa's in the swing He ain't too hip, about that new breed babe He ain't no drag Papa's got a brand new bag.....");
        trackList.put("Lets Get It On - Marvin Gaye", "I've been really tryin', baby Tryin' to hold back this feeling for so long And if you feel like I feel, baby Then, c'mon, oh, c'mon...");
        trackList.put("Forget Me Nots - Patricia Rushen", "Read the paper and watch the news Now you got the Blues But you can't let it get to you You just got to move...");
        trackList.put("The Boss - James Brown", "Paid the cost to be the boss Paid the cost to be the boss I paid the cost to be the boss...");
        for(String title : trackList.keySet()){
            String lyrics = trackList.get(title);
            System.out.println(title + " : " + lyrics);
            System.out.println(title);
        }
    }
}
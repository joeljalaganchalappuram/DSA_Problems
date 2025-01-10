package ArrayList;
import java.util.*;
public class majorityelement {
    public static void main(String[] args) {
        //The majority element is the element that appears more than ⌊n / 2⌋ times
        //You may assume that the majority element always exists in the array.
        ArrayList<Integer>list= new ArrayList<>();
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(2);
        int candidate=0;
        int count = 0;
        for(int i = 0;i<list.size();i++){
            if(count == 0){
                candidate = list.get(i);
                count=1;
            }
            else if (candidate == list.get(i)) {
                count++;
            } else {
                count--;
            }
        }   
        // Majority verification phase
        count = 0;
        for (int num : list) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > list.size() / 2) {
            System.out.println("The majority element is " + candidate);
        } else {
            System.out.println("There is no majority element");
        }
    }
}
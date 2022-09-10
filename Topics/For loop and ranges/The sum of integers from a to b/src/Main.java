import java.util.ArrayList;
import java.lang.Integer;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            nums.add(i);
        }
        System.out.println(nums.get(5));
    }
}
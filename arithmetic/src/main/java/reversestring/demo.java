package reversestring;

/**
 * Created by hechao on 2017/6/5.
 */
public class demo {

    public static void main(String[] args) {
        String message = "abcdefg";
        StringBuilder rev = new StringBuilder();
        for (int i = message.length() - 1; i >= 0; i--) {
            rev.append(message.charAt(i));
        }
        System.out.println(rev.toString());
    }
}

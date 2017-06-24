package mod;

/**
 * Created by hechao on 2017/6/9.
 */
public class mod {
    public static void main(String[] args) {
        int lengthMod = 1 << 4;

        int result = 50 % lengthMod;
        int result1 = 50 & (lengthMod - 1);

        System.out.println(result);
        System.out.println(result1);
    }
}

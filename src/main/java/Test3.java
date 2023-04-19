import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        String[] strList = str.split("\\s+");

        System.out.println(String.join("%20",strList));

    }
}

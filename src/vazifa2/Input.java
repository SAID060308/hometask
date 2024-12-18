package vazifa2;

import java.util.Scanner;

public interface Input {
    static int Int(String msg){
        System.out.print(msg);
        return new Scanner(System.in).nextInt();
    }
    static String Str(String msg){
        System.out.print(msg);
        return new Scanner(System.in).nextLine();
    }
}

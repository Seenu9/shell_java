import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            
            if (input.equals("exit 0")) {
                break;
            } 
            System.out.println(input + ": command not found");

            if (input.startsWith("echo ")) {
                System.out.println(input.substring(5));
            } else {
                System.out.println(input + ": command not found");
            }
        }
    }
}

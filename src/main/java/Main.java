// Uncomment this block to pass the first stage
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Uncomment this block to pass the first stage
        System.out.print("$ ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(input+": command not found");

        do{   
        System.out.print("$ "); 
        input= scanner.nextLine();

        if(input.equals("exit 0")){
            break;
        }
        else if(input.startsWith("echo")){
            System.out.println(input.substring("echo".length()));
        }
        System.out.println(input+": command not found");  
       
       
        
        }
        while(true);
    }
}

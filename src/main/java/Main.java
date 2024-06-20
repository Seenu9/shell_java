import java.util.Scanner;
import java.util.Set;
public class Main {
  public static void main(String[] args) throws Exception {
    // System.out.println("Logs from your program will appear here!");
    Set<String> commands =Set.of("exit","type","echo");
    while (true) {
      System.out.print("$ ");
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      if (input.equals("exit 0")) {
        break;
      }
      else if (input.startsWith("echo ")) {
        System.out.println(input.substring(5));
      } 
      else if(input.startsWith("type ")){
        String term=input.substring(5).trim();
        if(commands.contains(term)){
          System.out.println(term+" is a shell builtin");
        }else{
          System.out.println(term+": not found");
        }
               
      }
      else {
        System.out.println(input + ": command not found");
      }



    }
  }
}
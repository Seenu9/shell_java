import java.io.File;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        Set<String> commands = Set.of("exit", "type", "echo");
        String[] paths = System.getenv("PATH").split(File.pathSeparator);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();

            if (input.equals("exit 0")) {
                break;
            } else if (input.startsWith("echo ")) {
                System.out.println(input.substring(5));
            }        
            else if (input.startsWith("type ")) {
                String term = input.substring(5).trim();
                if (commands.contains(term)) {
                    System.out.println(term + " is a shell builtin");
                } else {
                    boolean fileFound = false;
                    for (String path : paths) {
                        File file = new File(path, term);
                        if (file.exists()) {
                            fileFound = true;
                            System.out.println(term + " is " + file.getAbsolutePath());
                            break;
                        }
                    }
                          if (!fileFound) {
                        System.out.println(term + ": not found");
                    }
                }
            }
            else if(input.equals("pwd")){
                String userDirectory=new File(" ").getAbsolutePath();
                System.out.println(userDirectory);
            }
            else {
               String[] allcommands=input.split("\\s+");
               String command=allcommands[0];
               boolean isbuiltin=commands.contains(command);
               if(!isbuiltin){
                boolean filefound=false;
                for(String path:paths){
                    File file=new File(path,command);
                    if(file.exists()){
                        filefound=true;
                        try{
                            ProcessBuilder pb=new ProcessBuilder(allcommands);
                            pb.inheritIO();
                            Process process=pb.start();
                            process.waitFor();


                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;
                    }
                }
                if(!filefound){
                    System.out.println(command+": not found");
                }
               }else{
                System.out.println(input+": command not found");
               }
            }
        }

    
    }
}

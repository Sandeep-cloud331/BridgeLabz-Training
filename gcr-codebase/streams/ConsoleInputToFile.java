import java.io.*;

public class ConsoleInputToFile {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)));
            FileWriter writer = new FileWriter(data.text){
                System.out.println("Enter name: ");
                String name = reader.readLine();
                System.out.println("Enter age: ");
                int age = reader.readLine();
                System.out.println("Enter any computer language: ");
                String language = reader.readLine();

                writer.write(name + age + language);
                System.out.println("Done!");
            }
            catch(IOException e){
                 System.out.println(e.getMessage());
            }
    }
}


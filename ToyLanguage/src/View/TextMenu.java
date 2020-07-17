package View;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TextMenu {
    private Map<String, Command> commands;

    TextMenu(){
        commands = new HashMap<>();
    }

    void addCommand(Command c){
        commands.put(c.getKey(), c);
    }

    private void printMenu() {
        System.out.println("Menu:\n");
        for(Command c : commands.values()) {
            String line = String.format("%4s : %s", c.getKey(), c.getDescription());
            System.out.println(line);
        }
    }

    void show(){
        Scanner s = new Scanner(System.in);
        while(true){
            printMenu();
            System.out.println("Input the option: ");
            String key = s.nextLine();
            Command c = commands.get(key);
            if(c == null){
                System.out.println("Invalid Option");
                continue;
            }
            c.execute();
        }
    }
}

package Lab_2.j;

import java.util.HashMap;
import java.util.Scanner;

public class Lab_2 {
    public static void main(String[] args) {

        HashMap<String, Mammal> farm = new HashMap<String, Mammal>();
        boolean done = false;
        Scanner s = new Scanner(System.in);
        while (!done) {

            System.out.println("Enter a command - type \"help\" for a list of commands");

            String[] input = s.nextLine().toLowerCase().split("s+");
            String command = input.length > 0 ? input[0] : "";
            String argument_1 = input.length > 1 ? input[1] : "";
            String argument_2 = input.length > 2 ? input[2] : "";

            done = handle_commands(farm, done, command, argument_1, argument_2);

            System.out.println(farm);
        }
        s.close();
    }

    private static boolean handle_commands(HashMap<String, Mammal> farm, boolean done, String command,
            String argument_1, String argument_2) {

        switch (command) {

            case "add":
                add_mammal(farm, argument_1, argument_2);
                break;

            case "speak":
                farm.get(argument_1).speak();
                break;

            case "eat":
                if (farm.get(argument_1).eat(farm.get(argument_2)))
                    farm.remove(argument_2);
                break;

            case "sleep":
                farm.get(argument_1).sleep();
                break;

            case "mate":
                farm.get(argument_1).mate(farm.get(argument_2));
                break;

            case "end":
                System.out.println("Ending");
                done = true;
                break;

            case "help":
                print_help();
                break;

            default:
                System.out.println();
        }

        return done;
    }

    private static void print_help() {
        System.out.println("Commands:");
        System.out.println(">   speak [name]");
        System.out.println(">   sleep [name]");
        System.out.println(">   mate [species] [name]");
        System.out.println(">   eat [species] [name]");
        System.out.println(">   add [species] [name]");
        System.out.println(">   help");
        System.out.println(">   end");
        System.out.println("Species:");
        System.out.println("'   Lion");
        System.out.println("'   Tiger");
        System.out.println("'   Bull");
        System.out.println("'   Wolf");
    }

    private static void add_mammal(HashMap<String, Mammal> farm, String argument_1, String argument_2) {

        Mammal new_mammal;

        switch (argument_1) {

            case "lion":
                new_mammal = new Lion();
                break;

            case "tiger":
                new_mammal = new Tiger();
                break;

            case "bull":
                new_mammal = new Bull();
                break;

            case "wolf":
                new_mammal = new Wolf();
                break;

            default:
                throw new IllegalArgumentException("Unexpected value: " + argument_1);
        }
        if (argument_2 == "")
            throw new IllegalArgumentException("Unexpected value: " + argument_2);

        farm.put(argument_2, new_mammal);

    }
}

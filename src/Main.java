import com.testdome.classes.*;
import com.testdome.classes.misc.IceCream;
import com.testdome.classes.misc.Roots;

import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        //Merge names test
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia

        //RoutePlanner test (uses Breadth First Search)
        System.out.println("\n=================================================================");
        System.out.println("Route planner test");
        System.out.println("\n-----------------------------------------------------------------");
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };
        System.out.println(" ------- Expected outcome: TRUE -------");
        System.out.println(RoutePlanner.routeExists(0, 0, 2, 2, mapMatrix));
        System.out.println(" ------- Expected outcome: FALSE -------");
        System.out.println(RoutePlanner.routeExists(0, 0, 1, 2, mapMatrix));

        //TimeInWords test
        System.out.println("\n=================================================================");
        System.out.println("Time in words test. It should produce the following answers: " +
                            "\nAnswer 1: quarter past five" +
                            "\nAnswer 2: quarter to eight");
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println(TimeInWords.timeInWords(5, 15));
        System.out.println(TimeInWords.timeInWords(7, 45));

        //Chocolate feast test. Expected output 6, 3, 5
        System.out.println("\n=================================================================");
        System.out.println("Chocolate feast test. It should produce the following answers: " +
                "\nAnswer 1: 6" +
                "\nAnswer 2: 3" +
                "\nAnswer 3: 5");
        System.out.println("\n-----------------------------------------------------------------");
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(10, 2, 5));
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(12, 4, 4));
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(6, 2, 2));

        // SortedSearch test
        System.out.println("\n=================================================================");
        System.out.println("SortedSearch equation test. It should produce: 2 as answer");
        System.out.println("\n-----------------------------------------------------------------");
        int[] input = new int[] { 1, 3, 5, 7};
        int lessThenConstraint = 4;
        System.out.println("The answer is: " + SortedSearch.countNumbers(input, lessThenConstraint));

        // Quadratic equation test
        System.out.println("\n=================================================================");
        System.out.println("Quadratic equation test. It should produce: " +
                "\n root#1 = -1" +
                "\n root#2 = -4" +
                "\nor vice versa");
        System.out.println("\n-----------------------------------------------------------------");
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);

        // IceCreamMachine test
        System.out.println("\n=================================================================");
        System.out.println("IceCreamMachine test. Should print: " +
                            "\n vanilla, chocolate sauce " +
                            "\n chocolate, chocolate sauce");
        System.out.println("\n-----------------------------------------------------------------");
        IceCreamMachine machine = new IceCreamMachine(new String[]{    "vanilla", "chocolate"      }, new String[]{  "chocolate sauce"  });
        List<IceCream> scoops = machine.scoops();
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }

        //Decorator stream test. Should print "First line: Hello, world!"
        System.out.println("\n=================================================================");
        System.out.println("Decorator stream test:\n It should print \"First line: Hello, world!\"");
        System.out.println("\n-----------------------------------------------------------------");
        byte[] message = new byte[]{0x48, 0x65, 0x6c, 0x6c, 0x6f, 0x2c, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64, 0x21};
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            DecoratorStream decoratorStream = new DecoratorStream(baos, "First line: ");
            decoratorStream.write(message);

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(baos.toByteArray()), "UTF-8"))) {
                System.out.println(reader.readLine());
            }
        }
    }
}
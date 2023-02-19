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
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true}
        };
        System.out.println(RoutePlanner.routeExists(0, 0, 2, 2, mapMatrix));

        //TimeInWords test
        System.out.println(TimeInWords.timeInWords(5, 15));
        System.out.println(TimeInWords.timeInWords(7, 45));

        //Chocolate feast test. Expected output 6, 3, 5
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(10, 2, 5));
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(12, 4, 4));
        System.out.println(ChocolateFeast.computeNumberOfConsumedChocolates(6, 2, 2));

        // SortedSearch test should return 2 ()
        int[] input = new int[] { 1, 3, 5, 7};
        int lessThenConstraint = 4;
        System.out.println(SortedSearch.countNumbers(input, lessThenConstraint));

        // Quadratic equation test should return -1 and -4
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);

        // IceCreamMachine basic test
        /*
         * Should print:
         * vanilla, chocolate sauce
         * chocolate, chocolate sauce
         */
        IceCreamMachine machine = new IceCreamMachine(new String[]{    "vanilla", "chocolate"      }, new String[]{  "chocolate sauce"  });
        List<IceCream> scoops = machine.scoops();
        for (IceCream iceCream : scoops) {
            System.out.println(iceCream.ingredient + ", " + iceCream.topping);
        }

        //Decorator stream test: //should print "First line: Hello, world!"
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
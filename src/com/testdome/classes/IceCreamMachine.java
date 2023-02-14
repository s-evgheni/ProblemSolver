package com.testdome.classes;

import com.testdome.classes.misc.IceCream;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement the IceCreamMachine's scoops method so that it returns all combinations of one ingredient and one topping. If there are no ingredients or toppings, the method should return an empty list.
 *
 * For example,
 *
 * IceCreamMachine machine = new IceCreamMachine(
 *     new String[]{"vanilla", "chocolate"},
 *     new String[]{"chocolate sauce"}
 * );
 * List<IceCream> scoops = machine.scoops();
 * for (IceCream iceCream : scoops) {
 *     System.out.println(iceCream.ingredient + ", " + iceCream.topping);
 * }
 * should print
 *
 * vanilla, chocolate sauce
 * chocolate, chocolate sauce
 */
public class IceCreamMachine {
    public static String[] ingredients;
    public static String[] toppings;


    public IceCreamMachine(String[] ingredeints, String[] toppings) {
        this.ingredients = ingredeints;
        this.toppings = toppings;
    }

    public static List<IceCream> scoops() {
        List<IceCream> scoops = new ArrayList<>();
        for(String ingredient: ingredients) {
            for (String topping : toppings) {
                IceCream ic = new IceCream(ingredient, topping);
                scoops.add(ic);
            }
        }
        return scoops;
    }
}
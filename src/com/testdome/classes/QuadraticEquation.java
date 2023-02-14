package com.testdome.classes;
import com.testdome.classes.misc.Roots;
/**
    Implement the function findRoots to find the roots of the quadratic equation: ax2 + bx + c = 0. (Here, a, b, and c are real numbers and a can't be equal to 0)
    The function should return a Roots object containing roots in any order.
    If the equation has only one solution, the function should return that solution as both elements of the Roots.
    The equation will always have at least one solution.
    The roots of the quadratic equation can be found with the following formula: x = (-b ± √(b2-4ac)) / (2a)

    For example, findRoots(2, 10, 8) should return a Roots object where either
    x1 = -1, x2 = -4 or
    x1 = -4, x2 = -1
    as the roots of the equation 2x^2 + 10x + 8 = 0 are -1 and -4.
*/
public class QuadraticEquation {
        public static Roots findRoots(double a, double b, double c) {
            // value a, b, and c
            double root1, root2;

            // calculate the determinant (b2 - 4ac)
            double determinant = b * b - 4 * a * c;

            // check if determinant is greater than 0
            if (determinant > 0) {
                // two real and distinct roots
                root1 = (-b + Math.sqrt(determinant)) / (2 * a);
                root2 = (-b - Math.sqrt(determinant)) / (2 * a);

                System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
                return new Roots(root1, root2);
            }

            // check if determinant is equal to 0
            else if (determinant == 0) {

                // two real and equal roots
                // determinant is equal to 0
                // so -b + 0 == -b
                root1 = root2 = -b / (2 * a);
                System.out.format("root1 = root2 = %.2f;", root1);
                return new Roots(root1, root1);
            }

            // if determinant is less than zero
            else {
                // roots are complex number and distinct
                double real = -b / (2 * a);
                double imaginary = Math.sqrt(-determinant) / (2 * a);
                System.out.format("root1 = %.2f+%.2fi", real, imaginary);
                System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
                return new Roots(real+imaginary, real-imaginary);
            }
        }
}
package com.jindjeet.calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
            String operation = args[0];
            double num1 = 0, num2 = 0;
            if (!operation.equals("factorial")) {
                if (args.length < 3) {
                    System.out.println("Error: Insufficient arguments for the operation.");
                    return;
                }
                num1 = Double.parseDouble(args[1]);
                num2 = Double.parseDouble(args[2]);
            } else {
                if (args.length < 2) {
                    System.out.println("Error: Insufficient arguments for the operation.");
                    return;
                }
                num1 = Double.parseDouble(args[1]);
            }

            double result = 0;
            boolean validOperation = true;

            switch (operation.toLowerCase()) {
                case "add":
                    result = add(num1, num2);
                    break;
                case "subtract":
                    result = subtract(num1, num2);
                    break;
                case "multiply":
                    result = multiply(num1, num2);
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = divide(num1, num2);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                case "factorial":
                    if (num1 >= 0) {
                        result = factorial((int) num1);
                    } else {
                        System.out.println("Error: Factorial of a negative number is not defined.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operation.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();

            double num1 = 0, num2 = 0;
            if (!operation.equals("factorial")) {
                System.out.print("Enter first number: ");
                num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            } else {
                System.out.print("Enter a number: ");
                num1 = scanner.nextDouble();
            }

            double result = 0;
            boolean validOperation = true;

            switch (operation.toLowerCase()) {
                case "add":
                    result = add(num1, num2);
                    break;
                case "subtract":
                    result = subtract(num1, num2);
                    break;
                case "multiply":
                    result = multiply(num1, num2);
                    break;
                case "divide":
                    if (num2 != 0) {
                        result = divide(num1, num2);
                    } else {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                    }
                    break;
                case "factorial":
                    if (num1 >= 0) {
                        result = factorial((int) num1);
                    } else {
                        System.out.println("Error: Factorial of a negative number is not defined.");
                        validOperation = false;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operation.");
                    validOperation = false;
            }

            if (validOperation) {
                System.out.println("Result: " + result);
            }

            scanner.close();
        }
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
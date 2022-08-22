package com.epam.training.fooddelivery.view;

import com.epam.training.fooddelivery.repository.CustomerRepository;
import com.epam.training.fooddelivery.domain.*;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
@Component
public class CLIView implements View {
    private static final Scanner scanner = new Scanner(System.in);

    private CustomerRepository customerRepository;

    public CLIView(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public User readCredentials() {
        System.out.print("Enter customer address: ");
        String email = scanner.nextLine();
        System.out.print("Enter customer password: ");
        String password  = scanner.nextLine();

        return new User(email, password);
    }

    @Override
    public void printWelcomeMessage(Customer customer) {
        System.out.println("\nWelcome, " + customer.getName() + ". Your balance is: " + customer.getBalance() + " EUR.");
    }

    @Override
    public void printAllFoods(List<Food> foods) {
        System.out.println("\nThese are our goods today:");
        for(Food food : foods) {
            System.out.println(" - " + food.getName() + " " + food.getPrice() + " EUR each");
        }
    }

    @Override
    public Food selectFood(List<Food> foods) {

        while(true) {
            System.out.print("\nPlease enter the name of the food you would like to buy or delete from the cart: ");

            String foodName = scanner.nextLine();

            for (Food food : foods) {
                if (food.getName().equals(foodName)) {
                    return food;
                }
            }

            System.out.println("Food don't recognized");
        }
    }

    @Override
    public int readPieces() {
        int pieces;
        while(true) {
            System.out.print("How many pieces do you want to buy? " +
                    "This input overwrites the old value in the cart, " +
                    "entering zero removes the item completely: ");

            try {
                pieces = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Input should contain only numbers");
            }
            scanner.nextLine();
        }
        scanner.nextLine();
        return pieces;
    }

    @Override
    public void printAddedToCart(Food food, int pieces) {
        System.out.println("Added " + pieces + " piece(s) of " + food.getName() + " to the cart.\n");
    }

    @Override
    public void printCart(Cart cart) {
        System.out.println("The cart has " + cart.getPrice() + " EUR of foods:");
        for(OrderItem item : cart.getOrderItems()) {
            System.out.println(item.getFood().getName() + " " +
                    item.getPieces() + " piece(s), " +
                    item.getPrice() + " EUR total");
        }
    }

    @Override
    public void printConfirmOrder(Order order) {
        System.out.println("\nOrder (items: [" + order.printOrderedItems() + "], price " + order.getPrice() + " EUR, timestamp: " + order.getTimestampCreatedFormat() + ") has been confirmed. " +
                "Thank you your purchase.");
    }

    @Override
    public boolean promptOrder() {
        return false;
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public boolean readDecision() {
        String decision;
        while(true) {

            decision = scanner.nextLine().strip();

            if (decision.equals("n"))
                return true;
            else if (decision.equals("y")) {
                return false;
            } else {
                System.out.println("Wrong input!");
                System.out.print("\nAre you finished with your order? (y/n): ");
            }
        }
    }
}

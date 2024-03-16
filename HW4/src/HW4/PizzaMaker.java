package HW4;

import java.util.ArrayList;
import java.util.List;

public class PizzaMaker {
	private String pizzaChain;
    private String size;
    private List<String> toppings;

    public PizzaMaker(String chainName, String size) {
        this.pizzaChain = chainName;
        this.size = size;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public void eat() {
        System.out.println("\nOrdered from: " + pizzaChain + "\nThe size of the pizza:" + size + "\nAdded Toppings" + String.join(",\n", toppings));
    }
}

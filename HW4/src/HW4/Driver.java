package HW4;

public class Driver {
	public static void main(String[] args) {
		
		System.out.println("Three Pizza Chains:\n    Pizza Hut\n    Domino's\n    Little Caesars\nList of possible toppings:\n    Pepperoni\n    Sausage\n    Mushrooms\n    Bacon\n    Onions\n    Extra Cheese\n    Peppers\n    Chicken\n    Olives\n    Spinach\n    Tomato and Basil\n    Beef");
		
		
		PizzaMaker largePizzaHut = new PizzaBuilder("Pizza Hut", "Large")
                .addTopping("Pepperoni")
                .addTopping("Mushrooms")
                .addTopping("Onions")
                .build();
		
		PizzaMaker smallPizzaHut = new PizzaBuilder("Pizza Hut", "Small")
                .addTopping("Sausage")
                .addTopping("Ham")
                .build();
		
		
		PizzaMaker smallDominos = new PizzaBuilder("Domino's", "Small")
                .addTopping("Peppers")
                .build();
        PizzaMaker largeDominos = new PizzaBuilder("Domino's", "Large")
                .addTopping("Ham")
                .addTopping("Mushrooms")
                .addTopping("Extra Cheese")
                .build();
        

        PizzaMaker mediumLittleCaesars = new PizzaBuilder("Little Caesars", "Medium")
                .addTopping("Chicken")
                .addTopping("Olives")
                .addTopping("Spinach")
                .addTopping("Tomato and Basil")
                .addTopping("Beef")
                .addTopping("Ham")
                .addTopping("Pesto")
                .addTopping("Spicy Pork")
                .build();
        PizzaMaker smallLittleCaesars = new PizzaBuilder("Little Caesars", "Small")
                .addTopping("Sausage")
                .addTopping("Bacon")
                .addTopping("Ham")
                .addTopping("Mushrooms")
                .addTopping("Extra Cheese")
                .addTopping("Spinach")
                .build();

        largePizzaHut.eat();
        smallPizzaHut.eat();
        mediumLittleCaesars.eat();
        smallLittleCaesars.eat();
        smallDominos.eat();
        largeDominos.eat();

    }
}
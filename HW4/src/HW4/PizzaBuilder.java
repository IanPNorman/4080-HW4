package HW4;

public class PizzaBuilder {
    private PizzaMaker pizza;

    public PizzaBuilder(String chainName, String size) {
        pizza = new PizzaMaker(chainName, size);
    }

    public PizzaBuilder addTopping(String topping) {
        pizza.addTopping(topping);
        return this;
    }

    public PizzaMaker build() {
        return pizza;
    }
}
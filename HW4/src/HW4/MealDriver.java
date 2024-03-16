package HW4;

import java.util.*;

abstract class AbstractFactory {
	 abstract Carbs getCarbs();
	 abstract Protein getProtein();
	 abstract Fats getFats();
	}

abstract class Carbs {}
abstract class Protein {}
abstract class Fats {}

class Cheese extends Carbs {}
class Bread extends Carbs {}
class Lentils extends Carbs {}
class Pistachio extends Carbs {}

class Fish extends Protein {}
class Chicken extends Protein {}
class Beef extends Protein {}
class Tofu extends Protein {}

class Avocado extends Fats {}
class SourCream extends Fats {}
class Tuna extends Fats {}
class Peanuts extends Fats {}


class NoRestrictionFactory extends AbstractFactory {
 private static NoRestrictionFactory instance;
 
 private NoRestrictionFactory() {}

 public static synchronized NoRestrictionFactory getInstance() {
     if (instance == null) {
         instance = new NoRestrictionFactory();
     }
     return instance;
 }

 @Override
 Carbs getCarbs() {
     List<Carbs> options = Arrays.asList(new Cheese(), new Bread(), new Lentils(), new Pistachio());
     return options.get(new Random().nextInt(options.size()));
 }

 @Override
 Protein getProtein() {
     List<Protein> options = Arrays.asList(new Fish(), new Chicken(), new Beef(), new Tofu());
     return options.get(new Random().nextInt(options.size()));
 }

 @Override
 Fats getFats() {
     List<Fats> options = Arrays.asList(new Avocado(), new SourCream(), new Tuna(), new Peanuts());
     return options.get(new Random().nextInt(options.size()));
 }
}

class PaleoFactory extends AbstractFactory {
    private static PaleoFactory instance;

    private PaleoFactory() {}

    public static synchronized PaleoFactory getInstance() {
        if (instance == null) {
            instance = new PaleoFactory();
        }
        return instance;
    }

    @Override
    Carbs getCarbs() {
        return new Pistachio();
    }

    @Override
    Protein getProtein() {
        List<Protein> options = Arrays.asList(new Fish(), new Chicken(), new Beef());
        return options.get(new Random().nextInt(options.size()));
    }

    @Override
    Fats getFats() {
        List<Fats> options = Arrays.asList(new Avocado(), new Tuna());
        return options.get(new Random().nextInt(options.size()));
    }
}

class VeganFactory extends AbstractFactory {
    private static VeganFactory instance;

    private VeganFactory() {}

    public static synchronized VeganFactory getInstance() {
        if (instance == null) {
            instance = new VeganFactory();
        }
        return instance;
    }

    @Override
    Carbs getCarbs() {
        List<Carbs> options = Arrays.asList(new Cheese(), new Bread(), new Lentils(), new Pistachio());
        return options.get(new Random().nextInt(options.size()));
    }

    @Override
    Protein getProtein() {
        return new Tofu();
    }

    @Override
    Fats getFats() {
        List<Fats> options = Arrays.asList(new Avocado(), new Peanuts());
        return options.get(new Random().nextInt(options.size()));
    }
}

class NutAllergyFactory extends AbstractFactory {
    private static NutAllergyFactory instance;

    private NutAllergyFactory() {}

    public static synchronized NutAllergyFactory getInstance() {
        if (instance == null) {
            instance = new NutAllergyFactory();
        }
        return instance;
    }

    @Override
    Carbs getCarbs() {
        List<Carbs> options = Arrays.asList(new Cheese(), new Bread(), new Lentils());
        return options.get(new Random().nextInt(options.size()));
    }

    @Override
    Protein getProtein() {
        List<Protein> options = Arrays.asList(new Fish(), new Chicken(), new Beef(), new Tofu());
        return options.get(new Random().nextInt(options.size()));
    }

    @Override
    Fats getFats() {
        List<Fats> options = Arrays.asList(new Avocado(), new SourCream(), new Tuna());
        return options.get(new Random().nextInt(options.size()));
    }
}


class Customer {
	String name;
	String dietPlan;
 
 	Customer(String name, String dietPlan) {
 		this.name = name;
 		this.dietPlan = dietPlan;
 	}
 
 	void printMeal() {
 			AbstractFactory factory;
 			switch (dietPlan) {
 				case "Paleo":
 					factory = PaleoFactory.getInstance();
 					break;
 				case "Vegan":
 					factory = VeganFactory.getInstance();
 					break;
 				case "Nut Allergy":
 					factory = NutAllergyFactory.getInstance();
 					break;
 				default:
 					factory = NoRestrictionFactory.getInstance();
 			}
	    
 			Carbs carbs = factory.getCarbs();
 			Protein protein = factory.getProtein();
 			Fats fats = factory.getFats();
	    
 			System.out.println(name + "'s Meal: " + carbs.getClass().getSimpleName() + ", " + protein.getClass().getSimpleName() + ", " + fats.getClass().getSimpleName());
 		}
}


 public class MealDriver {
	 public static void main(String[] args) {
		 List<Customer> customers = Arrays.asList(
				 new Customer("Alice", "No Restriction"),
				 new Customer("Bob", "Paleo"),
				 new Customer("John", "Vegan"),
				 new Customer("Edward", "Nut Allergy"),
				 new Customer("Steve", "Paleo"),
				 new Customer("Ella", "No Restriction")
         

				 );
     
		 for (Customer customer : customers) {
			 customer.printMeal();
		 }
	 }
 }


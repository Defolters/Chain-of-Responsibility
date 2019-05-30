import java.util.ArrayList;

public class PizzaMaker extends ServiceChain {
    ArrayList<Cheese> cheeses = new ArrayList<>();
    ArrayList<Sausage> sausages = new ArrayList<>();
    ArrayList<Dough> doughs = new ArrayList<>();


    public PizzaMaker() {
        cheeses.add(new Cheese());
        cheeses.add(new Cheese());
        cheeses.add(new Cheese());
        doughs.add(new Dough());
        doughs.add(new Dough());
        sausages.add(new Sausage());
    }

    @Override
    public Order addItemToOrder(Order order, String orderString) {
        if (orderString.contains("pizza")) {
            try {
                order.addItem(new Pizza(cheeses.remove(0), sausages.remove(0), doughs.remove(0)));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Not enough ingredients");
            }
        }
        return addNextItem(order, orderString);
    }

    private class Cheese {}
    private class Sausage {}
    private class Dough {}

    class Pizza implements Item {

        public Pizza(Cheese cheese, Sausage sausage, Dough dough) {
        }

        @Override
        public String toString() {
            return "Pizza";
        }
    }
}

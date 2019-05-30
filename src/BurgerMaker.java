import java.util.ArrayList;

public class BurgerMaker extends ServiceChain {
    ArrayList<Bread> breads = new ArrayList<>();
    ArrayList<Chop> chops = new ArrayList<>();
    ArrayList<Cabbage> cabbages = new ArrayList<>();
    ArrayList<Sauce> sauces = new ArrayList<>();


    public BurgerMaker() {
        breads.add(new Bread());
        breads.add(new Bread());
        breads.add(new Bread());
        chops.add(new Chop());
        chops.add(new Chop());
        chops.add(new Chop());
        cabbages.add(new Cabbage());
        cabbages.add(new Cabbage());
        cabbages.add(new Cabbage());
        sauces.add(new Sauce());
        sauces.add(new Sauce());
        sauces.add(new Sauce());
    }

    @Override
    public Order addItemToOrder(Order order, String orderString) {
        if (orderString.contains("burger")) {
            try {
                order.addItem(new Burger(breads.remove(0), chops.remove(0), sauces.remove(0), cabbages.remove(0)));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Not enough ingredients");
            }
        }
        return addNextItem(order, orderString);
    }

    private class Bread {}
    private class Chop {}
    private class Sauce {}
    private class Cabbage {}

    class Burger implements Item {

        public Burger(Bread bread, Chop chop, Sauce sauce, Cabbage cabbage) {}

        @Override
        public String toString() {
            return "Burger";
        }
    }
}

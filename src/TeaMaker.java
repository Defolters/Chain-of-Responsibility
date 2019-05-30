import java.util.ArrayList;

public class TeaMaker extends ServiceChain {
    ArrayList<Tea> teas = new ArrayList<>();


    public TeaMaker() {
        teas.add(new Tea());
        teas.add(new Tea());
        teas.add(new Tea());
        teas.add(new Tea());
        teas.add(new Tea());
    }

    @Override
    public Order addItemToOrder(Order order, String orderString) {
        if (orderString.contains("tea")) {
            try {
                order.addItem(teas.remove(0));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Not enough tea");
            }
        }

        return addNextItem(order, orderString);
    }
    private class Tea implements Item{
        @Override
        public String toString() {
            return "Tea";
        }
    }
}

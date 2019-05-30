import java.util.ArrayList;

public class IceCreamMaker extends ServiceChain {
    ArrayList<IceCream> iceCreams = new ArrayList<>();


    public IceCreamMaker() {
        iceCreams.add(new IceCream());
        iceCreams.add(new IceCream());
        iceCreams.add(new IceCream());
        iceCreams.add(new IceCream());
    }

    @Override
    public Order addItemToOrder(Order order, String orderString) {
        if (orderString.contains("ice cream")) {
            try {
                order.addItem(iceCreams.remove(0));
            } catch (IndexOutOfBoundsException ex) {
                System.out.println("Not enough ice creams");
            }
        }
        return addNextItem(order, orderString);
    }

    private class IceCream implements Item{
        @Override
        public String toString() {
            return "IceCream";
        }
    }
}

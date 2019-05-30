public class EndService extends ServiceChain {

    @Override
    public Order addItemToOrder(Order order, String orderString) {
        order.addItem(new Napkin());

        return addNextItem(order, orderString);
    }

    class Napkin implements Item {
        @Override
        public String toString() {
            return "Napkin";
        }
    }
}

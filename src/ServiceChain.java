public abstract class ServiceChain {
    private ServiceChain next;

    public ServiceChain linkNext(ServiceChain serviceChain) {
        this.next = serviceChain;
        return next;
    }

    public abstract Order addItemToOrder(Order order, String orderString);

    protected Order addNextItem(Order order, String orderString) {
        if (next == null) {
            return order;
        }

        return next.addItemToOrder(order, orderString);
    }

}

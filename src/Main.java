public class Main {

    public static void main(String[] args) {

        // создать цепь из обслуживателей
        ServiceChain serviceChain = new PizzaMaker();
        serviceChain
                .linkNext(new IceCreamMaker())
                .linkNext(new BurgerMaker())
                .linkNext(new TeaMaker())
                .linkNext(new EndService());

        // создать заказ из слов
        String orderString = "I want pizza, ice cream and tea!";
        orderString = orderString.toLowerCase();

        // получить готовый заказ
        Order order = serviceChain.addItemToOrder(new Order(), orderString);

        // напечатать заказ
        System.out.println(order);

        // делаем второй заказ
        String secondOrderString = "Hey, baby, give me pizza, burger and tea.";
        secondOrderString = secondOrderString.toLowerCase();

        // получаем готовый
        Order secondOrder = serviceChain.addItemToOrder(new Order(), secondOrderString);
        System.out.println(secondOrder);
        // оказывается, нам не дали пиццу, потому что ингредиенты закончились :(
    }
}

import java.util.ArrayList;

public class Order {
    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Order contains:\n");
        for(Item item : items ) {
            sb.append(item + "\n");
        }
        return sb.toString();
    }
}

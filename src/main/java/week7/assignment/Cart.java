package week7.assignment;

public class Cart {
    private final String cartId;
    private final int[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[maxItems];
        this.itemCount = 0;
    }

    public void addItem(int price) {
        if (itemCount < prices.length) {
            prices[itemCount++] = price;
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}

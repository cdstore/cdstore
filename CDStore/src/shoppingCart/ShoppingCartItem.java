package shoppingCart;

import entity.Cds;
//Code Modified From tgiunipero's Code
public class ShoppingCartItem {
	Cds cds;
    Integer quantity;

    public ShoppingCartItem(Cds cd) {
        this.cds = cd;
        quantity = 1;
    }

    public Cds getCds() {
        return this.cds;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public void decrementQuantity() {
        quantity--;
    }

    public double getTotal() {
        double amount = 0;
        amount = (this.getQuantity() * this.cds.getPrice().doubleValue());
        return amount;
    }
}

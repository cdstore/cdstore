package com.cdstore.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<ShoppingCartItem> items;
    int numberOfItems;
    double total;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0;
    }

    /**
     * Adds a ShoppingCartItem to the ShoppingCart's
     * items list. If item of the specified CD
     * already exists in shopping cart list, the quantity of that item is
     * incremented.
     *

     */
    public void addItem(Cds cd) {

        boolean newItem = true;

        for (ShoppingCartItem scItem : items) {

            if (scItem.getCds().getid() == cd.getid()) {

                newItem = false;
                scItem.incrementQuantity();
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(cd);
            items.add(scItem);
        }
    }

    /**
     * Updates the ShoppingCartItem of the specified
     * CD to the specified quantity. If '0'
     * is the given quantity, the ShoppingCartItem is removed
     * from the ShoppingCart's items list.
     *
     */
    public void update(Cds cd, String quantity) {

        Integer qty = -1;

        // cast quantity as short
        qty = Integer.parseInt(quantity);

        if (qty >= 0) {

            ShoppingCartItem item = null;

            for (ShoppingCartItem scItem : items) {

                if (scItem.getCds().getid() == cd.getid()) {

                    if (qty != 0) {
                        // set item quantity to new value
                        scItem.setQuantity(qty);
                    } else {
                        // if quantity equals 0, save item and break
                        item = scItem;
                        break;
                    }
                }
            }

            if (item != null) {
                // remove from cart
                items.remove(item);
            }
        }
    }

    /**
     * Returns the list of ShoppingCartItems.
     *
     * @return the items list
     
     */
    public  List<ShoppingCartItem> getItems() {

        return items;
    }

    /**
     * Returns the sum of quantities for all items maintained in shopping cart
     * items list.
     *
     * @return the number of items in shopping cart
     * @see ShoppingCartItem
     */
    public  int getNumberOfItems() {

        numberOfItems = 0;

        for (ShoppingCartItem scItem : items) {

            numberOfItems += scItem.getQuantity();
        }

        return numberOfItems;
    }

    /**
     * Returns the sum of the product price multiplied by the quantity for all
     * items in shopping cart list. This is the total cost excluding the surcharge.
     *
     * @return the cost of all items times their quantities
     * 
     */
    public double getSubtotal() {

        double amount = 0;

        for (ShoppingCartItem scItem : items) {

            Cds product = (Cds) scItem.getCds();
            amount += (scItem.getQuantity() * product.getPrice().doubleValue());
        }

        return amount;
    }

    /**
     * Calculates the total cost of the order. This method adds the subtotal to
     * the designated surcharge and sets the total instance variable
     * with the result.
     *
     * @param surcharge the designated surcharge for all orders
     * @see ShoppingCartItem
     */
    public void calculateTotal(String vat) {

        double amount = 0;

        // cast surcharge as double
        double s = Double.parseDouble(vat);

        amount = this.getSubtotal();
        amount += s*amount;

        total = amount;
    }

    /**
     * Returns the total cost of the order for the given
     * ShoppingCart instance.
     *
     * @return the cost of all items times their quantities plus surcharge
     */
    public double getTotal() {

        return total;
    }

    /**
     * Empties the shopping cart. All items are removed from the shopping cart
     * items list, numberOfItems and
     * total are reset to '0'.
     *
     * @see ShoppingCartItem
     */
    public void clear() {
        items.clear();
        numberOfItems = 0;
        total = 0;
    }
}

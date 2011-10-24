/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cdstore.shoppingcart;

import com.cdstore.entities.*;
import java.util.*;

/**
 *
 * @author tgiunipero
 */
public class ShoppingCart {

    List<ShoppingCartItem> items;
    int numberOfItems;
    Double total;
    Double tax;

    public ShoppingCart() {
        items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        total = 0.0;
    }

    /**
     * Adds a <code>ShoppingCartItem</code> to the <code>ShoppingCart</code>'s
     * <code>items</code> list. If item of the specified <code>product</code>
     * already exists in shopping cart list, the quantity of that item is
     * incremented.
     *
     * @param product the <code>Product</code> that defines the type of shopping cart item
     * @see ShoppingCartItem
     */
    public void addItem(CD cd) {

        boolean newItem = true;

        for (ShoppingCartItem scItem : items) {

            if (scItem.getCD().getID() == cd.getID()) {

                newItem = false;
                scItem.incrementQuantity();
                scItem.setAmount();
            }
        }

        if (newItem) {
            ShoppingCartItem scItem = new ShoppingCartItem(cd);
            items.add(scItem);
            scItem.setAmount();
        }
    }

    /**
     * Updates the <code>ShoppingCartItem</code> of the specified
     * <code>product</code> to the specified quantity. If '<code>0</code>'
     * is the given quantity, the <code>ShoppingCartItem</code> is removed
     * from the <code>ShoppingCart</code>'s <code>items</code> list.
     *
     * @param product the <code>Product</code> that defines the type of shopping cart item
     * @param quantity the number which the <code>ShoppingCartItem</code> is updated to
     * @see ShoppingCartItem
     */
    public  void update(CD product, String quantity) {

        Integer qty = -1;

        // cast quantity as short
        qty = Integer.parseInt(quantity);

        if (qty >= 0) {

            ShoppingCartItem item = null;

            for (ShoppingCartItem scItem : items) {

                if (scItem.getCD().getID() == product.getID()) {

                    if (qty != 0) {
                        // set item quantity to new value
                        scItem.setQuantity(qty);
                        scItem.setAmount();
                    } else {
                        // if quantity equals 0, save item and break
                        item = scItem;
                        item.setAmount();
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
     * Returns the list of <code>ShoppingCartItems</code>.
     *
     * @return the <code>items</code> list
     * @see ShoppingCartItem
     */
    public List<ShoppingCartItem> getItems() {

        return items;
    }

    /**
     * Returns the sum of quantities for all items maintained in shopping cart
     * <code>items</code> list.
     *
     * @return the number of items in shopping cart
     * @see ShoppingCartItem
     */
    public int getNumberOfItems() {

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
     * @see ShoppingCartItem
     */
    public Double getSubtotal() {

        Double amount = (Double) 0.0;

        for (ShoppingCartItem scItem : items) {

            CD cd = (CD) scItem.getCD();
            amount += (scItem.getQuantity() * cd.getPrice().floatValue());
        }

        return amount;
    }

    /**
     * Calculates the total cost of the order. This method adds the subtotal to
     * the designated surcharge and sets the <code>total</code> instance variable
     * with the result.
     *
     * @param surcharge the designated surcharge for all orders
     * @see ShoppingCartItem
     */
    public void calculateTotal(String vat) {

        Double amount = 0.0;

        // cast surcharge as double
        Double s = Double.parseDouble(vat);

        amount = this.getSubtotal();
        amount += getTax();
        total = amount;
    }

    /**
     * Returns the total cost of the order for the given
     * <code>ShoppingCart</code> instance.
     *
     * @return the cost of all items times their quantities plus surcharge
     */
    public  Double getTotal() {

        return total;
    }
/**
 * Calulate the tax component
 */
    public void setTax(String vat){
    	Double amount =0.0;

        // cast surcharge as double
        Double s = Double.parseDouble(vat);

        amount = this.getSubtotal();
        tax = (amount*s);

        total = amount;
    }
    
    /**
     * GET THE TAX COMPONENT
     */
    public Double getTax(){
    	return this.tax;
    }
    /**
     * Empties the shopping cart. All items are removed from the shopping cart
     * <code>items</code> list, <code>numberOfItems</code> and
     * <code>total</code> are reset to '<code>0</code>'.
     *
     * @see ShoppingCartItem
     */
    public void clear() {
        items.clear();
        numberOfItems = 0;
        total =  0.0;
    }

}
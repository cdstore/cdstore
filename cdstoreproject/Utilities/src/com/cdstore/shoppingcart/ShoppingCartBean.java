package com.cdstore.shoppingcart;

public class ShoppingCartBean {

	private ShoppingCart shopCart;
	
	public ShoppingCartBean(){
		if(this.shopCart==null){
			this.shopCart = new ShoppingCart();
		}
	}
	
	public ShoppingCart getShoppingCart(){
		return this.shopCart;
	}
	
	public void addItemToShoppingCart(ShoppingCartItem item) {
		this.shopCart.addItem(item);
	}
	
	public void removeItemFromShoppingCart(ShoppingCartItem item) {
		this.shopCart.removeItem(item);
	}
	
	public void updateItemQuantityInShoppingCart(ShoppingCartItem item, Integer newQuantity){
		int itemIndex = this.shopCart.getIndexFromItem(item);
		this.shopCart.updateItemQuantity(itemIndex, newQuantity);
	}
	
	public void clearCart(){
		this.shopCart.clear();
	}
	
}

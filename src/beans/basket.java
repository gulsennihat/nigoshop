package beans;

import java.io.Serializable;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class basket implements Serializable {
	/**
	 * 
	 */
	int productId;
	private static final long serialVersionUID = 1L;
	public ArrayList<Integer> cart = new ArrayList<Integer>();
	int i;
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public ArrayList<Integer> getCart() {
		return cart;
	}

	public void setCart(ArrayList<Integer> cart) {
		this.cart = cart;
	}
	
	
	public void addToCart(){
		cart.add(getProductId());
		
	}
	
	public int cartSize(){
		return cart.size();
	}


}

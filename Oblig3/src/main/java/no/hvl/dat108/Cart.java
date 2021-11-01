package no.hvl.dat108;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Cart {
	
	private List<CartItem> items= new ArrayList<>();
	
	public void addItem(CartItem item) {
		items.add(item);
//		items.removeAll(Collections.singleton(null));
	}
	
	public List<CartItem> getItems(){
		return items;
	}
	public void fjernItem(String item) {
		items.removeAll(Collections.singleton(null));
	}

}

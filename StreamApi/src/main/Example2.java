package main;

import java.util.ArrayList;
import java.util.List;

public class Example2 {
	public static void main(String[] args) {
		List<Product> lists = new ArrayList<Product>();
		lists.add(new Product(1,"hp",300));
		lists.add(new Product(1,"dell",3000));
		lists.add(new Product(1,"lenovo",4000));
		
		lists.stream().
        filter(product -> product.price> 300)
        .forEach(product -> System.out.println(product.name)); 
		
		
		
	}

}

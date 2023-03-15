package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Product> lists = new ArrayList<Product>();
		lists.add(new Product(1,"hp",300));
		lists.add(new Product(1,"dell",3000));
		lists.add(new Product(1,"lenovo",4000));
		
		List<Integer> productList = lists.stream().
				filter(product -> product.price >300 )
				.map(p->p.price)
				.collect(Collectors.toList());
		System.out.println(productList);
				
				
	}

}

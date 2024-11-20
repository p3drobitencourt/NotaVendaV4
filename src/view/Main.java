package view;

import model.Sale;

public class Main {
	public static void main(String[] args) {
		Sale sale = new Sale();
		sale.createSaleItem("at", 2);
		sale.createSaleItem("ff", 1);
		sale.createSaleItem("msa", 2);
		sale.createSaleItem("001", 5); 
		sale.createSaleItem("002", 3);

		System.out.println("Total da Venda: " + sale.getTotal());

		System.out.println("Itens na Venda: " + sale.getItems());

		System.out.println("Preço Final: " + sale.getFinalPrice());
		
		sale.setPaymentMethod("cc");
		
		for (String item : sale.getItems())
			System.out.println(item);
		
		System.out.println(String.format("Total: %.2f", 
				sale.getTotal()));
		
		System.out.println(String.format("Forma de pagamento: '%s'", sale.getPaymentMethod()));

		System.out.println(String.format("Valor a ser pago: '%s'", sale.getFinalPrice()));
		
	}
	
}

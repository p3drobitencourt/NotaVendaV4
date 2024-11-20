package model;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private static Map<String, String[]> products = 
            new HashMap<String, String[]>();
    
    private static Map<String, PaymentMethod> payments = 
            new HashMap<String, PaymentMethod>();
                    
    static {
        
        products.put("at", new String[] {"Arroz Tatiana", "30", "100"}); // nome, preço, estoque
        products.put("ff", new String[] {"Feijão Fejó", "20", "50"});
        products.put("msa", new String[] {"Macarrão Santa Amália", "15", "200"});
        products.put("001", new String[] {"Produto Extra 1", "25", "10"});
        products.put("002", new String[] {"Produto Extra 2", "30", "15"});
        
        CreditCard creditCard1 = new CreditCard(5.0);
        DebitCard debitCard1 = new DebitCard(0.0);
        Cash cash1 = new Cash(5.0);
        
        payments.put("cc", creditCard1);
        payments.put("dc", debitCard1);
        payments.put("c", cash1);
    }
    
    public static String[] selectProduct(String code) {
        return products.get(code);
    }
    
    public static PaymentMethod selectPayment(String code) {
        return payments.get(code);
    }
}

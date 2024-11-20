package model;

public class SaleItem {
    private Product product;
    private int quantity;
        
    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
    
    @Override
    public String toString() {
        String itemStr = String.format("%s %d %.2f", 
                this.getProduct().getDescription(),
                this.getQuantity(),
                this.getSubtotal());
        
        return itemStr;
    }
    
    public void createProduct(String code, int quantity) {
        String[] productData = DataBase.selectProduct(code);

        if (productData == null || productData.length < 3) {
            throw new IllegalArgumentException("Produto não encontrado ou dados inválidos.");
        }

        this.product = new Product();
        this.product.setDescription(productData[0]);

        try {
            this.product.setPrice(Double.parseDouble(productData[1]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Preço inválido para o produto com código: " + code);
        }

        try {
            this.product.setStock(Integer.parseInt(productData[2]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Estoque inválido para o produto com código: " + code);
        }

        if (quantity > product.getStock()) {
            throw new IllegalArgumentException("Estoque insuficiente para o produto com código: " + code);
        }

        // Reduz o estoque do produto
        product.reduceStock(quantity);

        this.quantity = quantity;
    } 
}

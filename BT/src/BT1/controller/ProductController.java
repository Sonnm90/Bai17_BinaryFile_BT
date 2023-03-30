package BT1.controller;

import BT1.model.Product;
import BT1.service.IGenericService;
import BT1.service.ProductServiceIMPL;

import java.util.List;

public class ProductController {
    IGenericService productService = new ProductServiceIMPL();

    public List<Product> getListProduct() {
        return productService.findAll();
    }

    public void createProduct(Product product) {
        productService.save(product);
    }

    public void deleteProduct(int id) {
        productService.deleteById(id);
    }

    public int findMaxId(){
       return productService.findMaxId();
    }

    public Product detailProduct(int id) {
         return productService.findById(id);
    }
    public void updateProduct(Product product){
        productService.save(product);
    }
}

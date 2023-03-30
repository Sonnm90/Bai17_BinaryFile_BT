package BT1.service;

import BT1.config.Config;
import BT1.model.Product;

import java.util.List;

public class ProductServiceIMPL implements IProductService {
    List<Product> productList = new Config<Product>().readFromFile(Config.PATH_CATEGORY);

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        if (findById(product.getProductId()) == null)
            productList.add(product);
        else {
            productList.set(productList.indexOf(findById(product.getProductId())), product);
        }
        new Config<Product>().writeToFile(Config.PATH_CATEGORY, productList);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id)
                return productList.get(i);
        }
        return null;
    }

    @Override
    public int findMaxId() {
        int max = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() > max)
            max = productList.get(i).getProductId();
        }
        return max;
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id)
            productList.remove(i);
        }
        new Config<Product>().writeToFile(Config.PATH_CATEGORY, productList);
    }
}

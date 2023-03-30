package BT1.view;

import BT1.config.Config;
import BT1.controller.ProductController;
import BT1.model.Product;

import java.util.List;

public class ProductView {
    ProductController productController = new ProductController();
    List<Product> productList = productController.getListProduct();

    public void showListProduct() {
        System.out.println("*****LIST PRODUCT*****");
        System.out.println("===ID===NAME===BRAND===PRICE===DESCRIPTION===");
        for (Product product : productList
        ) {
            System.out.println("   " + product.getProductId() + "   " + product.getName() + "   " + product.getBrand() + "   " + product.getPrice() + "   " + product.getDescription());
        }
//        System.out.println(productList);
        System.out.println("Enter back to comeback Menu");
        String backMenu = Config.scanner().nextLine();
        if (backMenu.equalsIgnoreCase("back")) {
            new Main();
        }
    }

    public void createProduct() {
        while (true) {
            int id = 0;
            if (productList.size() == 0)
                id = 1;
            else {
                id = (productController.findMaxId() + 1);
            }
            System.out.println("Enter name of Product: ");
            String productName = Config.scanner().nextLine();
            System.out.println("Enter brand of Product:");
            String productBrand = Config.scanner().nextLine();
            System.out.println("Enter price of Product:");
            double price = Double.parseDouble(Config.scanner().nextLine());
            System.out.println("Enter description of Product:");
            String description = Config.scanner().nextLine();
            Product product = new Product(id, productName, productBrand, price, description);
            productController.createProduct(product);
            System.out.println("Creat Success!");
            System.out.println("Enter any key to create new Product or back to comeback Menu");
            String backMenu = Config.scanner().nextLine();
            if (backMenu.equalsIgnoreCase("back")) {
                new Main();
                break;
            }
        }
    }

    public void deleteProduct() {
        for (Product product : productList
        ) {
            System.out.println("   " + product.getProductId() + "   " + product.getName() + "   " + product.getBrand() + "   " + product.getPrice() + "   " + product.getDescription());
        }
        while (true) {
            System.out.println("Enter ID to delete Product:");
            int deleteId = Config.scanner().nextInt();
            if (productController.detailProduct(deleteId) == null) {
                System.out.println("Id not found!");
            } else {
                productController.deleteProduct(deleteId);
                System.err.println("Delete success");
                System.out.println("Enter any key to continue or back to comeback Menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Main();
                    break;
                }
            }
        }
    }

    public void updateProduct() {
        while (true) {
            System.out.println("Enter Id to update Product:");
            int id = Config.scanner().nextInt();
            if (productController.detailProduct(id) == null) {
                System.out.println("Id not found!");
            } else {
                System.out.println("Enter name of Product: ");
                String productName = Config.scanner().nextLine();
                System.out.println("Enter brand of Product:");
                String productBrand = Config.scanner().nextLine();
                System.out.println("Enter price of Product:");
                double price = Double.parseDouble(Config.scanner().nextLine());
                System.out.println("Enter description of Product:");
                String description = Config.scanner().nextLine();
                Product product = new Product(id, productName, productBrand, price, description);
                productController.updateProduct(product);
                System.out.println("Update Success!");
                System.out.println("Enter any key to continue or back to comeback Menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Main();
                    break;
                }
            }

        }

    }
}

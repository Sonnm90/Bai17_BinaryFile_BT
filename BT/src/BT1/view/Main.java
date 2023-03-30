package BT1.view;

import BT1.config.Config;

public class Main {
    public Main() {
        System.out.println("*****************PRODUCT MANAGE***************");
        System.out.println("1. Show list product");
        System.out.println("2. Create product");
        System.out.println("3. Update product");
        System.out.println("4. Delete product");
        int chooseMenu = Integer.parseInt(Config.scanner().nextLine());
        switch (chooseMenu) {
            case 1:
                new ProductView().showListProduct();
                break;
            case 2:
                new ProductView().createProduct();
                break;
            case 3:
                new ProductView().updateProduct();
                break;
            case 4:
                new ProductView().deleteProduct();
                break;
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

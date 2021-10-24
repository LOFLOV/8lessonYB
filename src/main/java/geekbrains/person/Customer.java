package geekbrains.person;


import geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person  {
    List<Product> purchaseList;

    public void whatIBoughtInfo() {
        System.out.println();
        StringBuilder builder = new StringBuilder("Я купил: ");
        for(Product purchase : purchaseList) {
            builder.append(purchase.getName());
            builder.append( " в количестве ");
            builder.append(purchase.getCount());
            builder.append(" ");
        }
        System.out.println(builder);
    }

    public void addPurchase(Product product) {
        if(purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        purchaseList.add(product);
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }
}

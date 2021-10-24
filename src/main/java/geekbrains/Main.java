package geekbrains;

import geekbrains.market.Market;
import geekbrains.person.Customer;
import geekbrains.person.Salesman;
import geekbrains.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //1) Salesman, который может добавить продукты
    //2) Customer может покупать продукты
    //3) Когда Salesman продает продукт, то из списка продуктов убирается этот продукт, а также
    //ему добавляется cash, a у customer он утбирается
    //4) Поиск товара осуществяется по продавцу и товару, либо просто по товару


    public static void main(String[] args) {
        Market market = new Market();

        Salesman firstSalesman = createFirstSalesman();
        Salesman secondSalesman = createSecondSalesman();
        Customer customer = new Customer();
        customer.setCash(50);

        firstSalesman.sellProducts(customer, "Помидоры", 3);
        customer.whatIBoughtInfo();


    }

    private static Salesman createFirstSalesman() {
        Salesman salesman = new Salesman();
        salesman.setCash(0);
        salesman.setName("Витайлий");
        salesman.setSecondName("Арбузов");

        Product firstProduct = new Product();
        firstProduct.setName("Помидоры");
        firstProduct.setPrice(10);
        firstProduct.setCount(20);

        Product secondProduct = new Product();
        secondProduct.setName("Огурцы");
        secondProduct.setPrice(8);
        secondProduct.setCount(100);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);

        salesman.setProducts(products);

        return salesman;
    }

    private static Salesman createSecondSalesman() {
        Salesman salesman = new Salesman();
        salesman.setCash(0);
        salesman.setName("Алекс");
        salesman.setSecondName("Ушаков");

        Product firstProduct = new Product();
        firstProduct.setName("Помидоры");
        firstProduct.setPrice(8);
        firstProduct.setCount(40);

        Product secondProduct = new Product();
        secondProduct.setName("Огурцы");
        secondProduct.setPrice(5);
        secondProduct.setCount(12);

        List<Product> products = new ArrayList<>();
        products.add(firstProduct);
        products.add(secondProduct);

        salesman.setProducts(products);

        return salesman;
    }

}

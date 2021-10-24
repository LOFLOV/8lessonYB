package geekbrains.person;


import geekbrains.product.Product;

import java.util.List;

public class Salesman extends Person {
    private String name;
    private String secondName;
    private List<Product> products;

    public void sellProducts(Customer customer, String weWannaBuyName, int weWannaBuyCount) {
        for (Product product : products) {
            if (product.getName().equals(weWannaBuyName)) {                               // сравниваем по имени потребуемого товара от покупца с наличием у продавца
                if (product.getCount() >= weWannaBuyCount) {                            // смотрим на количество/сравниваем у продавца
                    long requiredCash = (long) product.getPrice() * weWannaBuyCount;     // проверяем что кэш покупатеяля позволяет купить товар
                    if (customer.getCash() >= requiredCash) {
                        product.setCount(product.getCount() - weWannaBuyCount);        // мы устанавливаем(set) количество продукта, беря(get) текущее кол-во и отнимая то кол-во которое хотим купить
                        Product customerProduct = new Product();                    //создаем новый обьект продуктов что бы создать новую ссылку
                        customerProduct.setCount(weWannaBuyCount);
                        customerProduct.setName(weWannaBuyName);
                        customer.addPurchase(customerProduct);                                 //   добавляем кол-во продуктов у покупателя
                        this.setCash((int) (this.getCash() + requiredCash));          //    увеличиваем кеш   кастим в int     this текущий продавец
                        customer.setCash((int) (customer.getCash() - requiredCash));     //уменшаем кеш у  покупателя

                        return;                                                         //выходим из метода
                    }
                }
            }
        }
        System.out.printf("Продукт продавца %s %s не найден. Не достаточное кол-во продукта", name, secondName);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public List<Product>  getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

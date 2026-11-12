package com.kirkis1;

import com.kirkis1.model.Order;
import com.kirkis1.model.OrderStatus;

public class Main {
    public static void main (String[] args){
        Order firstOrder = new Order(1, "Новосибирск");
        System.out.println(firstOrder);
        firstOrder.setCourier("Миша");
        firstOrder.setStatus(OrderStatus.ASSIGNED);
        System.out.println(firstOrder);
        System.out.println(firstOrder.getStatus()==OrderStatus.ASSIGNED);

        Order secondOrder = new Order(2, "Москва");

        Order thirdOrder = new Order(2, "Казань");

        OrderBook orderBook = new OrderBook();
        orderBook.add(firstOrder);
        orderBook.add(secondOrder);
        orderBook.add(thirdOrder);



        System.out.println("Количество заказов:" + orderBook.size());
        System.out.println("Поиск заказа по id " + orderBook.find(2));
        System.out.println(orderBook.add(thirdOrder));



    }
}

package com.kirkis1;

import com.kirkis1.model.Order;
import com.kirkis1.model.OrderStatus;

import java.util.Arrays;

public class Main {
    public static void main (String[] args){
        Order firstOrder = new Order(1, "Новосибирск");
        System.out.println(firstOrder);
        firstOrder.setCourier("Миша");
        firstOrder.setStatus(OrderStatus.ASSIGNED);
        System.out.println(firstOrder);
        System.out.println(firstOrder.getStatus()==OrderStatus.ASSIGNED);

        Order secondOrder = new Order(2, "Москва");
        /*secondOrder.setStatus(OrderStatus.DELIVERED);*/
        Order thirdOrder = new Order(3, "Казань");

        OrderBook orderBook = new OrderBook();
        orderBook.add(firstOrder);
        orderBook.add(secondOrder);
        orderBook.add(thirdOrder);

        System.out.println("Количество заказов:" + orderBook.size());
        System.out.println("Поиск заказа по id " + orderBook.find(2));
        System.out.println(orderBook.add(thirdOrder));

        orderBook.add(new Order(3, "Садовая 7"));
        System.out.println("Назначить 2: " + orderBook.assign(2, "Пётр"));
        System.out.println("Назначить 2 ещё раз: " + orderBook.assign(2, "Олег"));
        System.out.println("Назначить 9: " + orderBook.assign(9, "Олег"));
        System.out.println("Доставить 3: " + orderBook.deliver(3));
        System.out.println("Доставить 2: " + orderBook.deliver(2));
        System.out.println(orderBook.find(2));

        System.out.println(secondOrder);
        Order found = new Order(2, "Москва");
        System.out.println(found.equals(secondOrder));

        System.out.println(orderBook.countByStatus(OrderStatus.NEW));
        System.out.println(Arrays.toString(orderBook.byStatus(OrderStatus.DELIVERED)));





    }
}

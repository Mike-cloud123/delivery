package com.kirkis1;

import com.kirkis1.model.Order;
import com.kirkis1.model.OrderStatus;

import java.util.function.BooleanSupplier;

/**
 * Проверки шага 1 домашней работы после занятия 5.
 * Положи файл рядом с Main, в пакет com.kirkis1, и запусти зелёным треугольником.
 * В конце должна быть строка «OK 7 из 7». Сам файл менять не нужно.
 */
public class DeliveryChecks5 {
    private static int passed;
    private static int total;

    public static void main(String[] args) {
        OrderBook book = new OrderBook();
        Order first = new Order(1, "Новосибирск");
        Order second = new Order(2, "Москва");
        book.add(first);
        book.add(second);

        check("новый заказ не доставляется",
                () -> !book.deliver(1));
        check("после отказа заказ остался новым",
                () -> first.getStatus() == OrderStatus.NEW);
        book.assign(1, "Миша");
        check("назначенный заказ доставляется",
                () -> book.deliver(1));
        check("у доставленного статус DELIVERED",
                () -> first.getStatus() == OrderStatus.DELIVERED);
        check("курьер после доставки тот же",
                () -> "Миша".equals(first.getCourier()));
        check("второй раз тот же заказ не доставляется",
                () -> !book.deliver(1));
        check("заказа с номером 9 в книге нет",
                () -> !book.deliver(9));

        System.out.println("OK " + passed + " из " + total);
    }

    private static void check(String name, BooleanSupplier test) {
        total++;
        try {
            if (test.getAsBoolean()) {
                passed++;
                System.out.println("верно:  " + name);
            } else {
                System.out.println("НЕ ТАК: " + name);
            }
        } catch (RuntimeException error) {
            System.out.println("УПАЛО:  " + name + " — " + error);
        }
    }
}

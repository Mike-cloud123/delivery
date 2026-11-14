package com.kirkis1;

import com.kirkis1.model.Order;
import com.kirkis1.model.OrderStatus;

public class OrderBook {
    private Order[] orders;
    private int count;

    public OrderBook (){
        orders = new Order[100];
        count=0;
    }
    public boolean add(Order newOrder){
        if (count==orders.length){
            return false;
        }
        if (find(newOrder.getId())!=null){
            return false;
        }
        this.orders[count]= newOrder;
        count++;
        return true;
    }
    public int size (){
        return count;
    }

    public Order find (long id){
        for (int i = 0; i < count; i++) {
            if (orders[i].getId()==id){
                return orders[i];
            }
        }
        return null;
    }
    public boolean assign (long id, String courier){
        Order order=find(id);
        if (order==null){
            return false;
        }
        if (order.getStatus()!= OrderStatus.NEW){
            return false;
        }
        order.setCourier(courier);
        order.setStatus(OrderStatus.ASSIGNED);
        return true;

    }
    public boolean deliver (long id){
        Order order = find(id);
        if (order==null){
            return false;
        }
        if (order.getStatus()!=OrderStatus.ASSIGNED){
            return false;
        }
        order.setStatus(OrderStatus.DELIVERED);
        return true;
    }
    public int countByStatus(OrderStatus status){
        int countStatus=0;
        for (int i = 0; i < count; i++) {
            if (orders[i].getStatus()==status){
                countStatus++;
            }
        }
        return countStatus;
    }
    public Order[] byStatus(OrderStatus status){
        Order [] ordersStatus = new Order[countByStatus(status)];
        for (int i = 0, j=0; i < count; i++) {
            if (orders[i].getStatus()==status){
                ordersStatus[j++]=orders[i];
            }
        }
        return ordersStatus;

    }
}

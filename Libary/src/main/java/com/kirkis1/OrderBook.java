package com.kirkis1;

import com.kirkis1.model.Order;

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
}

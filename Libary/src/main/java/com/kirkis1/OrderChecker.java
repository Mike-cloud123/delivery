package com.kirkis1;

import com.kirkis1.model.Order;

public class OrderChecker {
    public boolean sameOrder(Order first, Order second){
        if (first==second){
            return true;
        }
        return false;
    }
    public boolean sameNumber(Order first, Order second){
        if (first==null || second==null){
            return false;
        }
        return first.getId()==second.getId();
    }
}

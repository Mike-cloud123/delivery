package com.kirkis1.model;

public class Order {
    long id;
    String address;
    OrderStatus status;
    String courier;

    Order (long id, String address){
        this.id = id;
        this.address = address;
        this.status = OrderStatus.NEW;
    }

    void setStatus (OrderStatus newStatus){
        this.status=newStatus;
    }

    void setCourier (String newCourier){
        this.courier= newCourier;
    }

    long getId (){
        return id;
    }

    String getAddress (){
        return address;
    }

    OrderStatus getStatus (){
        return status;
    }

    String getCourier (){
        return courier;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", status=" + status +
                ", courier='" + courier + '\'' +
                '}';
    }
}


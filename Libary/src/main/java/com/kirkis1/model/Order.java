package com.kirkis1.model;

public class Order {
    private long id;
    private String address;
    private OrderStatus status;
    private String courier;

    public Order (long id, String address){
        this.id = id;
        this.address = address;
        this.status = OrderStatus.NEW;
    }

    public void setStatus (OrderStatus newStatus){
        this.status=newStatus;
    }

    public void setCourier (String newCourier){
        this.courier= newCourier;
    }

    public long getId (){
        return id;
    }

    public String getAddress (){
        return address;
    }

    public OrderStatus getStatus (){
        return status;
    }

    public String getCourier (){
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


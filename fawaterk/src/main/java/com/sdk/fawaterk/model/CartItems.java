package com.sdk.fawaterk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItems {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("price")
    @Expose
    private Double price;

    /**
     * No args constructor for use in serialization
     *
     */
    public CartItems() {
    }

    /**
     *
     * @param price
     * @param quantity
     * @param name
     */
    public CartItems( String name, Integer quantity, Double price) {
        super();
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public String getname() {
        return name;
    }

    public void setname(String productName) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getprice() {
        return price;
    }

    public void setprice(Double price) {
        this.price = price;
    }

}


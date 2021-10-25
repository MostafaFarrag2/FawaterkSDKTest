
package com.sdk.fawaterk.model;

import java.util.ArrayList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceModel {
    @SerializedName("vendorKey")
    @Expose
    private String vendorKey;

    @SerializedName("cartItems")
    @Expose
    private ArrayList<CartItems> cartItems = null;

    @SerializedName("cartTotal")
    @Expose
    private Double cartTotal = 0.0;
    @SerializedName("shipping")
    @Expose
    private Double shipping = 0.0;

    @SerializedName("customer")
    @Expose
    private ArrayList<Customer> customer = null;


    @SerializedName("redirectUrl")
    @Expose
    private String redirectUrl;


    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("sendSMS")
    @Expose
    private Boolean sendSMS;

    @SerializedName("sendEmail")
    @Expose
    private Boolean sendEmail;
    @SerializedName("pay_load")
    @Expose
    private String pay_load;

    public InvoiceModel(){

    }

    // Required fields only
    public InvoiceModel(String vendorKey, ArrayList<CartItems> cartItems, Double shipping, Double cartTotal,ArrayList<Customer> customer,
                        String redirectUrl,String currency,Boolean sendSMS,Boolean sendEmail, String pay_load ) {
        this.vendorKey = vendorKey;
        this.cartItems = cartItems;
        this.cartTotal = cartTotal;
        this.shipping = shipping;
        this.customer = customer;
        this.redirectUrl = redirectUrl;
        this.currency = currency;
        this.sendSMS = sendSMS;
        this.sendEmail = sendEmail;
        this.pay_load = pay_load;

    }


    public String getvendorKey() {
        return vendorKey;
    }

    public void setvendorKey(String vendorKey) {
        this.vendorKey = vendorKey;
    }

    public String getredirectUrl() {
        return redirectUrl;
    }

    public void setredirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getPay_load() {
        return pay_load;
    }

    public void setPay_load(String pay_load) {
        this.pay_load = pay_load;
    }
    public Boolean getSendSMS() {
        return sendSMS;
    }

    public void setSendSMS(Boolean sendSMS) {
        this.sendSMS = sendSMS;
    }
    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public ArrayList<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public ArrayList<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(ArrayList<Customer> customer) {
        this.customer = customer;
    }


    public Double getcartTotal() {
        return cartTotal;
    }

    public void setcartTotal(Double cartTotal) {
        this.cartTotal = cartTotal;
    }


    public Double getShipping() {
        return shipping;
    }

    public void setShipping(Double shipping) {
        this.shipping = shipping;
    }





}

package com.sdk.fawaterk.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvoiceResponseModel {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("invoiceKey")
    @Expose
    private String invoiceKey;
    @SerializedName("invoiceID")
    @Expose
    private long invoiceID;


    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public String getInvoiceKey() { return invoiceKey; }
    public void setInvoiceKey(String value) { this.invoiceKey = value; }

    public long getInvoiceID() { return invoiceID; }
    public void setInvoiceID(long value) { this.invoiceID = value; }
}
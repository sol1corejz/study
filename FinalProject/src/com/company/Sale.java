package com.company;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sale {

    int saleid;
    int sellerid;
    int productid;
    int amount;
    String date;

    public int getSaleid() {
        return saleid;
    }

    public void setSaleid(int saleid) {
        this.saleid = saleid;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleid=" + saleid +
                ", sellerid=" + sellerid +
                ", productid=" + productid +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}

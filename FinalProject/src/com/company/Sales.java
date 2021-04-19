package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "sales")
@XmlAccessorType(XmlAccessType.NONE)
public class Sales {

    @XmlElement(name = "sale")
    List<Sale> sales = new ArrayList();

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }
}

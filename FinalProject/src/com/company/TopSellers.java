package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TopSellers")
@XmlAccessorType(XmlAccessType.NONE)
public class TopSellers {

    @XmlElement(name = "TopSeller")
    List<TopSeller> topSellers = new ArrayList();

    public List<TopSeller> getTopSellers() {
        return topSellers;
    }

    public void setTopSellers(List<TopSeller> topSellers) {
        this.topSellers = topSellers;
    }
}

package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "TopDays")
@XmlAccessorType(XmlAccessType.NONE)
public class TopDays {

    @XmlElement(name = "TopDay")
    List<TopDay> topDays = new ArrayList();

    public List<TopDay> getTopDays() {
        return topDays;
    }

    public void setTopDays(List<TopDay> topDays) {
        this.topDays = topDays;
    }
}

package com.company;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "availabilities")
@XmlAccessorType(XmlAccessType.NONE)
public class Availabilities {

    @XmlElement(name = "availability")
    List<Availability> availabilities = new ArrayList();

    public List<Availability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<Availability> availabilities) {
        this.availabilities = availabilities;
    }
}

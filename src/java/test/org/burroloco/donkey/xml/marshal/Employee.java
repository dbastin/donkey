package org.burroloco.donkey.xml.marshal;

import au.net.netstorm.boost.bullet.primordial.Primordial;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
public class Employee extends Primordial {

    private Integer id;
    private String name;
    private Integer salary;
    private Date startDate;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    @XmlElement
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSalary() {
        return salary;
    }

    @XmlElement
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Date getStartDate() {
        return startDate;
    }

    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}

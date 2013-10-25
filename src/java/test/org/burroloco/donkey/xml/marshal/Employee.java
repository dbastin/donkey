package org.burroloco.donkey.xml.marshal;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@XmlType(propOrder = {"id", "name", "salary", "startDate", "positionTitle"})
public class Employee extends Primordial {

    private Integer id;
    private String name;
    private Integer salary;
    private Date startDate;
    private String positionTitle;

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

    public String getPositionTitle() {
        return positionTitle;
    }

    @XmlPath("fields/field[@name='position_title']/text()")
    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }
}

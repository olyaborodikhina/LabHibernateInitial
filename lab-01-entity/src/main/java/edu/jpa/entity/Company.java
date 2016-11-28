package edu.jpa.entity;

import javax.persistence.*;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.02.15
 */

@Entity
@Table(name = "Company")
@SecondaryTables({
@SecondaryTable(
        name = "CompanyDetail",
        pkJoinColumns = {
                @PrimaryKeyJoinColumn(
                        name = "Company_id",
                        referencedColumnName = "Company_id")
        }


),
@SecondaryTable(
        name= "CompanyDirectors",
        pkJoinColumns = {
                @PrimaryKeyJoinColumn(
                        name = "Company_id",
                        referencedColumnName = "Company_id"
                )
        }
)
        })

public class Company {
    @Id
    @Column(
            table = "Company",
            name = "Company_id")
    private Integer id;

    @Column(
            name = "Company_name",
            table = "Company")
    private String name;

    @Column(
            name = "Company_address",
            table = "Company")
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

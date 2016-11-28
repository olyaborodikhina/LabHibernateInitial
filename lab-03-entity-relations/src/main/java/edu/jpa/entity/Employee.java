package edu.jpa.entity;

import edu.jpa.entity.embeddables.Project;

import javax.persistence.*;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 15.02.15
 */
@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Department department;
    @ElementCollection
    private List<Project> projects;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

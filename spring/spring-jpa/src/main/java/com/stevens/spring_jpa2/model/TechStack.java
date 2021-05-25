package com.stevens.spring_jpa2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "techstack")
public class TechStack {
    @Id
    @Column(name = "stack_id")
    String stack_id;

    @Column(name = "stack_name")
    String stack_name;

    @ManyToMany(mappedBy = "techStacks", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    Set<Employee> employees = new HashSet<>();

    public TechStack() {
    }

    public TechStack(String stack_id, String stack_name) {
        this.stack_id = stack_id;
        this.stack_name = stack_name;
    }

    public String getStack_id() {
        return stack_id;
    }

    public void setStack_id(String stack_id) {
        this.stack_id = stack_id;
    }

    public String getStack_name() {
        return stack_name;
    }

    public void setStack_name(String stack_name) {
        this.stack_name = stack_name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return "TechStack [stack_id=" + stack_id + ", stack_name=" + stack_name + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((stack_id == null) ? 0 : stack_id.hashCode());
        result = prime * result + ((stack_name == null) ? 0 : stack_name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TechStack other = (TechStack) obj;
        if (stack_id == null) {
            if (other.stack_id != null)
                return false;
        } else if (!stack_id.equals(other.stack_id))
            return false;
        if (stack_name == null) {
            if (other.stack_name != null)
                return false;
        } else if (!stack_name.equals(other.stack_name))
            return false;
        return true;
    }

}

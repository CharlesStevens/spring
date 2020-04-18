package com.swastik.spring_jpa_query.main;

import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class HibernateExample {

  private static SessionFactory factory;

  public static void main(String[] args) {
    try {
      try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }

      HibernateExample ME = new HibernateExample();

      /* Add few employee records in database */
//    Long salesRepId1 = ME.addEmployee("Abhishek", "IT", 1000.00d, "Bangalore");
//    Long salesRepId2 = ME.addEmployee("Daisy", "Sales", 5000.00d, "Delhi");
//    Long salesRepId3 = ME.addEmployee("John", "HR", 10000.56d, "Mumbai");

      /* List down all the employees */
//      ME.listEmployees();
      ME.criteriaQuery();

      /* Update employee's records */
//    ME.updateEmployee(salesRepId1, 5000);
//
//    /* Delete an employee from the database */
//    ME.deleteEmployee(salesRepId2);
//
//    /* List down new list of the employees */
//    ME.listEmployees();
    } finally {
      factory.close();
    }
  }

  private void criteriaQuery() {
    Session session = factory.openSession();
//    Transaction tx = null;

    try {

      Criteria cr = session.createCriteria(SalesRep.class);
      cr.add(Restrictions.gt("repSalary", 2100.00d));
      cr.add(Restrictions.lt("repSalary", 3213123.00d));
      List employees = cr.list();
//      tx = session.beginTransaction();
//      CriteriaBuilder cr = session.getCriteriaBuilder();
//      CriteriaQuery<SalesRep> crQ = cr.createQuery(SalesRep.class);
//      Root<SalesRep> root = crQ.from(SalesRep.class);
//      crQ.select(root).where(cr.greaterThan(root.get("repSalary"), 1001.00d));
//
//      List employees = session.createQuery(crQ).list();
      for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
        SalesRep employee = (SalesRep) iterator.next();
        System.out.println("SalesRepId: " + employee.getRepresentativeId());
        System.out.println("Name: " + employee.getRepName());
        System.out.println("Department : " + employee.getRepDepartment());
        System.out.println("Salary: " + employee.getRepSalary());
        System.out.println("Area: " + employee.getRepArea());

        System.out.println("#######################----#######################");
      }
//      tx.commit();
    } catch (HibernateException e) {
//      if (tx != null) {
//        tx.rollback();
//      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to CREATE an employee in the database */
  public Long addEmployee(String fname, String deparment, double salary, String area) {
    Session session = factory.openSession();
    Transaction tx = null;
    Long salesRepID = null;

    try {
      tx = session.beginTransaction();
      SalesRep employee = new SalesRep(fname, deparment, salary, area);
      salesRepID = (Long) session.save(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
    return salesRepID;
  }

  /* Method to  READ all the employees */
  public void listEmployees() {
    Session session = factory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      List employees = session.createQuery("FROM SalesRep").list();
      for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
        SalesRep employee = (SalesRep) iterator.next();
        System.out.println("SalesRepId: " + employee.getRepresentativeId());
        System.out.println("Name: " + employee.getRepName());
        System.out.println("Department : " + employee.getRepDepartment());
        System.out.println("Salary: " + employee.getRepSalary());
        System.out.println("Area: " + employee.getRepArea());

        System.out.println("#######################----#######################");
      }
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to UPDATE salary for an employee */
  public void updateEmployee(Integer repId, double salary) {
    Session session = factory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      SalesRep employee = (SalesRep) session.get(SalesRep.class, repId);
      employee.setRepSalary(salary);
      session.update(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }

  /* Method to DELETE an employee from the records */
  public void deleteEmployee(Integer repId) {
    Session session = factory.openSession();
    Transaction tx = null;

    try {
      tx = session.beginTransaction();
      SalesRep employee = (SalesRep) session.get(SalesRep.class, repId);
      session.delete(employee);
      tx.commit();
    } catch (HibernateException e) {
      if (tx != null) {
        tx.rollback();
      }
      e.printStackTrace();
    } finally {
      session.close();
    }
  }
}

@Entity
@Table
class SalesRep {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long representativeId;
  @Column
  String repName;
  @Column
  String repDepartment;
  @Column
  Double repSalary;
  @Column
  String repArea;

  public SalesRep() {
  }

  public SalesRep(String repName, String repDepartment, Double repSalary, String repArea) {
    this.repName = repName;
    this.repDepartment = repDepartment;
    this.repSalary = repSalary;
    this.repArea = repArea;
  }

  public Long getRepresentativeId() {
    return representativeId;
  }

  public void setRepresentativeId(Long representativeId) {
    this.representativeId = representativeId;
  }

  public String getRepName() {
    return repName;
  }

  public void setRepName(String repName) {
    this.repName = repName;
  }

  public String getRepDepartment() {
    return repDepartment;
  }

  public void setRepDepartment(String repDepartment) {
    this.repDepartment = repDepartment;
  }

  public Double getRepSalary() {
    return repSalary;
  }

  public void setRepSalary(Double repSalary) {
    this.repSalary = repSalary;
  }

  public String getRepArea() {
    return repArea;
  }

  public void setRepArea(String repArea) {
    this.repArea = repArea;
  }
}
package com.stevens.spring_jpa_query.main;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

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
//      Long salesRepId1 = ME.addEmployee("Abhishek", "IT", 1000.00d, "Bangalore");
//      Long salesRepId2 = ME.addEmployee("Daisy", "Sales", 5000.00d, "Delhi");
//      Long salesRepId3 = ME.addEmployee("John", "HR", 10000.56d, "Mumbai");
//      Long salesRepId4 = ME.addEmployee("Denver", "IT", 12000.00d, "Delhi");
//      Long salesRepId5 = ME.addEmployee("Paul", "HR", 8500.56d, "Bangalore");


      /* List down all the employees */
//      ME.listEmployees();
//      ME.executeNamedQuery();
      ME.executeParameterizedQuery();
//      ME.criteriaQuery();

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

  private void executeParameterizedQuery() {
    Session session = factory.openSession();
    Transaction tx = null;
    try {
      tx = session.beginTransaction();
//
//      List<SalesRep> slRep = session
//          .createQuery("select f from SalesRep f where f.representativeId = 1 and 2=2").list();
//      slRep.forEach(t-> System.out.println(t.toString()));
      String hql = "select f from SalesRep f where f.representativeId= :representativeId";
      Query q = session
          .createQuery(hql);
      q.setParameter("representativeId", 1l);
      List<SalesRep> slRep = q.getResultList();
      slRep.forEach(t -> System.out.println(t.toString()));

      tx.commit();
    } catch (Exception e) {
      if (tx != null) {
        tx.rollback();
      }
    }

  }

  private void executeNamedQuery() {

    Session session = factory.openSession();

    Query nq = session.getNamedQuery("getSalesRepNamedQuery");
    nq.setParameter("id", 1l);
    List<SalesRep> sr = nq.getResultList();

    System.out.println(sr);

    NativeQuery nq1 = session.getNamedNativeQuery("getSalesRepQuery");
    nq1.setParameter("area", "Bangalore");
    nq1.addEntity(SalesRep.class);
    List<SalesRep> sr1 = nq1.getResultList();

    System.out.println(sr1);
    session.close();
  }

  private void criteriaQuery() {
    Session session = factory.openSession();
//    Transaction tx = null;

    try {

//      Criteria cr = session.createCriteria(SalesRep.class);
//      cr.add(Restrictions.gt("repSalary", 2100.00d));
//      cr.add(Restrictions.lt("repSalary", 3213123.00d));
//      List employees = cr.list();
//      tx = session.beginTransaction();
//      CriteriaBuilder cr = session.getCriteriaBuilder();
//      CriteriaQuery<SalesRep> crQ = cr.createQuery(SalesRep.class);
//      Root<SalesRep> root = crQ.from(SalesRep.class);
//      crQ.select(root).where(cr.greaterThan(root.get("repSalary"), 1001.00d));

//      Criteria cr = session.createCriteria(SalesRep.class);
//      cr.setProjection(Projections.projectionList().add(Projections.groupProperty("repArea"))
//          .add(Projections.count("repArea"))));
//      List employees = cr.list();

      CriteriaBuilder cr = session.getCriteriaBuilder();
      CriteriaQuery<Object[]> crQ = cr.createQuery(Object[].class);
      Root<SalesRep> root = crQ.from(SalesRep.class);
      crQ.groupBy(root.get("repArea"));
      crQ.multiselect(root.get("repArea"), cr.count(root.get("repArea")));
      List employees = session.createQuery(crQ).list();

//      List employees = session.createQuery(crQ).list();
//      for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
//        SalesRep employee = (SalesRep) iterator.next();
//        System.out.println("SalesRepId: " + employee.getRepresentativeId());
//        System.out.println("Name: " + employee.getRepName());
//        System.out.println("Department : " + employee.getRepDepartment());
//        System.out.println("Salary: " + employee.getRepSalary());
//        System.out.println("Area: " + employee.getRepArea());
//
//        System.out.println("#######################----#######################");
//      }

      for (Object objA : employees) {
        for (Object obj : (Object[]) objA) {
          System.out.println(obj.toString());
        }
        System.out.println("--------");
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
//      List employees = session.createQuery("FROM SalesRep").list();
//      for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
//        SalesRep employee = (SalesRep) iterator.next();
//        System.out.println("SalesRepId: " + employee.getRepresentativeId());
//        System.out.println("Name: " + employee.getRepName());
//        System.out.println("Department : " + employee.getRepDepartment());
//        System.out.println("Salary: " + employee.getRepSalary());
//        System.out.println("Area: " + employee.getRepArea());
//
//        System.out.println("#######################----#######################");
//      }

      NativeQuery sr = session.createSQLQuery("select * from SalesRep where representativeId='1'");
      sr.addEntity(SalesRep.class);
      SalesRep rep = (SalesRep) sr.getSingleResult();
      session.evict(rep);
      rep.setRepName("Abhishek");
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

@NamedQuery(name = "getSalesRepNamedQuery", query = "select f from SalesRep f where f.representativeId=:id")
@NamedNativeQuery(name = "getSalesRepQuery", query = "select * from Salesrep where repArea=:area")
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

  @Override
  public String toString() {
    return "SalesRep{" +
        "representativeId=" + representativeId +
        ", repName='" + repName + '\'' +
        ", repDepartment='" + repDepartment + '\'' +
        ", repSalary=" + repSalary +
        ", repArea='" + repArea + '\'' +
        '}';
  }
}
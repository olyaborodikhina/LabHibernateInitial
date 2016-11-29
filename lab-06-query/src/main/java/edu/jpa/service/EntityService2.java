package edu.jpa.service;

import edu.jpa.entity.Department;
import edu.jpa.entity.Employee;

import javax.persistence.CacheRetrieveMode;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Anton German &lt;AGerman@luxoft.com&gt;
 * @version 1.0 01.03.15
 */
public class EntityService2 extends EntityService {
    @Override
    public List<Employee> getEmployeesByDepartmentName(String name) {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root e = cq.from(Employee.class);
        cq.where(cb.equal(e.get("department").get("name"),
                cb.parameter(String.class, "name")));
        em.getTransaction().begin();
        TypedQuery<Employee> query = em.createQuery(cq);
        query.setParameter("name",name);
        List<Employee> result = query.getResultList();
        em.getTransaction().rollback();
        return result;
    }

    @Override
    public List<DepartmentInfo> getDepartmentsInfo() {
        EntityManager em = getEntityManagerFactory().createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<DepartmentInfo> cq = cb.createQuery(DepartmentInfo.class);
        Root e = cq.from(Employee.class);
        cq.select(cb.construct(DepartmentInfo.class, e.get("department").get("name"), cb.count(e.get("department"))));
        cq.groupBy(e.get("department"));
        TypedQuery<DepartmentInfo> query = em.createQuery(cq);
        List<DepartmentInfo> result = query.getResultList();
        em.getTransaction().rollback();
        return result;
    }
}

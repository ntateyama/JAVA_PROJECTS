package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Employee;

/**
 * Session Bean implementation class EmpLogic
 */
@Stateless
public class EmpLogic {

        @PersistenceContext(unitName = "JPA")
    private EntityManager em;

    public Employee getEmp(long id) {
        return em.find(Employee.class, id);
        }

    public Employee getEmpWithRefresh(long id) {
        Employee emp = em.find(Employee.class, id);
        em.refresh(emp);
        return emp;
        }

    public void createEmp(Employee emp) {
        em.persist(emp);
        }

    public void updateEmp(Employee emp) {
        em.merge(emp);
        }

    public void removeEmp(Employee emp) {
        Employee managedEmp = em.merge(emp);
        em.remove(managedEmp);
        }
}

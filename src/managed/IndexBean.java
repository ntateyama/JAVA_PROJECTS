package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import ejb.EmpLogic;
import model.Employee;

@ManagedBean
public class IndexBean {

    @EJB
    private EmpLogic empLogic;
    
    private Employee dispEmp = new Employee();
    
    public Employee getDispEmp() {
        return dispEmp;
        }    

    public void setDispEmp(Employee dispEmp) {
        this.dispEmp = dispEmp;
        }

    public void actionGetEmp() {
        dispEmp = empLogic.getEmp(dispEmp.getEmployeeId());
        }

    public void actionGetEmpRefresh() {
        dispEmp = empLogic.getEmpWithRefresh(dispEmp.getEmployeeId());
        }

    public void actionCreateEmp() {
        empLogic.updateEmp(this.dispEmp);
        }

    public void actionRemoveEmp() {
        empLogic.removeEmp(dispEmp);
        actionClearEmp();
        }

    public void actionClearEmp() {
        dispEmp = new Employee();
        } 
}

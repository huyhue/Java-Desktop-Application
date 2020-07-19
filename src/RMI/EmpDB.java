package RMI;
//gom co  5 class EmpDB + EmpDBImp + ConnectDB + ClientDB + ServerDB
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;


/* 
    Develop additional class and component in new package name rmi to allow this
    application offer remote service for inserting an Emp, listing an Emp by Emp_ID
 */
public interface EmpDB extends Remote {

    public Vector<Employee> getList() throws RemoteException;

    public int newEmp(String empID, String lastName, String firstName, String gender, String email) throws RemoteException;

    public Vector<Employee> searchByID(String id) throws RemoteException;
}


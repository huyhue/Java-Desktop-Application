package treeDemo;
public class Department {
    String depCode, depName;

    public Department(String depCode, String depName) {
        this.depCode = depCode;
        this.depName = depName;
    }

    public String getDepCode() {
        return depCode;
    }

    public void setDepCode(String depCode) {
        this.depCode = depCode;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return depCode + "-" + depName;
    }
    
}

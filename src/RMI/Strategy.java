package RMI;
//gom co class Math, Calculator, Strategy
import java.io.Serializable;

public class Strategy implements Serializable{
    private String name;

    public Strategy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
}

//Create Remote Object
//gom co class RmiClient, RmiServer, Weather,WeatherImp, WeatherInterface
package RmiMath;
import java.io.Serializable;

public class Weather implements Serializable{
    private String name = "";
    private float temperature = 0.0F;

    public Weather() {
        name = "NoCity";
        temperature = 0.0F;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }
}

package AC;

public class AC {
    private boolean isOn;
    private int temperature = 16;

    public boolean isOn(){
        return this.isOn;
    }

    public boolean turnOn() {
        if (!this.isOn){
            return isOn = true;
        }
        return isOn = false;
    }

    public void increaseTemperatureWhenRoomIsCold(){
        if(this.isOn){
            ++temperature ;
        if(temperature > 30)  {
            temperature = 30;
        }
        }
    }
    public void decreaseTemperature(){
        if(this.isOn){
            --temperature;
        if( temperature < 16){
            temperature = 16;
        }
        }
    }
    public int getTemperature(){
        return temperature;
    }

}
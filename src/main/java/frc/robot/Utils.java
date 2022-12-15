package frc.robot;

public class Utils {
    public static double reduceJoystickError(double value){
        if ((value < 0.2) && (value > -0.2))
            return value = 0;
        return value;
    }

    public static double joystickValue2Power(double value){
        return value*value*Math.signum(value);
    }
}

package frc.robot;
import frc.robot.subsystems.Chassis;
import frc.robot.Constants;


public class Utils {
    public static double reduceJoystickError(double value){
        if ((value < 0.2) && (value > -0.2))
            return value = 0;
        return value;
    }

    public static double joystickValue2Power(double value){
        return value*value*Math.signum(value);
    }

    // public static double getPositionOfRobotInMeters(double value){
    //     value=((chassis.getLeftPosition()+chassis.getRightPosition())/2)/ Constants.PULSE_PER_METER;
    //     return value;
    // }
}

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Chassis extends SubsystemBase {
    private TalonFX rightFront;
    private TalonFX rightRear;
    private TalonFX leftFront;
    private TalonFX leftRear;
    // private PigeonIMU gyro;

    public Chassis(int... motorsIds) { // "restarting" the variables = constructor
        // first we "tell" each motor which port it belongs to.
        // We have already "decided" that in the constants class:
        rightFront = new TalonFX(motorsIds[0]);
        rightRear = new TalonFX(motorsIds[1]);
        leftFront = new TalonFX(motorsIds[2]);
        leftRear = new TalonFX(motorsIds[3]);
        // gyro = new PigeonIMU(Constants.PORT_NUMBER_FRONTRIGHT);
        // since each motor set is on different sides of the chassi, we must invert
        // their motor input(?).
        // because to one side, 1 == -1 to the other (rolling to the right or to the
        // left):
        leftFront.setInverted(Constants.FRONTLEFT_INVERTED);
        leftRear.setInverted(Constants.REARLEFT_INVERTED);
        rightFront.setInverted(Constants.FRONTRIGHT_INVERTED);
        leftRear.setInverted(Constants.REARRIGHT_INVERTED);
        // as to not waste space(?) we "tell" the rear motors to follow the front one's
        // actions:
        rightRear.follow(this.rightFront);
        leftRear.follow(this.leftFront);
    }

    public void setPower(double leftPower, double rightPower) {
        rightFront.set(ControlMode.PercentOutput, rightPower);
        leftFront.set(ControlMode.PercentOutput, leftPower);
    }

    // public PigeonIMU getGyro(){
    // return gyro;
    // }
}
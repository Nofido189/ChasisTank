// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;
import frc.robot.Utils;

public class MoveByDistance extends CommandBase {
    private Chassis chassis;
    private double power;
    private double wantedDistance;
    private double originalGyroAngle;

    public MoveByDistance(Chassis chassis, double power, double wantedDistance) {
        this.chassis = chassis;
        this.power = power;
        this.wantedDistance = wantedDistance;
        chassis.setAngleZero();
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        this.originalGyroAngle = chassis.getAngle();
    }

    @Override
    public void execute() {
        if (chassis.getAngle() >= (originalGyroAngle + Constants.ANGLE_LIMIT)) {
            chassis.setPower(power - (power * Constants.MODERATOR), power + (power * Constants.MODERATOR));
        }
        else if (chassis.getAngle() <= (originalGyroAngle - Constants.ANGLE_LIMIT)) {
            chassis.setPower(power + (power * Constants.MODERATOR), power - (power * Constants.MODERATOR));
        }
        else
            chassis.setPower(power, power);
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0, 0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if (Utils.getPositionOfRobotInMeters(chassis.getLeftPosition() + chassis.getRightPosition()) >= wantedDistance)
            return true;
        else
            return false;
    }
}

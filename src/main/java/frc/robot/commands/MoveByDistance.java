// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;

public class MoveByDistance extends CommandBase {
    private Chassis chassis;
    private double power;
    private double wantedDistance;
    private double distance;
    private double gyroAngle;
    
    public MoveByDistance(Chassis chassis, double power, double wantedDistance){
        this.chassis = chassis;
        this.power = power;
        this.wantedDistance = wantedDistance;
        this.gyroAngle = chassis.getAngle().getFusedHeading();
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        chassis.setPower(power, power);
        this.distance = 0; //probably shouldnt be a field, but didnt know how to reach it from execute otherwise
    }

    @Override
    public void execute() {
        double pulse = ((chassis.getLeftPosition()+chassis.getRightPosition())/2)/ Constants.PULSE_PER_METER;
        this.distance = this.distance + pulse;
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        //אנחנו רוצים שזה יפסיק אם זה סוטה/לא ישר? או שסתם רק רוצים לדעת *אם* זה ישר או לא
        if((distance >= wantedDistance) || (chassis.getAngle() != this.gyroAngle)) 
            return true;
        else
            return false;
    }
}

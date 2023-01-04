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
    private double originalGyroAngle;
    
    public MoveByDistance(Chassis chassis, double power, double wantedDistance){
        this.chassis = chassis;
        this.power = power;
        this.wantedDistance = wantedDistance;
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        chassis.setPower(power, power);
        this.distance = 0; //probably shouldnt be a field, but didnt know how to reach it from execute otherwise
        this.originalGyroAngle = chassis.getAngle();
    }

    @Override
    public void execute() {
        double movedDistanceInMeters =((chassis.getLeftPosition()+chassis.getRightPosition())/2)/ Constants.PULSE_PER_METER;
        // Calculated average position (which is also somehow == pulses) and divided it by ppm; which gives us the distance we've made so far
        this.distance = this.distance + movedDistanceInMeters;
        if(chassis.getAngle() != originalGyroAngle){
            
        }
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        if(distance >= wantedDistance) 
            return true;
        else
            return false;
    }
}

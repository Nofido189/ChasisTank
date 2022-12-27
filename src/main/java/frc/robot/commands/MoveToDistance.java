// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.sensors.PigeonIMU;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Chassis;

public class MoveToDistance extends CommandBase {
    private Chassis chassis;
    private double power;
    private double distance;
    private PigeonIMU gyroAngle;
    
    public MoveToDistance(Chassis chassis, double power){
        this.chassis = chassis;
        this.power = power;
        this.distance = 0;
        this.gyroAngle = chassis.getGyro();
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        chassis.setPower(power, power);
    }

    @Override
    public void execute() {
        double pulsePerMeter = (Constants.GEAR_RATIO*Constants.PULSE_PER_ROTATION)/Constants.PERIMETER;
        double pulse = (chassis.getAverageLeftPosition()+chassis.getAverageRightPosition())/2;
        this.distance = this.distance +(pulse/pulsePerMeter);
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        //אנחנו רוצים שזה יפסיק אם זה סוטה/לא ישר? או שסתם רק רוצים לדעת *אם* זה ישר או לא
        if((this.distance == 3.5) || (chassis.getGyro() != this.gyroAngle)) 
            return true;
        else
            return false;
    }
}

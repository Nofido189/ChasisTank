// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.Util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class MoveToDistance extends CommandBase {
    private Chassis chassis;
    private double power;

    
    public MoveToDistance(Chassis chassis, double power){
        this.chassis = chassis;
        this.power = power;
        addRequirements(chassis);
    }

    @Override
    public void initialize() {
        chassis.setPower(power, power);
    }

    @Override
    public void execute() {
        //אני יודעת שכאן צריך כל הזמן לקבל את הדיסטנס/מיקום
        //אבל אני לא יודעת איך עושים את זה
        //ניסיתי להסתכל בקוד של נויה אבל הסתבכתי
        //בנוסף, גם לא הבנתי מה ג'יירו עושה
    }

    @Override
    public void end(boolean interrupted) {
        chassis.setPower(0,0);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished(double distance, double wantedDistance) {
        if(distance == wantedDistance)
            return true;
        else
            return false;
    }
}

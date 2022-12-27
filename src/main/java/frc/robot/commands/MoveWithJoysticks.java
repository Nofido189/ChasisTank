// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Utils;
import frc.robot.subsystems.Chassis;

public class MoveWithJoysticks extends CommandBase {
    /** Creates a new MoveWithConstantPower. */
    private Chassis chassis;
    private Joystick leftJoystick;
    private Joystick rightJoystick;

    public MoveWithJoysticks(Joystick leftJoystick, Joystick rightJoystick, Chassis chassis) {
        // Use addRequirements() here to declare subsystem dependencies.
        this.leftJoystick = leftJoystick;
        this.rightJoystick = rightJoystick;
        this.chassis = chassis;
        // this.power מתייחס לשדה
        // הפוואר השני מתייחס לפוואר שאנחנו נקבל
        // this. תמיד יתייחס לשדה
        addRequirements(chassis);
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double leftValue = Utils.reduceJoystickError(leftJoystick.getY());
        double rightValue = Utils.reduceJoystickError(rightJoystick.getY());
        double leftPower = Utils.joystickValue2Power(leftValue);
        double rightPower = Utils.joystickValue2Power(rightValue);
        chassis.setPower(leftPower, rightPower);
    }
    

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) { //end == disabled
        chassis.setPower(0, 0);//disable already does this, but this is best practice
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }
}

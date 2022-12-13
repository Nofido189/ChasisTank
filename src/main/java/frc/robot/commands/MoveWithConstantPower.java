// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Chassis;

public class MoveWithConstantPower extends CommandBase {
  /** Creates a new MoveWithConstantPower. */
  private double power;//שדה field
  private Chassis chassis;
  

  public MoveWithConstantPower(double power, Chassis chassis) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.power = power;
    this.chassis = chassis;//this.power מתייחס לשדה
    //הפוואר השני מתייחס לפוואר שאנחנו נקבל
    //this. תמיד יתייחס לשדה
    addRequirements(chassis);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    chassis.setPower(power,power);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    chassis.setPower(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

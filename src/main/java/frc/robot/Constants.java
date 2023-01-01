// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */

//Static means anyone can access
public final class Constants {
    public static final int PORT_NUMBER_FRONTRIGHT = 1;
    public static final int PORT_NUMBER_REARRIGHT = 2;
    public static final int PORT_NUMBER_FRONTLEFT = 3;
    public static final int PORT_NUMBER_REARLEFT = 4;
    public static final int PORT_NUMBER_GYRO = 14;
    public static final boolean FRONTRIGHT_INVERTED = true; //??
    public static final boolean REARRIGHT_INVERTED = true;
    public static final boolean FRONTLEFT_INVERTED = false;
    public static final boolean REARLEFT_INVERTED = false;
    public static final int LEFT_JOYSTICKS = 0;
    public static final int RIGHT_JOYSTICK = 1;
    public static final double INCH = 0.0254;
    public static final double DIAM = 6*INCH;
    public static final double PERIMETER = DIAM*Math.PI; //היקף
    public static final int GEAR_RATIO = 12;
    public static final int PULSE_PER_ROTATION = 2048;
    public static final double PULSE_PER_METER = (GEAR_RATIO*PULSE_PER_ROTATION)/PERIMETER;
}

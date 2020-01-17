/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Add your docs here.
 */
public class MotorShifter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //private final DoubleSolenoid MotorShifter = RobotMap.motorShifter;
  private final Solenoid MotorShifter = RobotMap.motorShifter;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void highGear(){
    MotorShifter.set(false);
  }

  public void lowGear(){
    MotorShifter.set(true);
  }

  public void stopShifter(){
    //MotorShifter.set(Value.kOff);
  }

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //driveTrain
  public static WPI_TalonSRX leftMaster;
  public static WPI_TalonSRX leftSlave0;
  public static WPI_TalonSRX leftSlave1;

  public static WPI_TalonSRX rightMaster;
  public static WPI_TalonSRX rightSlave0;
  public static WPI_TalonSRX rightSlave1;

  public static Solenoid motorShifter;

  public static PigeonIMU pigeon;

  //turret
  public static WPI_TalonSRX turretMotor;
  public static WPI_TalonSRX turretMotor0;

  //intake
  public static WPI_TalonSRX intakeMotor;

  //sensors and misc devices
  public static Compressor compressor;

  public static void init(){

    //driveTrain device initialization
    leftMaster = new WPI_TalonSRX(1);
    leftSlave0 = new WPI_TalonSRX(2);
    leftSlave1 = new WPI_TalonSRX(3);
    
    rightMaster = new WPI_TalonSRX(4);
    rightSlave0 = new WPI_TalonSRX(5);
    rightSlave1 = new WPI_TalonSRX(6);
    
    motorShifter = new Solenoid(0);

    pigeon = new PigeonIMU(rightSlave0);
    
    //turret device initialization
    turretMotor = new WPI_TalonSRX(7);
    turretMotor0 = new WPI_TalonSRX(8);

    //intake device initialization
    intakeMotor = new WPI_TalonSRX(9);


    //reset talons
    leftMaster.configFactoryDefault();
    leftSlave0.configFactoryDefault();
    leftSlave1.configFactoryDefault();
    
    rightMaster.configFactoryDefault();
    rightSlave0.configFactoryDefault();
    rightSlave1.configFactoryDefault();
    
    //setup encoders
    leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
    rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);

    //zero encoders
    leftMaster.setSelectedSensorPosition(0, 0, 10);
    rightMaster.setSelectedSensorPosition(0, 0, 10); 

    //set talon direction
    leftMaster.setInverted(false);
    leftSlave0.setInverted(false);
    leftSlave1.setInverted(false);

    rightMaster.setInverted(false);
    rightSlave0.setInverted(false);
    rightSlave1.setInverted(false);

    //set encoder direction
    leftMaster.setSensorPhase(false);
    rightMaster.setSensorPhase(true);

    //set slaves to follow
    leftSlave0.follow(leftMaster);
    leftSlave1.follow(leftMaster);
    rightSlave0.follow(rightMaster);
    rightSlave1.follow(rightMaster);

    
    //Coast or Brake
    leftMaster.setNeutralMode(NeutralMode.Brake);
    leftSlave0.setNeutralMode(NeutralMode.Brake);
    leftSlave1.setNeutralMode(NeutralMode.Brake);

    rightMaster.setNeutralMode(NeutralMode.Brake);
    rightSlave0.setNeutralMode(NeutralMode.Brake);
    rightSlave1.setNeutralMode(NeutralMode.Brake);
    
    //sensors and misc device initialization

    compressor = new Compressor(0);
    
  }
}

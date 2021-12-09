// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.MedianFilter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Droop extends SubsystemBase {
  
//DRIVE SUBSYSTEM

  private final WPI_TalonSRX _front_left_motor;
  private final WPI_TalonSRX _front_right_motor;
  private final WPI_TalonSRX _back_right_motor;
  private final WPI_TalonSRX _back_left_motor;

  private final DifferentialDrive _drive;

  private final AnalogGyro _gyro;


  public Droop() {
    _front_left_motor = new WPI_TalonSRX(DriveConstants.FRONT_LEFT);
    _front_right_motor = new WPI_TalonSRX(DriveConstants.FRONT_RIGHT);
    _back_right_motor = new WPI_TalonSRX(DriveConstants.BACK_RIGHT);
    _back_left_motor = new WPI_TalonSRX(DriveConstants.BACK_LEFT);
    
    _drive = new DifferentialDrive(_front_left_motor, _front_right_motor);

    _gyro = new AnalogGyro(DriveConstants.GYRO_PORT);
    _gyro.setSensitivity(DriveConstants.K_GYRO_REVOLUTION);

    _back_left_motor.follow(_front_left_motor);
    _back_right_motor.follow(_front_right_motor);

    _front_left_motor.setInverted(false);
    _back_left_motor.setInverted(InvertType.FollowMaster  );

    _front_right_motor.setInverted(false);
    _back_right_motor.setInverted(InvertType.FollowMaster);

    _drive.setRightSideInverted(true);
  }

public void ArcadeDrive(double _speed, double _rot) {
  _speed *= -1;
  _drive.arcadeDrive(_speed, _rot);
}

public double getGyroAngle() {
  return _gyro.getAngle();
}

public void StopDrive() {
  _drive.stopMotor();
}

  @Override
  public void periodic() {

    double angle = _gyro.getAngle();

    //System.out.println(angle);

  }
}

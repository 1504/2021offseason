// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Droop;

public class Droom extends CommandBase {
  
  private final Droop k_drive;
  private final DoubleSupplier k_rot;
  private final DoubleSupplier k_speed;

  public Droom(Droop droop, DoubleSupplier speed, DoubleSupplier rot) {
    k_drive = droop;
    k_rot = rot;
    k_speed = speed;
    addRequirements(droop);
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    k_drive.ArcadeDrive(k_speed.getAsDouble(), k_rot.getAsDouble());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    k_drive.StopDrive();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auton;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Droop;

public class Croon extends CommandBase {
  /** Cranking 90s */

  private final Droop _drive;
  private Timer _timer;
  private double b_angle;
  private final double t_angle;
  private boolean reached = false;

  public Croon(Droop drive) {
    _drive = drive;
    _timer = new Timer();
    b_angle = _drive.getGyroAngle();
    t_angle = (b_angle + 90) % 360;
    addRequirements(_drive);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    b_angle = _drive.getGyroAngle();
    if(b_angle != t_angle) {
      _drive.ArcadeDrive(0, 0.5);
      reached = false;
    } else {
      reached = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return reached;
  }
}

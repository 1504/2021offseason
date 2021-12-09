// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.IOConstants;
import frc.robot.ControlBoard.ControlBoard;
import frc.robot.commands.Droom;
import frc.robot.subsystems.Droop;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {


  private final Droop k_droop = new Droop();
  
  private final UsbCamera m_frontCamera = CameraServer.getInstance().startAutomaticCapture();

  private final Joystick _joystickOne = new Joystick(1);
  private final Joystick _joystickTwo = new Joystick(2);

  //private final Joystick k_controller = new Joystick(IOConstants.DRIVE_PORT);

  private final ControlBoard k_controller = ControlBoard.getInstance();
  ShuffleboardTab m_tab = Shuffleboard.getTab("Main");

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    //k_droop.setDefaultCommand(new Droom(k_droop, () -> k_controller.getThrottle(),() -> k_controller.getRight()));
    k_droop.setDefaultCommand(new Droom(k_droop, () -> _joystickTwo.getY(), () -> _joystickOne.getX()));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
  */
}

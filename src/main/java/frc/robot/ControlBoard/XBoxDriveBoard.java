package frc.robot.ControlBoard;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import frc.robot.Constants.IOConstants;

public class XBoxDriveBoard implements IDriveBoard {

    private static XBoxDriveBoard _instance = null; 

    private final XboxController _controller;

    public static XBoxDriveBoard getInstance() {
        if (_instance == null) {
            _instance = new XBoxDriveBoard();
        }

        return _instance;
    }

    private XBoxDriveBoard() {
        _controller = new XboxController(IOConstants.DRIVE_PORT);
    }


    @Override
    public double getThrottle() {
        return _controller.getY(Hand.kLeft);
    }

    @Override
    public double getRight() {
        return _controller.getX(Hand.kLeft);
    }

    @Override
    public double getRotation() {
        return _controller.getX(Hand.kRight);
    }
    
}

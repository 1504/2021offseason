package frc.robot.ControlBoard;

import frc.robot.Constants.IOConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.GameConstants;

public class ControlBoard {
    
    private static ControlBoard _instance = null;

    private final IDriveBoard bDriveBoard;

    public static ControlBoard getInstance() {
        if (_instance == null) {
            _instance = new ControlBoard();
        }

        return _instance;
    }

    private ControlBoard() {
        System.out.println("Control Board initialized");
        bDriveBoard = GameConstants.NOMINAL_RUN ? XBoxDriveBoard.getInstance() : DDRDriveBoard.getInstance();
    }


    public double getThrottle() {
        return bDriveBoard.getThrottle();
    }

    public double getRight() {
        return bDriveBoard.getRight();
    }

    public double getRotation() {
        return bDriveBoard.getRotation();
    }

}

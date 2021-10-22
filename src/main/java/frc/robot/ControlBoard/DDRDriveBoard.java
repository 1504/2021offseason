package frc.robot.ControlBoard;

import frc.robot.Constants.IOConstants;

public class DDRDriveBoard implements IDriveBoard {

    private static DDRDriveBoard _instance = null;

    private final DDR _dancePad;

    public static DDRDriveBoard getInstance() {
        if (_instance == null) {
            _instance = new DDRDriveBoard();
        }

        return _instance;
    }

    private DDRDriveBoard() {
        _dancePad = new DDR(IOConstants.DRIVE_PORT);
    }

	@Override
	public double getThrottle() {
		return ((_dancePad.getUp() ? 1.0f : 0.0f) + (_dancePad.getDown() ? -1.0f : 0.0f));
	}

	@Override
	public double getRight() {
		return ((_dancePad.getRight() ? 1.0f : 0.0f) + (_dancePad.getLeft() ? -1.0f : 0.0f));
	}

	@Override
	public double getRotation() {
		return 0;
	}

}

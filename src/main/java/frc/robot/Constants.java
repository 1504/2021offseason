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
public final class Constants {
    public static final class DriveConstants {
        public static final int FRONT_LEFT = 60;
        public static final int FRONT_RIGHT = 51;
        public static final int BACK_RIGHT = 50;
        public static final int BACK_LEFT = 40;

        public static final int GYRO_PORT = 0;
        public static final double K_GYRO_REVOLUTION = 0.0128;
        public static final double K_GYRO_TURNING = 0.005;
        public static final int ULTRON_PORT = 1;
        public static final double K_CRANK_SPEED = 0.1;

        //public final static byte MPU6050_ADDRESS = 0x68;
    }
    public static final class IOConstants {
        public static final int DRIVE_PORT = 0;

    }
    public static final class PneumaticsConstants {
        public static final int SOLOMON_PORT = 7;
    }
    public static final class GameConstants {
        //determines whether control board should be initialized with ddr pad or xbox controller
        public static final boolean NOMINAL_RUN = true;
    }
}

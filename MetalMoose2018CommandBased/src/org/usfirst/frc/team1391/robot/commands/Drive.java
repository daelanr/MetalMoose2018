package org.usfirst.frc.team1391.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1391.robot.OI;
import org.usfirst.frc.team1391.robot.Robot;
import org.usfirst.frc.team1391.robot.RobotMap;

/**
 * Drives the robot.
 */
public class Drive extends Command {

    public Drive() {
    	requires(Robot.kDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Repeatedly adjust the speed of the drive train from the reading of the joystick axes
    protected void execute() {
    	switch (RobotMap.driveMode) {
    		//Arcade drive using the reading from the main joystick of the Logitech controller
    		case 0:
            	//The '-' is because pulling the joystick forward is -1 and we want it to be +1 (and vice versa)
            	//The X axis is fine, since the rotation is clockwise and rightmost value of the x axis is +1
        		Robot.kDriveTrain.arcadeDrive(-OI.stick.getY(), OI.stick.getX());
        		break;
        	//Tank drive using both joysticks from the Logitech controller
    		case 1:
    			//Reading the Y axes of the joysticks on the Logitech controller
        		//The '-' is for the same reason as the '-' on the arcade drive
            	Robot.kDriveTrain.tankDrive(
            			-OI.stick.getRawAxis(RobotMap.tankDriveLeftStickYAxisPort), 
            			-OI.stick.getRawAxis(RobotMap.tankDriveRightStickYAxisPort));
        		break;
        	//Arcade drive using the Y and the rotation (as X) axis of the Logitech joystick
    		case 2:
    			Robot.kDriveTrain.arcadeDrive(-OI.stick.getY(), OI.stick.getRawAxis(RobotMap.arcadeDriveRotationAxisPort));
    			break;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}

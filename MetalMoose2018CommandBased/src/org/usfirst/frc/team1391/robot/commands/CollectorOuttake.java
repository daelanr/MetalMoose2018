package org.usfirst.frc.team1391.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1391.robot.OI;
import org.usfirst.frc.team1391.robot.Robot;
import org.usfirst.frc.team1391.robot.RobotMap;

/**
 * Drives the robot.
 */
public class CollectorOuttake extends Command {

	public CollectorOuttake() {
		requires(Robot.myCollector);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	protected void execute() {
		Robot.myCollector.setSpeed(RobotMap.collectorIntakeSpeed);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
}

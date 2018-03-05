package org.usfirst.frc.team1391.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1391.robot.Robot;
import org.usfirst.frc.team1391.robot.RobotMap;

/**
 * Moves the elevator to a certain position.
 *
 * It achieves this by squishing and shifting the throttle function from the starting point to the ending point.
 */
public class ElevatorToHeight extends Command {
    // The starting and the ending position of the elevator.
    double startPosition;
    double endPosition;

    // The shift and the coefficient to properly squish and move the function.
    double shift;
    double coefficient;

    public ElevatorToHeight(double endPosition) {
        requires(Robot.myElevator);

        this.endPosition = endPosition;
    }

    protected void initialize() {
        startPosition = Robot.myElevator.elevatorEncoder.getDistance();

        shift = (startPosition + endPosition) / 2 - RobotMap.elevatorMaximumDistance / 2;
        coefficient = Math.abs(endPosition - startPosition) / RobotMap.elevatorMaximumDistance;
    }

    protected void execute() {
        double currentPosition = Robot.myElevator.elevatorEncoder.getDistance();

        // We are pretty much mapping the readings of the current position onto the full domain of the throttle function
        Robot.myElevator.setAbsoluteSpeed(Robot.myElevator.getThrottledSpeed(currentPosition / coefficient - shift));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}

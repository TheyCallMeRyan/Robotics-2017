package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;
import org.usfirst.frc.team3591.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousDriveCommand extends Command {
	public int clicks;
	public String direction;
	public boolean finished = false;
	public int inches;
	public Ultrasonic distanceSensor = new Ultrasonic(RobotMap.DISTANCE_SENSOR_ID, RobotMap.DISTANCE_SENSOR_ID);
    public AutonomousDriveCommand(int clicks, String direction, int inches) {
        this.clicks = clicks;
        this.direction = direction;
        this.inches = inches;
        distanceSensor.setAutomaticMode(true);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double averageClicks = (Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.FRONT_LEFT)) 
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.FRONT_RIGHT))
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.BACK_LEFT))
      			+ Math.abs(Robot.driveSubsystem.getEncPosition(RobotMap.BACK_RIGHT))) / 4.0;
    	
    	double currentDistance = distanceSensor.getRangeInches();
    	
    	if(clicks != 1 && clicks != -1 && averageClicks > Math.abs(clicks)){
    		Robot.driveSubsystem.setMotors(0, 0, 0);
    		finished = true;
    	}else if(inches != 0 && currentDistance < inches + .5 && currentDistance > inches - .5){
    		Robot.driveSubsystem.setMotors(0, 0, 0);
    		finished = true;
    	}
    	
    	if(!finished){
    		switch(direction){
    		case "X":
    			Robot.driveSubsystem.setMotors(.5*clicks/Math.abs(clicks), 0, 0);
    		case "Y":
    			Robot.driveSubsystem.setMotors(0, .5*clicks/Math.abs(clicks), 0);
    		case "Z":
    			Robot.driveSubsystem.setMotors(0, 0, .5*clicks/Math.abs(clicks));
    		}
    	}
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    protected void interrupted() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }
}

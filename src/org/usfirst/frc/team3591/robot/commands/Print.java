package org.usfirst.frc.team3591.robot.commands;

import javax.swing.JFrame;

import org.usfirst.frc.team3591.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Print extends Command {
	private int num;
    public Print(int num) {
    	System.out.println(num);
    	this.num = num;
    	Robot.oi.startPlace = num;
    	if(num == 1){
    		Robot.driveSubsystem.setMotors(0, .25, 0);
    	}else if(num == 2){
    		Robot.driveSubsystem.setMotors(0, -.25, 0);
    	}else if(num == 3){
    		Robot.driveSubsystem.setMotors(0, 0, .25);
    	}else{
    		System.out.println("This is for Alex");
    	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(num == 1){
    		Robot.driveSubsystem.setMotors(0, .25, 0);
    	}else if(num == 2){
    		Robot.driveSubsystem.setMotors(0, -.25, 0);
    	}else if(num == 3){
    		Robot.driveSubsystem.setMotors(0, 0, .25);
    	}else{
    		System.out.println("This is for Alex");
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }
}

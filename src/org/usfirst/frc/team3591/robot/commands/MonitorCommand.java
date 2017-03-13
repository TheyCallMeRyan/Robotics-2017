package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MonitorCommand extends Command {

	
	public void putEncoderVelocity(){
		SmartDashboard.putNumber("Front Left Encoder Velocity", Robot.driveSubsystem.frontLeft.getEncVelocity());
		SmartDashboard.putNumber("Front Right Encoder Velocity", Robot.driveSubsystem.frontRight.getEncVelocity());
		SmartDashboard.putNumber("Back Left Encoder Velocity", Robot.driveSubsystem.backLeft.getEncVelocity());
		SmartDashboard.putNumber("Back Right Encoder Velocity", Robot.driveSubsystem.backRight.getEncVelocity());
	}
	
	public void putEncoderPosition(){
		SmartDashboard.putNumber("Front Left Encoder Position", Robot.driveSubsystem.frontLeft.getEncPosition());
		SmartDashboard.putNumber("Front Right Encoder Position", Robot.driveSubsystem.frontRight.getEncPosition());
		SmartDashboard.putNumber("Back Left Encoder Position", Robot.driveSubsystem.backLeft.getEncPosition());
		SmartDashboard.putNumber("Back Right Encoder Position", Robot.driveSubsystem.backRight.getEncPosition());
	}
	
	public void putTalonVoltage(){
		SmartDashboard.putNumber("Front Left Talon Voltage", Robot.driveSubsystem.frontLeft.getOutputVoltage());
		SmartDashboard.putNumber("Front Right Talon Voltage", Robot.driveSubsystem.frontRight.getOutputVoltage());
		SmartDashboard.putNumber("Back Left Talon Voltage", Robot.driveSubsystem.backLeft.getOutputVoltage());
		SmartDashboard.putNumber("Back Right Talon Voltage", Robot.driveSubsystem.backRight.getOutputVoltage());
		SmartDashboard.putNumber("Left Climb Talon Voltage", Robot.ropeSubsystem.leftMotor.getOutputVoltage());
		SmartDashboard.putNumber("Right Climb Talon Voltage", Robot.ropeSubsystem.rightMotor.getOutputVoltage());
	}
	
	public void putTalonAmperage(){
		SmartDashboard.putNumber("Front Left Talon Amperage", Robot.driveSubsystem.frontLeft.getOutputCurrent());
		SmartDashboard.putNumber("Front Right Talon Amperage", Robot.driveSubsystem.frontRight.getOutputCurrent());
		SmartDashboard.putNumber("Back Left Talon Amperage", Robot.driveSubsystem.backLeft.getOutputCurrent());
		SmartDashboard.putNumber("Back Right Talon Amperage", Robot.driveSubsystem.backRight.getOutputCurrent());
		SmartDashboard.putNumber("Left Climb Talon Amperage", Robot.ropeSubsystem.leftMotor.getOutputCurrent());
		SmartDashboard.putNumber("Right Climb Talon Amperage", Robot.ropeSubsystem.rightMotor.getOutputCurrent());
	}
	
    public MonitorCommand() {
        
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	putEncoderVelocity();
    	putEncoderPosition();
    	putTalonVoltage();
    	putTalonAmperage();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }
    
    protected void interrupted() {
    }
}

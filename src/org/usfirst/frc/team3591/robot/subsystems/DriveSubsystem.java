package org.usfirst.frc.team3591.robot.subsystems;

import org.usfirst.frc.team3591.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public CANTalon frontLeft;
    public CANTalon frontRight;
    public CANTalon backLeft;
    public CANTalon backRight;
    public RobotDrive robotDrive;
    
    private double p = .1;
    private double i = 0;
    private double d = .05;
    private double f = 0;
    private double ramprate = 48;
    
    public DriveSubsystem(){
    	frontLeft=new CANTalon(RobotMap.FRONT_LEFT);
    	frontRight=new CANTalon(RobotMap.FRONT_RIGHT);
    	backLeft=new CANTalon(RobotMap.BACK_LEFT);
    	backRight=new CANTalon(RobotMap.BACK_RIGHT);
    	robotDrive=new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		frontLeft.setPID(p, i, d, f, 0, ramprate, 0);
		backLeft.setPID(p, i, d, f, 0, ramprate, 0);
		frontRight.setPID(p, i, d, f, 0, ramprate, 0);
		backRight.setPID(p, i, d, f, 0, ramprate, 0);
    }
    
    public void setMotors(double x, double y, double z){
    	robotDrive.mecanumDrive_Cartesian(x, y, z, 0);
    }
    
    public int getEncPosition(int num){
    	switch(num){
    	case RobotMap.FRONT_LEFT:
    		return frontLeft.getEncPosition();
    	case RobotMap.FRONT_RIGHT:
    		return frontRight.getEncPosition();
    	case RobotMap.BACK_LEFT:
    		return backLeft.getEncPosition();
    	case RobotMap.BACK_RIGHT:
    		return backRight.getEncPosition();
    	default:
    		return 0;
    	}
    }
    
}


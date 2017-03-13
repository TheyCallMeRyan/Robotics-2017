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
    
    public DriveSubsystem(){
    	frontLeft=new CANTalon(RobotMap.FRONT_LEFT);
    	frontRight=new CANTalon(RobotMap.FRONT_RIGHT);
    	backLeft=new CANTalon(RobotMap.BACK_LEFT);
    	backRight=new CANTalon(RobotMap.BACK_RIGHT);
    	robotDrive=new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    	
    	robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
		
		/*frontLeft.setPID(0, 0, 0, 0, 0, 0, 0);
		backLeft.setPID(0, 0, 0, 0, 0, 0, 0);
		frontRight.setPID(0, 0, 0, 0, 0, 0, 0);
		backRight.setPID(0, 0, 0, 0, 0, 0, 0);*/
    }
    
    public void setMotors(double x, double y, double z){
    	robotDrive.mecanumDrive_Cartesian(x, y, z, 0);
    }
    
}


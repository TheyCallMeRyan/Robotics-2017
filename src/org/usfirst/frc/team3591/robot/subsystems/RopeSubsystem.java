package org.usfirst.frc.team3591.robot.subsystems;

import org.usfirst.frc.team3591.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RopeSubsystem extends Subsystem {

	public CANTalon leftMotor;
	public CANTalon rightMotor;
	
	public RopeSubsystem(){
		leftMotor=new CANTalon(RobotMap.ROPE_LEFT);
		rightMotor=new CANTalon(RobotMap.ROPE_RIGHT);
	}
	
	public void climb(double movement){
		leftMotor.set(movement);
		rightMotor.set(-movement);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}


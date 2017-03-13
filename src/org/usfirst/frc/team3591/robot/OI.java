package org.usfirst.frc.team3591.robot;

import org.usfirst.frc.team3591.robot.commands.RopeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick driveStick;
	public Button ropeButton;
	
	public OI(){
		driveStick = new Joystick(RobotMap.DRIVESTICK_ID);
		ropeButton=new JoystickButton(driveStick,RobotMap.ROPE_BUTTON);
		ropeButton.whileHeld(new RopeCommand(1));
	}
	
	public double getDriveStick(String axis){
		double speed=0;
		double throttleMultiplier=(1-driveStick.getThrottle())/2;
		
		if(axis.equals("X")){
			speed=-driveStick.getX();
		}else if(axis.equals("Y")){
			speed=driveStick.getY();
		}else if(axis.equals("Z")){
			speed=driveStick.getZ();
		}
		
		speed*=throttleMultiplier;
		
		if(speed<.1 && speed>-.1){
			speed=0;
		}
		return speed;
	}
	
}

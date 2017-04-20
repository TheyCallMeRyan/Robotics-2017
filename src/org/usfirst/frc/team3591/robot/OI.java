package org.usfirst.frc.team3591.robot;

import org.usfirst.frc.team3591.robot.commands.Print;
import org.usfirst.frc.team3591.robot.commands.RopeCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick driveStick = new Joystick(RobotMap.DRIVESTICK_ID);
	public Button ropeUpButton = new JoystickButton(driveStick, RobotMap.ROPE_UP_BUTTON);
	public Button ropeDownButton = new JoystickButton(driveStick, RobotMap.ROPE_DOWN_BUTTON);
	public Button leftButton = new JoystickButton(driveStick, 3);
	public Button rightButton = new JoystickButton(driveStick, 4);
	public Button middleButton = new JoystickButton(driveStick, 5);
	public int startPlace = 0;
	
	public OI(){
		ropeUpButton.whileHeld(new RopeCommand(1));
		ropeDownButton.whileHeld(new RopeCommand(-1));
	}
	
	public int getStartPlace(){
		return startPlace;
		/*
		if(leftButton.get() && !middleButton.get() && !rightButton.get()){
			return 1; //Left is 1
		}else if(!leftButton.get() && middleButton.get() && !rightButton.get()){
			return 2; //Middle is 2
		}else if(!leftButton.get() && !middleButton.get() && rightButton.get()){
			return 3; //Right is 3
		}
		return 2;
		*/
	}
	
	public double getDriveStick(String axis){
		double speed=0;
		double throttleMultiplier=(1-driveStick.getThrottle())/2;
		
		if(axis.equals("X")){
			speed=driveStick.getX();
		}else if(axis.equals("Y")){
			speed=driveStick.getY();
		}else if(axis.equals("Z")){
			speed=driveStick.getZ();
		}
		
		if(speed<.4 && speed>-.4){
			speed=0;
		}
		
		speed*=throttleMultiplier;
		
		return speed;
	}
	
}

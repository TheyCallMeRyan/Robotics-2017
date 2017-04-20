package org.usfirst.frc.team3591.robot.commands;

import org.usfirst.frc.team3591.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
	int waitTime = 1000;
    public AutonomousCommandGroup() throws InterruptedException {
    	System.out.println("THIS IS STARTING!");
    	int startPosition = Robot.oi.getStartPlace();
    	Timer timer = new Timer();
    	System.out.println(startPosition);
    	switch(startPosition){
    	case 1: //Left position
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		addSequential(new AutonomousDriveCommand(0, "Z", 0));
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		timer.wait(waitTime);
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		addSequential(new AutonomousDriveCommand(0, "Z", 0));
    		addSequential(new AutonomousDriveCommand(0, "X", 0));
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));  
    		break;
    	case 2: //Middle position
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		timer.wait(waitTime);
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		addSequential(new AutonomousDriveCommand(0, "X", 0));
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		break;
    	case 3: //Right position
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		addSequential(new AutonomousDriveCommand(0, "Z", 0));
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		timer.wait(waitTime);
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		addSequential(new AutonomousDriveCommand(0, "Z", 0));
    		addSequential(new AutonomousDriveCommand(0, "X", 0));
    		addSequential(new AutonomousDriveCommand(0, "Y", 0));
    		break;
    	default:
    		System.out.println("Either no starting position or multiple");
    	}
    }
}

package commands.auto.defenses;

import commands.LowerArmCommand;
import commands.RaiseArmCommand;
import commands.auto.DriveDistanceCommand;
import commands.auto.DriveToProximity;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossChavelDeFriseCommand extends CommandGroup{

	public CrossChavelDeFriseCommand() {
		// raise the arm
		addSequential(new RaiseArmCommand());
		
		// drive to platform
		addSequential(new DriveToProximity());
		
		// drive forward 1'
		addSequential(new DriveDistanceCommand(12, 1.0));
		
		// lower the arm
		addSequential(new LowerArmCommand());

		// drive forward and raise the arm
		addSequential(new DriveDistanceCommand(50, 1.0));
		addParallel(new RaiseArmCommand());
	}
	
}

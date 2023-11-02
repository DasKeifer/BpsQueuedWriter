package bps_queued_writer.compiler;


import compiler.Instruction;
import compiler.InstructionSetParser;

import java.util.List;

import compiler.CompilerUtils;

public class BpsInstructionSetParser implements InstructionSetParser
{		
	@Override
	public List<String> getSupportedInstructions() 
	{
		return List.of("bps_sc", "bps_tc");
	}
	
	@Override
	public Instruction parseInstruction(String instruction, String args, String rootSegment)
	{
		String[] splitArgs = CompilerUtils.splitArgs(args);
		switch (instruction)
		{
			case "bps_sc":
			case "bps_tc":
				return SourceTargetCopyInstruct.create(instruction, splitArgs);

			default:
				throw new UnsupportedOperationException("Unrecognized instruction: " + instruction);
		}
	}
}

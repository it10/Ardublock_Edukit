package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class ServoEdukit extends TranslatorBlock
{

	public ServoEdukit(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		
		String pinNumber = translatorBlock.toCode();
		if(pinNumber.equalsIgnoreCase("1")) {
			pinNumber = "10";
		}else {
			pinNumber = "11";
		}
		
		String servoName = "servo_pin_" + pinNumber;
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		
		String ret = servoName + ".write( " + translatorBlock.toCode() + " );\n";
		translator.addHeaderFile("Servo.h");
		translator.addDefinitionCommand("Servo " + servoName + ";");
		translator.addSetupCommand(servoName + ".attach(" + pinNumber + ");");
		return ret;
	}

}

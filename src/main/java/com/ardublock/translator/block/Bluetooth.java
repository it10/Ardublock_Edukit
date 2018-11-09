package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class Bluetooth extends TranslatorBlock
{

	public Bluetooth(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		String setupCode = "Serial.begin(9600);";
		translator.addSetupCommand(setupCode);
		
		
		
		
		String ret = "Serial.print(\"valor :\");\n";
		String ret1 = "Serial.print(\" \");\n";
		String ret2 = "Serial.print(analogRead(A7));\n";
		String ret3 = "Serial.print(\" \");";
		String ret4 = "Serial.println();";
		return ret + ret1 + ret2 + ret3 + ret4 ;
	}

}

package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class Temperatura_Valor extends TranslatorBlock
{

	public Temperatura_Valor(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		String setupCode = "Serial.begin(9600);";
		translator.addSetupCommand(setupCode);
		
		
		
		
		String ret = "Serial.print(\"Temperatura :\");\n";
		String ret1 = "Serial.print(\" \");\n";
		String ret2 = "int t =analogRead(A6);\n";
		String ret3 = "Serial.print((5*t*100/1024));\n";
		String ret4 = "Serial.print(\" \");";
		String ret5 = "Serial.println();";
		return ret + ret1 + ret2 + ret3 + ret4 + ret5;
	}

}

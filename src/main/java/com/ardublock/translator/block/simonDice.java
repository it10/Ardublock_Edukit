package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class simonDice extends TranslatorBlock
{

	public simonDice(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		String setupCode = "pinMode( 2 , OUTPUT); \n pinMode( 4 , OUTPUT); \n pinMode( 8 , OUTPUT); \n";
		String setupCode1 = "pinMode( 10 , INPUT); \n pinMode( 11 , INPUT); \n pinMode( 12 , INPUT); \n";
		
		translator.addSetupCommand(setupCode+setupCode1);
		  String ret = "";
		
		  //ret = ret + "noTone(13);\n";
		  ret = ret + "if (( (digitalRead(10) ) == ( HIGH ) )) \n";
		  ret = ret + "{ \n";
		  //ret = ret + "tone(13, 800);\n";
		  ret = ret + " digitalWrite(2 , HIGH); \n";
		  ret = ret + " delay( 300 );\n"; 
		  ret = ret + " digitalWrite(2 , LOW); \n";
		  ret = ret + "} \n";
		  ret = ret + "if (( ( digitalRead(11) ) == ( HIGH ) )) \n";
		  ret = ret + "{ \n";
		  //ret = ret + "tone(13, 800);\n";
		  ret = ret + " digitalWrite(4 , HIGH);\n";
		  ret = ret + " delay( 300 );\n";
		  ret = ret + " digitalWrite(4 , LOW);\n";
		  ret = ret +"}\n";
		  ret = ret + "if (( (digitalRead(12) ) == ( HIGH ) ))\n";
		  ret = ret + "{\n";
		  //ret = ret + "tone(13, 800);\n";
		  ret = ret + " digitalWrite(8 , HIGH);\n";
		  ret = ret + " delay( 300 );\n";
		  ret = ret + "digitalWrite(8 , LOW);\n";
		  ret = ret+ "}\n";
		
		return ret;
	}

}


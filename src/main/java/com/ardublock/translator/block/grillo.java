package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class grillo extends TranslatorBlock{

	public grillo(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		
		super(blockId, translator, codePrefix , codeSuffix , label );
	}

	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret="tone(8, 440);";
		String ret1="delay( 1000 );";
		String ret2= "noTone(8);";
		String ret3= "delay(1000);";
		return  ret + ret1 + ret2 + ret3;
	}
}


package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;


public class Led_Apagate extends TranslatorBlock
{

	public Led_Apagate(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		
		String pinNumber = translatorBlock.toCode();
		
		if(pinNumber.equalsIgnoreCase("1")) {
			pinNumber = "5";
		}else {
			if(pinNumber.equalsIgnoreCase("2")) {
				pinNumber = "6";
			}else {
				if(pinNumber.equalsIgnoreCase("3")) {
					pinNumber = "7";
				}else {
					pinNumber = "5";
				}
			}
		}
		
		
		String setupCode = "pinMode( "+pinNumber+" , OUTPUT);";
		translator.addSetupCommand(setupCode);
		
		
		
		
		String ret = "digitalWrite( "+pinNumber+" , LOW);";
			
			
		return ret  ;
	}

}

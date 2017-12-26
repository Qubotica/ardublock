package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AnalogInputBlock extends TranslatorBlock
{
	public AnalogInputBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{

        TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
        String portNum = translatorBlock.toCode();
        String ret = "255 - (analogRead(" + portNum + ")/4)";
		return codePrefix + ret + codeSuffix;
	}

}

package com.ardublock.translator.block.adafruit;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Neopixel_pixel_colorRGB  extends TranslatorBlock {

	public Neopixel_pixel_colorRGB (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String Pin ;
			String Pixel_Nb;
			String Red;
			String Blue;
			String Green;


			TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
			Pin = translatorBlock.toCode();
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
			Pixel_Nb = translatorBlock.toCode();
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(3);
			Red = translatorBlock.toCode();
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(2);
			Green = translatorBlock.toCode();
			translatorBlock = this.getRequiredTranslatorBlockAtSocket(4);
			Blue = translatorBlock.toCode();
			
			
			translator.addHeaderFile("Adafruit_NeoPixel.h");
			translator.addDefinitionCommand("Adafruit_NeoPixel strip_pin"+Pin+" = Adafruit_NeoPixel(255,"+ Pin +", NEO_GRB + NEO_KHZ800);");
			translator.addSetupCommand("strip_pin"+Pin+".begin();\n" +
			"strip_pin"+Pin+".show();");


			String ret = "strip_pin"+Pin+".setPixelColor("+Pixel_Nb+","+Green+" ,"+Red+" ,"+Blue+" );\nstrip_pin"+Pin+".show();\n";			
			return codePrefix + ret + codeSuffix;
				
		}
}

package com.ardublock.translator.block.Duinoedu;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class Infrared extends TranslatorBlock {
	public Infrared(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String Pin;
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		Pin = translatorBlock.toCode();
		translator.addHeaderFile("IRremote.h");
		translator.addDefinitionCommand("IRrecv monRecepteur_pin"+Pin+"("+Pin+");\ndecode_results remoto"+Pin+";");
		translator.addDefinitionCommand("int fn_Recepteur_pin"+Pin+" () {\n  if (monRecepteur_pin"+Pin+".decode(&remoto"+Pin+")) monRecepteur_pin"+Pin+".resume();\nreturn remoto"+Pin+".value;\n}");
translator.addSetupCommand("monRecepteur_pin"+Pin+".enableIRIn(); ");

		String ret = "fn_Recepteur_pin"+Pin+" ()";
		return codePrefix + ret + codeSuffix;
	}
}

/*

#include <IRremote.h>

IRrecv monRecepteur_pin11(11);
decode_results remoto11;
int fn_Recepteur_pin11 () {
  if (monRecepteur_pin11.decode(&remoto11)) monRecepteur_pin11.resume();
  return remoto11.value;
}

#include <Qudino.h>

void setup()
{
  pinMode( rojo , OUTPUT);
  monRecepteur_pin11.enableIRIn(); 
}

void loop()
{
  digitalWrite(rojo , ( ( fn_Recepteur_pin11 () ) == ( 0x2F0 ) ));
}



ADELANTE = 0x2F0;
ATRAS = 0xAF0;
IZQUIERDA=0x2D0;
DERECHA = 0xCD0;
PARO=0xA70;

  if (results.value == 0xA70 ){ // read two switches
    Paro();
  }

*/

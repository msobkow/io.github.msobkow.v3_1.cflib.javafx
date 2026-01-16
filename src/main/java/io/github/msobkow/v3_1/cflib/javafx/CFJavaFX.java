/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.msobkow.v3_1.cflib.javafx;

import io.github.msobkow.v3_1.cflib.inz.Inz;
import io.github.msobkow.v3_1.cflib.inz.InzPathEntry;

/**
 *
 * @author msobkow
 */
public class CFJavaFX {
	protected static boolean initialized = false;

	public static void init() {
		if (initialized) {
			return;
		}
		initialized = true;
//        Inz.addPathEntry(new InzPathEntry("/opt/mcf/v3_1/java" + "/io.github.msobkow.v3_1.cflib.cflibjavafx/src/main/resources/inz/langs"));
		InzPathEntry entry = new InzPathEntry(CFJavaFX.class, "/inz/langs/");
		Inz.addPathEntry(entry);
	}
}

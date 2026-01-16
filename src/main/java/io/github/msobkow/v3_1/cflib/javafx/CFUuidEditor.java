/*
 *	Mark's Code Fractal CFLib JavaFX 3.1 Widget and Support Library
 *
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *
 *	This file is part of Mark's Code Fractal CFLib.
 *
 *	Mark's Code Fractal CFLib is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *
 *	Mark's Code Fractal CFLib is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	Mark's Code Fractal CFLib is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU Library General Public License for more details.
 *
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFLib.  If not, see &lt;https://www.gnu.org/licenses/&gt;.
 *
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package io.github.msobkow.v3_1.cflib.javafx;

import java.util.*;
import javafx.geometry.Pos;

import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.inz.Inz;

public class CFUuidEditor
extends CFTextField
{
	protected UUID value = null;

	protected String fieldNameInzTag = null;
	
	public String getFieldNameInzTag() {
		return( fieldNameInzTag );
	}
	
	public void setFieldNameInzTag( String value ) {
		if( ( value == null ) || ( value.length() <= 0 ) ) {
			fieldNameInzTag = null;
		}
		else {
			fieldNameInzTag = value;
		}
	}
	
	public CFUuidEditor() {
		super();
		setAlignment( Pos.CENTER_LEFT );
		setMinWidth( 200 );
		setPrefWidth( 300 );
		setMaxWidth( 370 );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
	}
	
	public void setUuidValue( UUID val ) {
		value = val;
		String str;
		if( value != null ) {
			str = value.toString();
		}
		else {
			str = "";
		}
		setText( str );
	}
	
	public UUID getUuidValue() {
		final String S_ProcName = "getUuidValue";
		String str = getText();
		if( ( str == null ) || ( str.length() <= 0 ) ) {
			value = null;
		}
		else {
			try {
				UUID val = UUID.fromString( str );
				if( val == null ) {
					throw new CFLibInvalidArgumentException( Inz.x(fieldNameInzTag),
						Inz.s(fieldNameInzTag),
						S_ProcName,
						0,
						"text",
						getText(),
						getText() );
				}
				value = val;
			}
			catch( Exception e ) {
				throw new CFLibInvalidArgumentException( Inz.x(fieldNameInzTag),
					Inz.s(fieldNameInzTag),
					S_ProcName,
					0,
					"text",
					getText(),
					getText() );
			}
		}
		return( value );
	}
}

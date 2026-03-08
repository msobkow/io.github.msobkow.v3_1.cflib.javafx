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

package server.markhome.mcf.v3_1.cflib.javafx;

import java.text.*;

import javafx.geometry.Pos;

import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.inz.Inz;

public class CFInt16Editor
extends CFFormattedTextField
{
	protected static Format defaultFormat = null;
	protected short minValue = (short)-32768;
	protected short maxValue = (short)32767;

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
	
	public static Format getDefaultFormat() {
		if( defaultFormat == null ) {
			defaultFormat = new DecimalFormat( "####0;-####0" );
		}
		return( defaultFormat );
	}
	
	public CFInt16Editor() {
		setAlignment( Pos.CENTER_RIGHT );
		setMinWidth( 70 );
		setPrefWidth( 70 );
		setMaxWidth( 70 );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
	}

	public short getMinValue() {
		return( minValue );
	}
	
	public void setMinValue( short value ) {
		minValue = value;
	}
	
	public short getMaxValue() {
		return( maxValue );
	}
	
	public void setMaxValue( short value ) {
		maxValue = value;
	}
	
	public void setInt16Value( Short value ) {
		if( value == null ) {
			setText( "" );
		}
		else {
			String text = getDefaultFormat().format( value );
			setText( text );
		}
	}
	
	public Short getInt16Value() {
		final String S_ProcName = "getInt16Value";
		Short retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = null;
		}
		else {
			Short v = Short.valueOf( text );
			if( v == null ) {
				throw new CFLibInvalidArgumentException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
						S_ProcName,
						0,
						text );
			}
			if( v.compareTo( minValue ) < 0 ) {
				throw new CFLibArgumentUnderflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
						S_ProcName,
						1,
						Inz.x(fieldNameInzTag),
						v,
						minValue );
			}
			if( v.compareTo( maxValue ) > 0 ) {
				throw new CFLibArgumentOverflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
						S_ProcName,
						1,
						Inz.x(fieldNameInzTag),
						v,
						maxValue );
			}
			retval = v;
		}
		return( retval );
	}
}

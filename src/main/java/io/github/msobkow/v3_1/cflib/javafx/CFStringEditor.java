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

import javafx.geometry.Pos;

import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.inz.Inz;

public class CFStringEditor
extends CFTextField
{
	protected int maxLen = 1;

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

	public CFStringEditor() {
		super();
		setAlignment( Pos.CENTER_LEFT );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
	}
	
	public int getMaxLen() {
		return( maxLen );
	}

	public void setMaxLen( int value ) {
		final String S_ProcName = "setMaxLen";
		if( maxLen < 1 ) {
			throw new CFLibArgumentUnderflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					1,
					"value",
					value,
					1 );
		}
		maxLen = value;
		if( maxLen > 58 ) {
			setPrefWidth( 660 );
		}
		else if( maxLen > 0 ) {
			setPrefWidth( ( maxLen + 2 ) * 11 );
		}
	}
	
	public boolean hasValue() {
		boolean retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = false;
		}
		else {
			retval = true;
		}
		return( retval );
	}
	
	public boolean isEditValid() {
		String str = getText();
		if( str == null ) {
			return( true );
		}
		
		int len = str.length();
		if( len > maxLen ) {
			return( false );
		}
		else {
			return( true );
		}
	}
	
	public void setStringValue( String value ) {
		if( value != null ) {
			setText( value );
		}
		else {
			setText( "" );
		}
	}

	public String getStringValue() {
		final String S_ProcName = "getStringValue";
		String text = getText();
		if( text == null ) {
			return( null );
		}
		else if( text.length() > maxLen ) {
			throw new CFLibArgumentOverflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					0,
					"MaxLen",
					text.length(),
					maxLen );
		}
		else {
			return( text );
		}
	}
}

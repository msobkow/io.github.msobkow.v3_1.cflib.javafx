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

import java.text.*;
import javafx.geometry.Pos;

import io.github.msobkow.v3_1.cflib.*;
import io.github.msobkow.v3_1.cflib.inz.Inz;

public class CFDoubleEditor
extends CFFormattedTextField
{
	protected static Format defaultFormat = null;

	protected Double minValue = -Double.MAX_VALUE;
	protected Double maxValue = Double.MAX_VALUE;

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
			defaultFormat = new DecimalFormat( "######################################################################################################################################################################################################################################################################################################################0.0######################################################################################################################################################################################################################################################################################################################" );
		}
		return( defaultFormat );
	}

	public CFDoubleEditor() {
		super();
		setAlignment( Pos.CENTER_RIGHT );
		setMinHeight( 25 );
		setMaxHeight( 25 );
		setPrefHeight( 25 );
		setMinWidth( 160 );
		setMaxWidth( 160 );
		setPrefWidth( 160 );
	}

	public Double getMinValue() {
		return( minValue );
	}
	
	public void setMinValue( Double value ) {
		final String S_ProcName = "setMinValue";
		if( value == null ) {
			throw new CFLibNullArgumentException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					1,
					Inz.x(fieldNameInzTag) );
		}
		if( value.compareTo( -Double.MAX_VALUE ) < 0 ) {
			throw new CFLibArgumentUnderflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					1,
					Inz.x(fieldNameInzTag),
					value,
					-Double.MAX_VALUE );
		}
		minValue = value;
	}

	public Double getMaxValue() {
		return( maxValue );
	}

	public void setMaxValue( Double value ) {
		final String S_ProcName = "setMaxValue";
		if( value == null ) {
			throw new CFLibNullArgumentException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					1,
					Inz.x(fieldNameInzTag) );
		}
		if( value.compareTo( Double.MAX_VALUE ) > 0 ) {
			throw new CFLibArgumentOverflowException( Inz.x(fieldNameInzTag), Inz.s(fieldNameInzTag),
					S_ProcName,
					1,
					Inz.x(fieldNameInzTag),
					value,
					Double.MAX_VALUE );
		}
		maxValue = value;
	}
	
	public void setDoubleValue( Double value ) {
		if( value == null ) {
			setText( "" );
		}
		else {
			String text = getDefaultFormat().format( value );
			setText( text );
		}
	}
	
	public Double getDoubleValue() {
		final String S_ProcName = "getDoubleValue";
		Double retval;
		String text = getText();
		if( ( text == null ) || ( text.length() <= 0 ) ) {
			retval = null;
		}
		else {
			Double v = Double.valueOf( text );
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

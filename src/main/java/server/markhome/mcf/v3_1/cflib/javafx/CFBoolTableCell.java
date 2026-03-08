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

import javafx.scene.control.TableCell;


public class CFBoolTableCell<T>
extends TableCell<T,Boolean>
{
	@Override protected void updateItem( Boolean item, boolean empty ) {
		super.updateItem( item, empty );
		if( empty ) {
			setText( null );
			setStyle( "" );
		}
		else if( item == null ) {
			setText( "?" );
			setStyle( "-fx-alignment: CENTER" );
		}
		else {
			boolean value = item.booleanValue();
			String cellText;
			if( value ) {
				cellText = "T";
			}
			else {
				cellText = "F";
			}
			setText( cellText );
			setStyle( "-fx-alignment: CENTER" );
		}
	}
}

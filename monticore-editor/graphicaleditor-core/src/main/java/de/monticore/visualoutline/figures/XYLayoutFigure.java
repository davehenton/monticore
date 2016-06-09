/*******************************************************************************
 * MontiCore Language Workbench
 * Copyright (c) 2015, 2016, MontiCore, All rights reserved.
 *  
 * This project is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this project. If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package de.monticore.visualoutline.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Insets;

/**
 * Simple figure that allows children to be positioned freely 
 */
public class XYLayoutFigure extends Figure {
  protected XYLayoutFigure(Object model) {
    XYLayout layout = new XYLayout();
    setLayoutManager(layout);
  }
  
  @Override
  public Insets getInsets() {
    if (getChildren().isEmpty()) {
      return new Insets(0, 0, 0, 0);
    }
    return new Insets(15, 15, 15, 15);
  }
}

/*******************************************************************************
 * MontiCore Language Workbench, www.monticore.de
 * Copyright (c) 2017, MontiCore, All rights reserved.
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
package de.monticore.genericgraphics.model.impl;

import org.eclipse.draw2d.Locator;

import de.monticore.genericgraphics.model.IConnectionLabel;
import de.monticore.genericgraphics.view.figures.connections.locators.ConnectionLocatorPosition;


/**
 * <p>
 * Basic implementation for all connection labels.
 * </p>
 * <p>
 * Provides management of the position of the label.
 * </p>
 * 
 * @author Tim Enger
 */
public class ConnectionLabel implements IConnectionLabel {
  
  private ConnectionLocatorPosition position;
  
  /**
   * Constructor
   * 
   * @param position {@link ConnectionLocatorPosition}-position of the
   *          connection label
   */
  public ConnectionLabel(ConnectionLocatorPosition position) {
    this.position = position;
  }
  
  /**
   * Sets the {@link Locator}.
   * 
   * @param position The {@link Locator}
   */
  @Override
  public void setPosition(ConnectionLocatorPosition position) {
    this.position = position;
  }
  
  /**
   * @return The {@link Locator}
   */
  @Override
  public ConnectionLocatorPosition getPosition() {
    return position;
  }
}

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
package de.monticore.genericgraphics.controller.selection;

/**
 * An interface providing methods for accessing line numbers.
 * 
 * @author Tim Enger
 */
public interface IHasLineNumbers {
  
  /**
   * @return The line number of the start
   */
  public int getStartLine();
  
  /**
   * @return The offset in the start line number
   */
  public int getStartOffset();
  
  /**
   * @return The line number of the end
   */
  public int getEndLine();
  
  /**
   * @return The offset in the end line number
   */
  public int getEndOffset();
}

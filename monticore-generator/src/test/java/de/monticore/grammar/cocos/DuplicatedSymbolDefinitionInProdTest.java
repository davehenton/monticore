/*
 * ******************************************************************************
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
 * ******************************************************************************
 */

package de.monticore.grammar.cocos;

import org.junit.BeforeClass;
import org.junit.Test;

import de.monticore.grammar.grammar_withconcepts._cocos.Grammar_WithConceptsCoCoChecker;
import de.se_rwth.commons.logging.Log;

/**
 * Created by
 *
 * @author MB
 */
public class DuplicatedSymbolDefinitionInProdTest extends CocoTest {

  private final String MESSAGE = " Symbol or scope is mentioned more than once in the declaration 'A'.";
  private static final Grammar_WithConceptsCoCoChecker checker = new Grammar_WithConceptsCoCoChecker();
  private final String grammar = "cocos.invalid.A4041.A4041";

  @BeforeClass
  public static void disableFailQuick() {
    Log.enableFailQuick(false);
    checker.addCoCo(new DuplicatedSymbolDefinitionInProd());
  }

  @Test
  public void testDuplicatedSymbolDefinition() {
    testInvalidGrammar(grammar, DuplicatedSymbolDefinitionInProd.ERROR_CODE, MESSAGE, checker);
  }
  
  @Test
  public void testCorrect(){
    testValidGrammar("cocos.valid.Attributes", checker);
  }

}

/*
 * Copyright (c) 2017, MontiCore. All rights reserved.
 *
 * http://www.se-rwth.de/ 
 */
package de.monticore.generating.templateengine.reporting.commons;

import de.monticore.ast.ASTNode;


/**
 * TODO: Write me!
 *
 * @author  (last commit) $Author$
 * @since   TODO: add version number
 *
 */
public class ASTNodeIdentHelper implements IASTNodeIdentHelper {
  
  /**
   * @see de.monticore.generating.templateengine.reporting.commons.IASTNodeIdentHelper#getIdent(de.monticore.ast.ASTNode)
   */
  @Override
  public String getIdent(ASTNode ast) {
    String name;
    if (ast.getSymbol().isPresent()) {
      name = ast.getSymbol().get().getName();
    } else {
      name = ast.getClass().getSimpleName();
      if (name.startsWith("AST")) {
        name = name.substring(3);
      }
    }
    return format(name, "ASTNode");
  }
  
}

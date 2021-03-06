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

package de.monticore.codegen.mc2cd.transl.creation;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.UnaryOperator;

import com.google.common.collect.Iterables;

import de.monticore.grammar.grammar._ast.ASTASTRule;
import de.monticore.grammar.grammar._ast.ASTAbstractProd;
import de.monticore.grammar.grammar._ast.ASTClassProd;
import de.monticore.grammar.grammar._ast.ASTInterfaceProd;
import de.monticore.grammar.grammar._ast.ASTMCGrammar;
import de.monticore.umlcd4a.cd4analysis._ast.ASTCDClass;
import de.monticore.umlcd4a.cd4analysis._ast.ASTCDCompilationUnit;
import de.monticore.umlcd4a.cd4analysis._ast.ASTCDDefinition;
import de.monticore.umlcd4a.cd4analysis._ast.ASTCDInterface;
import de.monticore.umlcd4a.cd4analysis._ast.CD4AnalysisNodeFactory;
import de.monticore.utils.ASTNodes;
import de.monticore.utils.Link;

/**
 * Creates Links from ASTRules to CDClasses and CDInterfaces. The CDClass/CDInterface will
 * correspond to the ClassProd/AbstractProd/InterfaceProd referred to by the ASTRule.
 * 
 * @author Sebastian Oberhoff
 */
public class ASTRulesToCDClassesAndCDInterfaces implements
    UnaryOperator<Link<ASTMCGrammar, ASTCDCompilationUnit>> {
  
  @Override
  public Link<ASTMCGrammar, ASTCDCompilationUnit> apply(
      Link<ASTMCGrammar, ASTCDCompilationUnit> rootLink) {
    
    Set<ASTASTRule> matchedASTRules = createLinksForMatchedASTRules(rootLink);
    createLinksForUnmatchedASTRules(matchedASTRules, rootLink);
    
    return rootLink;
  }
  
  private Set<ASTASTRule> createLinksForMatchedASTRules(
      Link<ASTMCGrammar, ASTCDCompilationUnit> rootLink) {
    
    Set<ASTASTRule> matchedASTRules = new LinkedHashSet<>();
    // creates Links from ASTRules to the CDClasses of corresponding ClassProds
    for (Link<ASTClassProd, ASTCDClass> link : rootLink.getLinks(ASTClassProd.class,
        ASTCDClass.class)) {
      
      ASTNodes.getSuccessors(rootLink.source(), ASTASTRule.class).stream()
          .filter(astRule -> astRule.getType().equals(link.source().getName()))
          .forEach(matchedASTRule -> {
            matchedASTRules.add(matchedASTRule);
            new Link<>(matchedASTRule, link.target(), link.parent());
          });
    }
    
    // creates Links from ASTRules to the CDClasses of corresponding AbstractProds
    for (Link<ASTAbstractProd, ASTCDClass> link : rootLink.getLinks(ASTAbstractProd.class,
        ASTCDClass.class)) {
      
      ASTNodes.getSuccessors(rootLink.source(), ASTASTRule.class).stream()
          .filter(astRule -> astRule.getType().equals(link.source().getName()))
          .forEach(matchedASTRule -> {
            matchedASTRules.add(matchedASTRule);
            new Link<>(matchedASTRule, link.target(), link.parent());
          });
    }
    
    // creates Links from ASTRules to the CDInterfaces of corresponding InterfaceProds
    for (Link<ASTInterfaceProd, ASTCDInterface> link : rootLink.getLinks(ASTInterfaceProd.class,
        ASTCDInterface.class)) {
      
      ASTNodes.getSuccessors(rootLink.source(), ASTASTRule.class).stream()
          .filter(astRule -> astRule.getType().equals(link.source().getName()))
          .forEach(matchedASTRule -> {
            matchedASTRules.add(matchedASTRule);
            new Link<>(matchedASTRule, link.target(), link.parent());
          });
    }
    return matchedASTRules;
  }
  
  private void createLinksForUnmatchedASTRules(Set<ASTASTRule> matchedASTRules,
      Link<ASTMCGrammar, ASTCDCompilationUnit> rootLink) {
    
    for (ASTASTRule astRule : ASTNodes.getSuccessors(rootLink.source(), ASTASTRule.class)) {
      if (!matchedASTRules.contains(astRule)) {
        ASTCDClass cdClass = CD4AnalysisNodeFactory.createASTCDClass();
        cdClass.setModifier(CD4AnalysisNodeFactory.createASTModifier());
        
        Link<ASTMCGrammar, ASTCDDefinition> parentLink = Iterables.getOnlyElement(rootLink
            .getLinks(ASTMCGrammar.class, ASTCDDefinition.class));
        parentLink.target().getCDClasses().add(cdClass);
        new Link<>(astRule, cdClass, parentLink);
      }
    }
  }
}

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

package mc.feature.visitor.inheritance.delegator;

import mc.feature.visitor.inheritance.a._ast.ASTXA;
import mc.feature.visitor.inheritance.b._ast.ASTXB;
import mc.feature.visitor.inheritance.c._ast.ASTXC;
import mc.feature.visitor.inheritance.c._ast.ASTYC;
import mc.feature.visitor.inheritance.c._visitor.CInheritanceVisitor;
import mc.feature.visitor.inheritance.c._visitor.CVisitor;
import de.monticore.ast.ASTNode;

/**
 * TODO: Write me!
 *
 * @author Robert Heim
 */
public class InheritanceCVisitor implements CInheritanceVisitor {
  final private StringBuilder run;
  
  public InheritanceCVisitor(StringBuilder run) {
    this.run = run;
  }
  
  @Override
  public void visit(ASTNode node) {
    run.append("InheritanceCVisitor.vASTNode");
  }
  
  @Override
  public void endVisit(ASTNode node) {
    run.append("InheritanceCVisitor.eASTNode");
  }
  
  @Override
  public void handle(ASTXA node) {
    run.append("InheritanceCVisitor.hA");
    CInheritanceVisitor.super.handle(node);
  }
  
  @Override
  public void traverse(ASTXA node) {
    run.append("InheritanceCVisitor.tXA");
    CInheritanceVisitor.super.traverse(node);
  }
  
  @Override
  public void visit(ASTXA node) {
    run.append("InheritanceCVisitor.vXA");
  }
  
  @Override
  public void endVisit(ASTXA node) {
    run.append("InheritanceCVisitor.eXA");
  }
  
  @Override
  public void handle(ASTXB node) {
    run.append("InheritanceCVisitor.hXB");
    CInheritanceVisitor.super.handle(node);
  }
  
  @Override
  public void traverse(ASTXB node) {
    run.append("InheritanceCVisitor.tXB");
    CInheritanceVisitor.super.traverse(node);
  }
  
  @Override
  public void visit(ASTXB node) {
    run.append("InheritanceCVisitor.vXB");
  }
  
  @Override
  public void endVisit(ASTXB node) {
    run.append("InheritanceCVisitor.eXB");
  }
  
  @Override
  public void handle(ASTXC node) {
    run.append("InheritanceCVisitor.hXC");
    CInheritanceVisitor.super.handle(node);
  }
  
  @Override
  public void traverse(ASTXC node) {
    run.append("InheritanceCVisitor.tXC");
    CInheritanceVisitor.super.traverse(node);
  }
  
  @Override
  public void visit(ASTXC node) {
    run.append("InheritanceCVisitor.vXC");
  }
  
  @Override
  public void endVisit(ASTXC node) {
    run.append("InheritanceCVisitor.eXC");
  }
  
  @Override
  public void handle(ASTYC node) {
    run.append("InheritanceCVisitor.hYC");
    CInheritanceVisitor.super.handle(node);
  }
  
  @Override
  public void traverse(ASTYC node) {
    run.append("InheritanceCVisitor.tYC");
    CInheritanceVisitor.super.traverse(node);
  }
  
  @Override
  public void visit(ASTYC node) {
    run.append("InheritanceCVisitor.vYC");
  }
  
  @Override
  public void endVisit(ASTYC node) {
    run.append("InheritanceCVisitor.eYC");
  }
  
  // realthis pattern
  private CVisitor realThis;
  
  @Override
  public void setRealThis(CVisitor realThis) {
    this.realThis = realThis;
  }
  
  @Override
  public CVisitor getRealThis() {
    return realThis;
  }
  
}

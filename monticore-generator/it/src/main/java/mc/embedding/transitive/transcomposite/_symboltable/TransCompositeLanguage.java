/*
 * ******************************************************************************
 * MontiCore Language Workbench
 * Copyright (c) 2015, MontiCore, All rights reserved.
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

/* generated from model null*/
/* generated by template symboltable.ModelingLanguage*/




package mc.embedding.transitive.transcomposite._symboltable;

import java.util.Optional;

import de.monticore.EmbeddingModelingLanguage;
import de.monticore.symboltable.MutableScope;
import de.monticore.symboltable.ResolverConfiguration;
import mc.embedding.composite._symboltable.CompositeLanguage;
import mc.embedding.transitive.transcomposite._parser.TransCompositeParser;
import mc.embedding.transitive.transhost._symboltable.TransHostLanguage;

public class TransCompositeLanguage extends EmbeddingModelingLanguage {

  public TransCompositeLanguage() {
    super("Trans Composite Language", TransHostLanguage.FILE_ENDING, new TransHostLanguage(), new CompositeLanguage());

    modelLoader =  provideModelLoader();
    initResolvingFilters();
  }

  @Override
  public TransCompositeParser getParser() {
    return new TransCompositeParser();
  }


  @Override
  public TransCompositeModelLoader getModelLoader() {
    return (TransCompositeModelLoader) super.getModelLoader();
  }

  //@Override
  //protected TransCompositeModelLoader provideModelLoader() {
  //  return new TransCompositeModelLoader(this);
  //}

  protected void initResolvingFilters() {
  }

  /**
   * @see de.monticore.ModelingLanguage#getSymbolTableCreator(de.monticore.symboltable.ResolverConfiguration, de.monticore.symboltable.MutableScope)
   */
  @Override
  public Optional<TransCompositeSymbolTableCreator> getSymbolTableCreator(
      ResolverConfiguration resolverConfiguration, MutableScope enclosingScope) {
    return Optional.of(new TransCompositeSymbolTableCreator(resolverConfiguration, enclosingScope));
  }

  /**
   * @see de.monticore.CommonModelingLanguage#provideModelLoader()
   */
  @Override
  protected TransCompositeModelLoader provideModelLoader() {
    return new TransCompositeModelLoader(this);
  }
}

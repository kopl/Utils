/*******************************************************************************
 * Copyright (c) 2013 FZI, Germany
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Christian Busch - initial API and implementation
 *******************************************************************************/
package de.fzi.se.modelextractor.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.fzi.se.modelextractor.Extractor;

/**
 * This handler handles the extraction of the model into a single xmi file.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ExtractionHandler extends AbstractHandler {

    public ExtractionHandler() {

    }


    public Object execute(ExecutionEvent event) throws ExecutionException {

	final String[] extensions = { "*.xmi" };
	File source = null;
	ISelection selection = HandlerUtil.getActiveMenuSelectionChecked(event);
	if (selection instanceof IStructuredSelection) {
	    IStructuredSelection ssel = (IStructuredSelection) selection;
	    IJavaElement obj = (IJavaElement) ssel.getFirstElement();
	    try {
		source = obj.getCorrespondingResource().getLocation().toFile();
	    } catch (JavaModelException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
	FileDialog fd = new FileDialog(window.getShell(), SWT.SAVE);
	fd.setFilterExtensions(extensions);
	String destinationString = fd.open();
	File destination = new File(destinationString);
	Extractor.extract(source, destination);
	return null;

    }
}

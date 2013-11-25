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
package org.kopl.jamopp.modelextractor;

import java.io.File;
import java.io.IOException;

public class Extractor {

    public static void extract(File source, File destination) {

	String[] paths = { source.getAbsolutePath(), destination.getAbsolutePath() };
	try {
	    JaMoPPC.main(paths);
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}

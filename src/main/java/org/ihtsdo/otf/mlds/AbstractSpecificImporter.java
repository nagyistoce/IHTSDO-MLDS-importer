package org.ihtsdo.otf.mlds;

import java.io.File;
import java.util.Collection;

public abstract class AbstractSpecificImporter implements SpecificImporter {

	public abstract Collection<String[]> getLines();

	public abstract void setInputFile(String fileUrlIn);

	public File getInputFile(String fileUrlIn) {

		return null;
	}

	public String[] parseFile(File FileIn, String sepChar) {

		return null;
	}

}

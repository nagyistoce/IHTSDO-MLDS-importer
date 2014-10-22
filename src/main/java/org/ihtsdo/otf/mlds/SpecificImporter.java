package org.ihtsdo.otf.mlds;

import java.util.Collection;

public interface SpecificImporter {

	Collection<String[]> getLines();

	void setInputFile(String fileUrl);

}

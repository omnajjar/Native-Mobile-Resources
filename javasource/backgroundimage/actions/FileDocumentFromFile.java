// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package backgroundimage.actions;

import java.io.File;
import java.io.FileInputStream;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * Loads a file from the local (server) storage and stores it inside a FileDocument.
 */
public class FileDocumentFromFile extends CustomJavaAction<java.lang.Boolean>
{
	private java.lang.String file;
	private IMendixObject __fileDocument;
	private system.proxies.FileDocument fileDocument;

	public FileDocumentFromFile(IContext context, java.lang.String file, IMendixObject fileDocument)
	{
		super(context);
		this.file = file;
		this.__fileDocument = fileDocument;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.fileDocument = __fileDocument == null ? null : system.proxies.FileDocument.initialize(getContext(), __fileDocument);

		// BEGIN USER CODE
		try (
			FileInputStream fis = new FileInputStream(new File(this.file))
		) {
			Core.storeFileDocumentContent(getContext(), fileDocument.getMendixObject(), 
				this.file, fis);
		}
		
		return true;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "FileDocumentFromFile";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}

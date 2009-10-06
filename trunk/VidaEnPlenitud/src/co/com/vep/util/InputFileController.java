package co.com.vep.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventObject;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.inputfile.InputFile;

public class InputFileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// File sizes used to generate formatted label
    public static final long MEGABYTE_LENGTH_BYTES = 1048000l;
    public static final long KILOBYTE_LENGTH_BYTES = 1024l;

    // files associated with the current user
    @SuppressWarnings("unchecked")
	private final List fileList =
            Collections.synchronizedList(new ArrayList());
    // latest file uploaded by client
    private InputFileData currentFile;
    // file upload completed percent (Progress)
    private int fileProgress;

    @SuppressWarnings("unchecked")
	public void uploadFile(ActionEvent event) {
        InputFile inputFile = (InputFile) event.getSource();
        FileInfo fileInfo = inputFile.getFileInfo();
        if (fileInfo.getPercent() == 100) {
            // reference our newly updated file for display purposes and
            // added it to our history file list.
            currentFile = new InputFileData(fileInfo);
            synchronized (fileList) {
                fileList.add(currentFile);
            }

        }

    }

    /**
     * <p>This method is bound to the inputFile component and is executed
     * multiple times during the file upload process.  Every call allows
     * the user to finds out what percentage of the file has been uploaded.
     * This progress information can then be used with a progressBar component
     * for user feedback on the file upload progress. </p>
     *
     * @param event holds a InputFile object in its source which can be probed
     *              for the file upload percentage complete.
     */
    public void fileUploadProgress(EventObject event) {
        InputFile ifile = (InputFile) event.getSource();
        fileProgress = ifile.getFileInfo().getPercent();
    }
    
    @SuppressWarnings("unchecked")
	public void removeUploadedFile(ActionEvent event) {
        // Get the inventory item ID from the context.
        FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        String fileName = (String) map.get("fileName");

        synchronized (fileList) {
            InputFileData inputFileData;
            for (int i = 0; i < fileList.size(); i++) {
                inputFileData = (InputFileData)fileList.get(i);
                // remove our file
                if (inputFileData.getFileInfo().getFileName().equals(fileName)) {
                    fileList.remove(i);
                    break;
                }
            }
        }
    }

    public InputFileData getCurrentFile() {
        return currentFile;
    }

    public int getFileProgress() {
        return fileProgress;
    }

    @SuppressWarnings("unchecked")
	public List getFileList() {
        return fileList;
    }
}

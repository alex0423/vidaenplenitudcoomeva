package co.com.vep.util;

import java.io.File;

import co.com.vep.vista.VistaRegistrarProfesor;

import com.icesoft.faces.component.inputfile.FileInfo;

public class InputFileData {
	
	// file info attributes
    private FileInfo fileInfo;
    // file that was uplaoded
    private File file;

    /**
     * Create a new InputFileDat object.
     *
     * @param fileInfo fileInfo object created by the inputFile component for
     *                 a given File object.
     */
    public InputFileData(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
   //     this.file = fileInfo.getFile();
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    /**
     * Method to return the file size as a formatted string
     * For example, 4000 bytes would be returned as 4kb
     *
     *@return formatted file size
     */
    public String getSizeFormatted() {
        long ourLength = file.length();
        
        // Generate formatted label, such as 4kb, instead of just a plain number
        if (ourLength >= VistaRegistrarProfesor.MEGABYTE_LENGTH_BYTES) {
            return ourLength / VistaRegistrarProfesor.MEGABYTE_LENGTH_BYTES + " MB";
        }
        else if (ourLength >= VistaRegistrarProfesor.KILOBYTE_LENGTH_BYTES) {
            return ourLength / VistaRegistrarProfesor.KILOBYTE_LENGTH_BYTES + " KB";
        }
        else if (ourLength == 0) {
            return "0";
        }
        else if (ourLength < VistaRegistrarProfesor.KILOBYTE_LENGTH_BYTES) {
            return ourLength + " B";
        }
        
        return Long.toString(ourLength);
    }
}

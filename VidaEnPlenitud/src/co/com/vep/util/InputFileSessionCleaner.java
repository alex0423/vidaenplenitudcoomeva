package co.com.vep.util;

import java.io.File;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class InputFileSessionCleaner implements HttpSessionListener {

	public static final String FILE_UPLOAD_DIRECTORY = "upload";
	
    public void sessionDestroyed(HttpSessionEvent event) {
        // get the session id, so we know which folder to remove
        String sessionId = event.getSession().getId();

        String applicationPath = event.getSession().getServletContext().getRealPath(
                event.getSession().getServletContext().getServletContextName());

        String sessionFileUploadPath =
                applicationPath + FILE_UPLOAD_DIRECTORY + sessionId;

        File sessionfileUploadDirectory = new File(sessionFileUploadPath);

        if (sessionfileUploadDirectory.isDirectory()) {
            try {
                sessionfileUploadDirectory.delete();
            }
            catch (SecurityException e) {
//                log.error("Error deleting file upload directory: ", e);
            }
        }

    }

    public void sessionCreated(HttpSessionEvent event) {

    }

}

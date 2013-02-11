package com.zuehlke.dynamicform.pdf;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "HandlePDFController")
@SessionScoped
public class HandlePDFController implements Serializable {

	private static final long serialVersionUID = 6347630075264679957L;

	private static final int DEFAULT_BUFFER_SIZE = 10240; // 10KB.

	private boolean downloadFinished;

	public void downloadPDF(String type) throws IOException {

		// Prepare.
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();

		InputStream input = null;
		BufferedOutputStream output = null;

		try {
			// Open file.
			input = getClass().getClassLoader().getResourceAsStream(
					getPathToResource());

			// Init servlet response.
			response.reset();
			response.setHeader("Content-Type", "application/pdf");
			response.setHeader("Content-Disposition", type
					+ "; filename=\"offerte.pdf\"");
			output = new BufferedOutputStream(response.getOutputStream(),
					DEFAULT_BUFFER_SIZE);

			// Write file contents to response.
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			int length;
			while ((length = input.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}

			// Finalize task.
			output.flush();
		} finally {
			// Gently close streams.
			close(output);
			close(input);
		}

		downloadFinished = true;
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Fertig"));
		facesContext.responseComplete();
	}

	private String getPathToResource() {
		return getClass().getPackage().getName().replaceAll("\\.", "/")
				+ "/SL_Offerte.pdf";
	}

	public String getDownloadFinishedMsg() {
		if (downloadFinished) {
			return "Download beendet!";
		} else {
			return "";
		}
	}

	private static void close(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
				// Do your thing with the exception. Print it, log it or mail
				// it. It may be useful to
				// know that this will generally only be thrown when the client
				// aborted the download.
				e.printStackTrace();
			}
		}
	}

	public boolean isDownloadFinished() {
		return downloadFinished;
	}

	public StreamedContent getFile() {
		InputStream input = getClass().getClassLoader().getResourceAsStream(
				getPathToResource());
		StreamedContent file = new DefaultStreamedContent(input,
				"application/pdf", "file.pdf");
		return file;
	}

}

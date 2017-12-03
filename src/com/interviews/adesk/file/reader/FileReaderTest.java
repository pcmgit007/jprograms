package com.interviews.adesk.file.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Text content extractor from URL
 * 
 * @author Ranjith
 */
public class FileReaderTest {

	public static void main(String[] args) {
		BufferedReader reader = null;
		try {
			// http://www.google.com
			// https://youtu.be/ue80QwXMRHg

			URL url = new URL("https://youtu.be/ue80QwXMRHg");
			reader = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;
			while ((inputLine = reader.readLine()) != null) {
				System.out.println(inputLine);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				// suppress
			}
		}
	}

}
package giovany;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author henri
 */
public class FileLoader {
    public static String loadFileAsString(String filePath) throws FileNotFoundException, IOException {
        StringBuilder content = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch(IOException e) {
            System.err.println("Error occurred while reading the file: " + e.getMessage());
        }

        return content.toString(); // Return the file content as a single string
    }
    
    public static String FileLoader(String filePath) throws IOException {
        String fileContent = loadFileAsString(filePath);
        return fileContent;
    }
}

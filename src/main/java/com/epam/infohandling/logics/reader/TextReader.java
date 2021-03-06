package com.epam.infohandling.logics.reader;

import com.epam.infohandling.exception.TextReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {
    private static final Logger logger = LogManager.getLogger(TextReader.class);
    private static final String EOF_DELIMITER = "\\Z";

    public String readText(String filePath) throws TextReadingException{
        try(Scanner scanner = new Scanner(new File(filePath))) {
            logger.info("Reading text from file "+filePath);
            return scanner.useDelimiter(EOF_DELIMITER).next();
        }catch (IOException e){
            throw new TextReadingException(e.getMessage(),e);
        }
    }
}

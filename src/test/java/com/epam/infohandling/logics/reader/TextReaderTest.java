package com.epam.infohandling.logics.reader;

import com.epam.infohandling.exception.TextReadingException;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest {
    private static final String TEST_FILE_PATH = "src/test/resources/testText.txt";
    private static final String TEST_WRONG_FILE_PATH = "src/test/resources/ff.txt";
    private static final String EXPECTED_TEXT="    HTML: HyperText Markup Language. The markup (formatting) language for the web.\r\n" +
            "    URI: Uniform Resource Identifier. A kind of “address” that is unique and used to identify to each resource on the web. It is also commonly called a URL.\r\n" +
            "    HTTP: Hypertext Transfer Protocol. Allows for the retrieval of linked resources from across the web.";

    @Test
    public void shouldReadTextWhenPathValid() throws TextReadingException{
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.readText(TEST_FILE_PATH);
        //then
        Assert.assertEquals(EXPECTED_TEXT,actual);
    }

    @Test(expected = TextReadingException.class)
    public void shouldThrowTextReadingExceptionWhenThereNoFile()throws TextReadingException{
        //given
        TextReader textReader = new TextReader();
        //when
        textReader.readText(TEST_WRONG_FILE_PATH);
        //then
    }
}

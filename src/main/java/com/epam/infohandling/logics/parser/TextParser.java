package com.epam.infohandling.logics.parser;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class TextParser extends Parser {
    private static final Logger logger = LogManager.getLogger(TextParser.class);
    private static final String PARAGRAPH_SEPARATOR = "\\r\\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        logger.info("Text parsing has started");
        String[] paragraphs = text.trim().split(PARAGRAPH_SEPARATOR);
        Component textComposite = new Composite();
        Arrays.stream(paragraphs).forEach(p->textComposite.addComponent(getSuccessor().parse(p)));
        logger.info("Text parsing completed successfully");
        return textComposite;
    }
}

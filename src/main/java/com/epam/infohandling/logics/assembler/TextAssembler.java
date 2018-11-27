package com.epam.infohandling.logics.assembler;

import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextAssembler {
    private static final Logger logger = LogManager.getLogger(TextAssembler.class);
    private static final String REDUNDANT_SPACES_BEFORE_TABS = "\\s+\\t";
    private static final String REDUNDANT_SPACES_AT_END = "\\s+$";

    public String assemble(Component text){
        logger.info("Text assembling has started");
        StringBuilder textBuilder = new StringBuilder();
        List<Lexeme> lexemes = receiveLexemes(text);
        for(Lexeme lexeme : lexemes){
             String lexemeContent = lexeme.getValue();
             textBuilder.append(lexemeContent+" ");
        }
        logger.info("Text assembling completed successfully");
        return textBuilder.toString().replaceAll(REDUNDANT_SPACES_BEFORE_TABS,"\t")
                                    .replaceAll(REDUNDANT_SPACES_AT_END, "");
    }

    private List<Lexeme> receiveLexemes(Component text){
        List<Component> paragraphs = text.getChildren();
        List<Component> sentences = paragraphs.stream().flatMap(p->p.getChildren().stream()).collect(Collectors.toList());
        List<Component> lexemeComponents = sentences.stream().flatMap(s->s.getChildren().stream()).collect(Collectors.toList());
        List<Lexeme> lexemes = new ArrayList<>();
        for(Component lexemeComponent:lexemeComponents){
            lexemes.add((Lexeme) lexemeComponent);
        }
        return lexemes;
    }
}

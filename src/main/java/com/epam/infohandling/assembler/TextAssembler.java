package com.epam.infohandling.assembler;

import com.epam.infohandling.entity.Composite;
import com.epam.infohandling.entity.Component;
import com.epam.infohandling.entity.Lexeme;

import java.util.ArrayList;
import java.util.List;



public class TextAssembler {
    private static final String REDUNDANT_SPACES_BEFORE_TABS = "\\s+\\t";
    private static final String REDUNDANT_SPACES_AT_END = "\\s+$";

    public String assemble(Composite textComposite){
        List<Component> paragraphs = textComposite.getChildren();
        List<Component> sentences = new ArrayList <>();
        List<Component> lexemes = new ArrayList <>();
        for(Component paragraph:paragraphs){
            List<Component> paragraphSentences = paragraph.getChildren();
            sentences.addAll(paragraphSentences);
        }
        for(Component sentence:sentences){
            List<Component> sentenceWords = sentence.getChildren();
            lexemes.addAll(sentenceWords);
        }
        StringBuilder textBuilder = new StringBuilder();
        for(Component lexemeComponent : lexemes){
            Lexeme lexeme = (Lexeme)lexemeComponent;
             String lexemeContent =lexeme.getValue();
             textBuilder.append(lexemeContent+" ");
        }
        return textBuilder.toString().replaceAll(REDUNDANT_SPACES_BEFORE_TABS,"\t")
                                    .replaceAll(REDUNDANT_SPACES_AT_END, "");
    }
}

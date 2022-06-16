package eapli.base.questionnairemanagement.domain.Questionnaire;


import eapli.framework.domain.model.ValueObject;
import org.jetbrains.annotations.NotNull;

import javax.persistence.Embeddable;

@Embeddable
public class FileName implements ValueObject, Comparable<FileName> {

    private String fileName;

    public FileName(String fileName) {
        this.fileName = fileName;
    }

    public FileName() {

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "FileName{" +
                "fileName='" + fileName + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull FileName o) {
        return 0;
    }
}
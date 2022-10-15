package questions;

import java.util.Arrays;
import java.util.HashSet;

public class Likert implements Question {
    String questionText;
    HashSet<Integer> allowedOptions = new HashSet<>(Arrays.asList(1,2,3,4,5));

    public Likert(String questionText){
        if(questionText.trim() == "" || questionText == null){
            throw new IllegalArgumentException();
        }
        this.questionText = questionText;
    }

    @Override
    public String getText() {
        return questionText;
    }

    @Override
    public String answer(String option) {
        if(option == null){
            return "Incorrect";
        }
        if(allowedOptions.contains(Integer.parseInt(option))){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Likert) {
            Likert q = (Likert) o;
            if (this.questionText.compareTo(q.getText()) < 0) {
                return -1;
            } else if (this.questionText.compareTo(q.getText()) == 0) {
                return 0;
            } else {
                return 1;
            }
        }else if(o instanceof MultipleSelect ||o instanceof MultipleChoice || o instanceof TrueFalse){
            return 1;
        }else {
            throw new IllegalArgumentException();
        }
    }
}

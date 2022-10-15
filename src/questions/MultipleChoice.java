package questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultipleChoice implements Question{

    String questionText;
    Integer correctAnswer;

    List<String> options = new ArrayList<>();

    public MultipleChoice(String questionText,String correctAnswer, String opt1, String opt2, String opt3) throws NumberFormatException{
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));


    }

    public MultipleChoice(String questionText,String correctAnswer, String opt1, String opt2, String opt3,String opt4){

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));
    }
    public MultipleChoice(String questionText,String correctAnswer, String opt1, String opt2, String opt3,String opt4, String opt5){
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));
    }
    public MultipleChoice(String questionText,String correctAnswer, String opt1, String opt2, String opt3,String opt4, String opt5, String opt6){
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        options.add(opt6);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));
    }
    public MultipleChoice(String questionText,String correctAnswer, String opt1,
                          String opt2, String opt3,String opt4, String opt5,
                          String opt6, String opt7){
        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        options.add(opt7);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));
    }

    private Integer setAnswer(int option) throws IllegalArgumentException {
        if(option <= options.size() && option > 0){
            return option;
        }else{
            throw new IllegalArgumentException();
        }
    }

    public MultipleChoice(String questionText,String correctAnswer, String opt1,
                          String opt2, String opt3,String opt4, String opt5,
                          String opt6, String opt7, String opt8){

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        options.add(opt7);
        options.add(opt8);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswer = setAnswer(Integer.parseInt(correctAnswer));
    }
    private void parseOptionsAndQuestionText(String questionText) throws IllegalArgumentException {
//        Question text Check
        if(questionText.trim() == "" || questionText == null){
            throw new IllegalArgumentException();
        }
//        Options check
        for(String opt:options){
            if(opt.trim() == "" || opt == null){
                throw new IllegalArgumentException();
            }
        }
    }
    @Override
    public String getText() {
        return questionText;
    }

    @Override
    public String answer(String answer) {
        if(answer == null){
            return "Incorrect";
        }
        if(Integer.parseInt(answer) == this.correctAnswer){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }
    public int compareTo(Object o) {
        if(o instanceof  MultipleChoice) {
            MultipleChoice q = (MultipleChoice) o;
            if (this.questionText.compareTo(q.getText()) < 0) {
                return -1;
            } else if (this.questionText.compareTo(q.getText()) == 0) {
                return 0;
            } else {
                return 1;
            }
        }else if (o instanceof MultipleSelect || o instanceof Likert){
            return -1;
        }else if (o instanceof TrueFalse){
            return 1;
        }else {
            throw new IllegalArgumentException();
        }
    }
}

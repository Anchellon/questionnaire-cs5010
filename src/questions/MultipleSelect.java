package questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultipleSelect implements Question{
    String questionText;
    Set<Integer> correctAnswers = new HashSet<>();
    List<String> options = new ArrayList<>();

    public MultipleSelect(String questionText,String correctAnswers, String opt1, String opt2, String opt3) throws NumberFormatException{

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswers = parseSet(correctAnswers);


    }



    public MultipleSelect(String questionText,String correctAnswers, String opt1, String opt2, String opt3,String opt4){

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswers = parseSet(correctAnswers);
    }
    public MultipleSelect(String questionText,String correctAnswers, String opt1, String opt2, String opt3,String opt4, String opt5){

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswers = parseSet(correctAnswers);
    }
    public MultipleSelect(String questionText,String correctAnswers, String opt1, String opt2, String opt3,String opt4, String opt5, String opt6){

        options.add(opt1);
        options.add(opt2);
        options.add(opt3);
        options.add(opt4);
        options.add(opt5);
        options.add(opt6);
        parseOptionsAndQuestionText(questionText);
        this.questionText = questionText;
        this.correctAnswers = parseSet(correctAnswers);
    }
    public MultipleSelect(String questionText,String correctAnswers, String opt1,
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
        this.correctAnswers = parseSet(correctAnswers);
    }
    public MultipleSelect(String questionText,String correctAnswers, String opt1,
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
        this.correctAnswers = parseSet(correctAnswers);
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

    private Set<Integer> parseSet(String answers) {
        String[] options = answers.split("\\s+");
        Set<Integer> resultSet = new HashSet<>();
        for(String val : options){
            Integer option = Integer.parseInt(val);
            if(option <= options.length && option > 0){
                resultSet.add(option);
            }
        }
        return resultSet;
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
        Set<Integer> userAnswer = parseSet(answer);
        if(userAnswer.equals(correctAnswers)){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }

    @Override
    public int compareTo(Object o) {
        if( o instanceof MultipleSelect) {
            MultipleSelect q = (MultipleSelect) o;
            if (this.questionText.compareTo(q.getText()) < 0) {
                return -1;
            } else if (this.questionText.compareTo(q.getText()) == 0) {
                return 0;
            } else {
                return 1;
            }
        }else if( o instanceof Likert){
            return -1;
        }else if(o instanceof MultipleChoice || o instanceof TrueFalse){
            return 1;
        }else {
            throw new IllegalArgumentException();
        }
    }
}

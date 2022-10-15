package questions;

public class TrueFalse implements Question{
    String questionText;
    boolean correctAnswer;
    public TrueFalse(String questionText, String correctAnswer) throws IllegalArgumentException{
        if(questionText.trim() == "" || questionText == null || correctAnswer == null){
            throw new IllegalArgumentException();
        }else{
            this.questionText = questionText;
        }
        if(correctAnswer.trim() == "True"){
            this.correctAnswer = true;
        }else if (correctAnswer.trim() == "False"){
            this.correctAnswer = false;
        }else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getText() {
        return questionText;
    }

    @Override
    public String answer(String answer) {
        boolean userAnswer = false;
        if(answer == null){
            return "Incorrect";
        }

        if(answer.trim() == "True"){
            userAnswer = true;
        } else if (answer.trim() == "False") {
            userAnswer = false;
        }
        if( userAnswer == correctAnswer){
            return "Correct";
        }else{
            return "Incorrect";
        }
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof TrueFalse) {
            TrueFalse q = (TrueFalse) o;
            if (this.questionText.compareTo(q.getText()) < 0) {
                return -1;
            } else if (this.questionText.compareTo(q.getText()) == 0) {
                return 0;
            } else {
                return 1;
            }
        }else if (o instanceof MultipleSelect ||o instanceof MultipleChoice || o instanceof Likert){
            return -1;
        }else {
            throw new IllegalArgumentException();
        }
    }
}

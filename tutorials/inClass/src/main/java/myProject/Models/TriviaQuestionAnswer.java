package myProject.Models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Entity
public class TriviaQuestionAnswer {

    @NotNull
    boolean isAnswerCorrect;

    @ManyToOne
    TriviaQuestion triviaQuestion;

    @Column(unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //I don't remember why I put this here, it might not be needed as we can access through triviaQuestion?
    @NotEmpty
    String question;
    /**
     * Default constructor
     */
    public TriviaQuestionAnswer(){}
    /**
     * Constructor
     * @param triviaQuestion - Trivia question obj
     * @param question - Trivia Question
     * @param isAnswerCorrect - Is trivia question correct
     */
    public TriviaQuestionAnswer(TriviaQuestion triviaQuestion, String question, boolean isAnswerCorrect){
        this.triviaQuestion = triviaQuestion;
        this.question = question;
        this.isAnswerCorrect = isAnswerCorrect;
    }
    /**
     * Getter for id
     * @return id
     */
    public Integer getId() {
        return id;
    }
    /**
     * Setter for id 
     * @param id - set TriviaQuestionAnswer Id
     */
    public void setid(Integer id){
        this.id = id;
    }
    /**
     * Getter for triviaQuestion
     * @return triviaQuestion
     */
    public TriviaQuestion getTriviaQuestion(){
        return this.triviaQuestion;
    }
    /**
     * Setter for triviaQuestion
     * @param triviaQuestion - TriviaQuestion obj
     */
    public void setTriviaQuestion(TriviaQuestion triviaQuestion) {
        this.triviaQuestion = triviaQuestion;
    }
    /**
     * Getter for question
     * @return question
     */
    public String getQuestion(){
        return this.question;
    }
    /**
     * Setter for question
     * @param question - set given trivia question
     */
    public void setQuestion(String question){
        this.question = question;
    }
    /**
     * Getter for isAnswerCorrect
     * @return isAnswerCorrect
     */
    public boolean getIsAnswerCorrect(){
        return isAnswerCorrect;
    }
    /**
     * Setter for isAnswerCorrect 
     * @param isAnswerCorrect - set is answer correct
     */
    public void setIsAnswerCorrect(boolean isAnswerCorrect){
        this.isAnswerCorrect = isAnswerCorrect;
    }

}

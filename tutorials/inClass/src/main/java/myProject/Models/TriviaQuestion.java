package myProject.Models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * 
 * @author Thomas McCoy & Noah Hoss
 *
 */
@Entity
public class TriviaQuestion {

	@Id
	@Column(unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	@Length(min = 4, max = 200, message = "The trivia question should be between 4 and 200 characters.")
	@NotNull(message = "Question not provided")
	@Column
	String triviaQuestion;

	String triviaAnswer;

	@NotEmpty
	@Column
	String category;

	@OneToOne
	User createdByUser;

	@OneToMany
	List<TriviaQuestion> triviaQuestionPool;

	//Not sure if String is what is needed here or not
	@ElementCollection(targetClass = String.class)
	Set<TriviaQuestionAnswer> answers = new HashSet<>(0);

	/**
	 * Default constructor
	 */
	public TriviaQuestion(){}

	/**
	 * Constructor for jeopardy-esque game supplied with two strings
	 * @param triviaQuestion - Current trivia Question
	 * @param  triviaAnswer - Current trivia Answer
	 */
	public TriviaQuestion(String triviaQuestion, String triviaAnswer){
		this.triviaQuestion = triviaQuestion;
		this.triviaAnswer = triviaAnswer;
	}

	/**
	 * Constructor for jeopardy-esque game supplied with a trivia question pool
	 * @param triviaQuestionPool - pool of all trivia questions for game
	 */
	public TriviaQuestion(List<TriviaQuestion> triviaQuestionPool){
		this.triviaQuestionPool = triviaQuestionPool;
	}

	/**
	 * Constructor 
	 * @param triviaQuestion - set current trivia question
	 */
	public TriviaQuestion(String triviaQuestion){
		this.triviaQuestion = triviaQuestion;
	}
	/**
	 * Constructor
	 * @param triviaQuestion - Trivia question
	 * @param answers - set of trivia question answers
	 */
	public TriviaQuestion(String triviaQuestion, Set<TriviaQuestionAnswer> answers){
		this.triviaQuestion = triviaQuestion;
		this.answers = answers;
	}
	/**
	 * Getter for answers
	 * @return answers 
	 */
	public Set<TriviaQuestionAnswer> getAnswers() {
		return this.answers;
	}
	/**
	 * Setter for answers
	 * @param answers - set of answers to set to current tiriva question.
	 */
	public void setAnswers(Set<TriviaQuestionAnswer> answers) {
		this.answers = answers;
	}
	/**
	 * Getter for id
	 * @return id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * Getter for trivia questions 
	 * @return triviaQuestion
	 */
	public String getTriviaQuestion() {
		return triviaQuestion;
	}
	/**
	 * Getter for categories
	 * @return category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * Setter for categories
	 * @param category - trivia question category to set for current trivia question
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * Setter for trivia questions 
	 * @param triviaQuestion - trivia question to set as current trivia question
	 */
	public void setTriviaQuestion(String triviaQuestion) {
		this.triviaQuestion = triviaQuestion;
	}

	public String getTriviaAnswer() {
		return triviaAnswer;
	}

	public void singleAddToTriviaQuestionPool(TriviaQuestion triviaQuestion){
		this.triviaQuestionPool.add(triviaQuestion);
	}

	public void multiAddToTriviaQuestionPool(List<TriviaQuestion> triviaQuestionPool){
		this.triviaQuestionPool.addAll(triviaQuestionPool);
	}

	public List<TriviaQuestion> getTriviaQuestionPool() {
		return triviaQuestionPool;
	}
}

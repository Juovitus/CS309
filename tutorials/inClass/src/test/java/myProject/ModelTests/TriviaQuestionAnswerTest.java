package myProject.ModelTests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import myProject.Models.TriviaQuestion;
import myProject.Models.TriviaQuestionAnswer;
import org.junit.Test;
/**
 * 
 * @author Noah Hoss
 *
 */
public class TriviaQuestionAnswerTest {
    private static final boolean ANSWER_TRUE_TEST = true;
    private static final boolean ANSWER_FALSE_TEST = false;
    private static final TriviaQuestion TRIVIA_QUESTION_TEST = new TriviaQuestion("Does this work?");
    private static final Integer TRIVIA_QUESTION_ANSWER_ID_TEST = 1;
    /**
     * Mock then check if answer is correct
     */
    @Test
    public void testTriviaAnswerTrue(){
        TriviaQuestionAnswer mockedReturner = mock(TriviaQuestionAnswer.class);
        when(mockedReturner.getIsAnswerCorrect()).thenReturn(ANSWER_TRUE_TEST);
        assertEquals(mockedReturner.getIsAnswerCorrect(), ANSWER_TRUE_TEST);
    }
    /**
     * Mock then check if answer is false
     */
    @Test
    public void testTriviaAnswerFalse(){
        TriviaQuestionAnswer mockedReturner2 = mock(TriviaQuestionAnswer.class);
        when(mockedReturner2.getIsAnswerCorrect()).thenReturn(ANSWER_FALSE_TEST);
        assertEquals(mockedReturner2.getIsAnswerCorrect(), ANSWER_FALSE_TEST);
    }
    /**
     * Mock then check getTriviaQuestion
     */
    @Test
    public void testTriviaQuestion(){
        TriviaQuestionAnswer mockedReturner3 = mock(TriviaQuestionAnswer.class);
        when(mockedReturner3.getTriviaQuestion()).thenReturn(TRIVIA_QUESTION_TEST);
        assertEquals(mockedReturner3.getTriviaQuestion(), TRIVIA_QUESTION_TEST);
    }
    /**
     * Mock then check getId
     */
    @Test
    public void testTriviaQuestionAnswerId(){
        TriviaQuestionAnswer mockedReturner3 = mock(TriviaQuestionAnswer.class);
        when(mockedReturner3.getId()).thenReturn(TRIVIA_QUESTION_ANSWER_ID_TEST);
        assertEquals(mockedReturner3.getId(), TRIVIA_QUESTION_ANSWER_ID_TEST);
    }

}

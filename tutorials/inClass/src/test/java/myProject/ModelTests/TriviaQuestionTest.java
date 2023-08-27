package myProject.ModelTests;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import myProject.Models.TriviaQuestion;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Thomas McCoy
 *
 */
public class TriviaQuestionTest {
	private static final Integer TRIVIA_QUESTION_ID_TEST = 15;
	private static final String TRIVIA_QUESTION_TEST = "Trivia Question Text";
	private static final String TRIVIA_QUESTION_CATEGORY_TEST = "General Knowledge";

	@Mock
	List<TriviaQuestion> mockList = new ArrayList<>();

	/**
	 * Mock then test getId
	 */
	@Test
	public void testId(){
		TriviaQuestion mockedReturner = mock(TriviaQuestion.class);
		when(mockedReturner.getId()).thenReturn(TRIVIA_QUESTION_ID_TEST);
		assertEquals(mockedReturner.getId(), TRIVIA_QUESTION_ID_TEST);
	}
	/**
	 * Mock then test getTriviaQuestion
	 */
	@Test
	public void testTriviaQuestion(){
		TriviaQuestion mockedReturner2 = mock(TriviaQuestion.class);
		when(mockedReturner2.getTriviaQuestion()).thenReturn(TRIVIA_QUESTION_TEST);
		assertEquals(mockedReturner2.getTriviaQuestion(), TRIVIA_QUESTION_TEST);
	}
	/**
	 * Mock then test getCategory
	 */
	@Test
	public void testCategory(){
		TriviaQuestion mockedReturner3 = mock(TriviaQuestion.class);
		when(mockedReturner3.getCategory()).thenReturn(TRIVIA_QUESTION_CATEGORY_TEST);
		assertEquals(mockedReturner3.getCategory(), TRIVIA_QUESTION_CATEGORY_TEST);
	}

	/**
	 * Mock then test getTriviaQuestionPool
	 */
	@Test
	public void testTriviaQuestionPool(){
		TriviaQuestion mockTQ = new TriviaQuestion("Question");
		mockList.add(mockTQ);
		assertEquals("Question", mockList.get(0).getTriviaQuestion());
	}

}

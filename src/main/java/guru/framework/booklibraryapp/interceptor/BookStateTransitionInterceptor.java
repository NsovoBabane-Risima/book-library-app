package guru.framework.booklibraryapp.interceptor;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.support.StateMachineInterceptorAdapter;
import org.springframework.statemachine.transition.Transition;
import org.springframework.stereotype.Component;

import guru.framework.booklibraryapp.domain.Book;
import guru.framework.booklibraryapp.domain.BookEvent;
import guru.framework.booklibraryapp.domain.BookState;
import guru.framework.booklibraryapp.repositories.BookRepository;
import guru.framework.booklibraryapp.services.BookService;
import guru.framework.booklibraryapp.services.BookServiceImpl;
import lombok.RequiredArgsConstructor;
@Component
@RequiredArgsConstructor
public class BookStateTransitionInterceptor extends StateMachineInterceptorAdapter<BookState, BookEvent>{
	private final BookRepository bookRepository;
	@Override
	public void preStateChange(State<BookState, BookEvent> state, Message<BookEvent> message,
			Transition<BookState, BookEvent> transition, StateMachine<BookState, BookEvent> stateMachine,
			StateMachine<BookState, BookEvent> rootStateMachine) {
		
		Book book = bookRepository.getOne(Long.class.cast(message.getHeaders().getOrDefault(BookServiceImpl.BOOK_ID_HEADER, 5L)));
		
		if(book != null) {
			
		
		}
	}

}

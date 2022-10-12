package guru.framework.booklibraryapp.config;

import java.util.EnumSet;

import org.aspectj.weaver.ast.And;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import guru.framework.booklibraryapp.domain.BookEvent;
import guru.framework.booklibraryapp.domain.BookState;

@Configuration
public class BookStateMachineConfig extends StateMachineConfigurerAdapter<BookState, BookEvent> {

	@Override
	public void configure(StateMachineStateConfigurer<BookState, BookEvent> states) throws Exception {

		states.withStates().initial(BookState.AVAILABLE).and().withStates().states(EnumSet.allOf(BookState.class))
				.end(BookState.OUT_OF_STOCK).end(BookState.IN_REPAIR);

	}

	@Override
	public void configure(StateMachineTransitionConfigurer<BookState, BookEvent> transitions) throws Exception {
		transitions.withExternal().source(BookState.AVAILABLE).target(BookState.AVAILABLE).event(BookEvent.BORROW_REQUEST_APPROVED)
		.and().withExternal().source(BookState.AVAILABLE).target(BookState.BORROWED).event(BookEvent.BORROW_REQUEST_APPROVED)
		.and().withExternal().source(BookState.AVAILABLE).target(BookState.AVAILABLE).event(BookEvent.BORROW_REQUEST_DECLINED)
		.and().withExternal().source(BookState.BORROWED).target(BookState.OUT_OF_STOCK).event(BookEvent.OUT_OF_STOCK_EVENT);
		
	}
	
	

}

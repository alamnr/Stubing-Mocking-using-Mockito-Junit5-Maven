/**
 * @author DELL
 */

package com.in28Minutes.business;

import com.in28Minutes.data.api.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoBusinessImpl_InjectMockTest {

    @Mock
    TodoService todoServiceMock;  // TodoService todoServiceMock = mock(TodoService.class);

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;  // TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    void retrieveTodosUsingMock(){

        List<String> todos = Arrays.asList("Learn Spring Mvc","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filtersTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filtersTodos.size());
    }

    @Test
    void retrieveTodosUsingMock_withEmptyList(){

        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filtersTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0,filtersTodos.size());
    }


    @Test
    void letsTestDeleteNow(){
        List<String> todos = Arrays.asList("Learn Spring Mvc","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(todos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
        verify(todoServiceMock).deleteTodo("Learn to Dance");
        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }
    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        Mockito.when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);
        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
        Mockito.verify(todoServiceMock).deleteTodo(argumentCaptor.capture());

        assertEquals("Learn to Dance", argumentCaptor.getValue());
    }
}

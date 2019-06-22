/**
 * @author DELL
 */

package com.in28Minutes.business;

import com.in28Minutes.data.api.TodoService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {

    @Test
    void retrieveTodosUsingMock(){
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> todos = Arrays.asList("Learn Spring Mvc","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filtersTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filtersTodos.size());
    }

    @Test
    void retrieveTodosUsingMock_withEmptyList(){
        TodoService todoServiceMock = mock(TodoService.class);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
        List<String> filtersTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(0,filtersTodos.size());
    }
}

/**
 * @author DELL
 */

package com.in28Minutes.business;

import com.in28Minutes.data.api.TodoService;

import java.util.List;
import java.util.stream.Collectors;

// Here SUT (System Under Test) -  TodoBusinessImpl
// Dependency - Todo Service
// We will write unit test using Stub and also understand its disadvantage
// to overcome the stub shortcomings we will use Mockito to make unit testing more dynamic and flexible

public class TodoBusinessImpl {

    private final TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user)
    {
      return todoService.retrieveTodos(user).stream().filter(todo -> todo.contains("Spring")).collect(Collectors.toList());
    }
}

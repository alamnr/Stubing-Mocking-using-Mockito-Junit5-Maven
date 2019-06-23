/**
 * @author DELL
 */

package com.in28Minutes.data.api;

import java.util.List;

// Create a TodoServiceStub
// Test TodoBusinessImpl using TodoServiceStub
public interface TodoService {
    public List<String> retrieveTodos(String user);
    void deleteTodo(String todo);
}

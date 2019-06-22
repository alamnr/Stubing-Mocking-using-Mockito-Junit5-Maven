/**
 * @author DELL
 */

package com.in28Minutes.data.api;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring Mvc","Learn Spring","Learn to Dance");
    }
}

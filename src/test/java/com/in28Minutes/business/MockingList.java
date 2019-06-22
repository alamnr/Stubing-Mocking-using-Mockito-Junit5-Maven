/**
 * @author DELL
 */

package com.in28Minutes.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockingList {
    @Test
    void letMockListSizeMethod(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2,mockList.size());
    }

    @Test
    void letMockListSizeMethodAndReturnMultipleValues(){
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2).thenReturn(0).thenReturn(1);
        assertEquals(2,mockList.size());
        assertEquals(0,mockList.size());
        assertEquals(1,mockList.size());

    }

    @Test
    void letMockListGetMethod(){
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("in28Minute");
        assertEquals("in28Minute",mockList.get(0));
        assertEquals(null,mockList.get(1));

    }

    @Test
    void letMockListGetMethod_usingMatcher(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("in28Minute");
        assertEquals("in28Minute",mockList.get(0));
        assertEquals("in28Minute",mockList.get(1));

    }

    @Test
    void letMockListGetMethod_ThrowsException(){
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenThrow(new RuntimeException("something"));

       // assertEquals("in28Minute",mockList.get(0));
        assertThrows(RuntimeException.class,()->mockList.get(0));

    }
}

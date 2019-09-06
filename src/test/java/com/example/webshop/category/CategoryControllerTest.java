package com.example.webshop.category;
import org.junit.Test;
import static org.junit.Assert.*;

public class CategoryControllerTest {

    @Test
    public void categories() {
        CategoryType categoryType [] = {CategoryType.BOOK, CategoryType.EBOOK, CategoryType.AUDIOBOOK, CategoryType.PRESS,
                CategoryType.OTHER};
        assertEquals(categoryType, CategoryType.values());
    }
}
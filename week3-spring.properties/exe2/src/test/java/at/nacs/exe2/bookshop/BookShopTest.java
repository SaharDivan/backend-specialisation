package at.nacs.exe2.bookshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookShopTest {
    @Autowired
    BookShop bookShop;


    @Test
    void getShelf(){

        Set<Map.Entry<String, Integer>> entries = bookShop.getShelf().entrySet();
        System.out.println(entries);

    }


}
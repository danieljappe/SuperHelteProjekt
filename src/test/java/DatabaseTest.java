import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    private Database database;

    @BeforeEach
            void beforeEach() {
        // Arrange
        database = new Database();

        // Act
        database.createSuperhelt("Batman", "Money", "Ja", 1965, 2);
        database.createSuperhelt("Superman", "Kan flyve", "Nej", 1922, 50);
        database.createSuperhelt("Spider-man", "Edderkoppekrafter", "Ja", 1946, 4);

    }


    @Disabled
    void createSuperhelt() {
        // Act
        database.createSuperhelt("Iron Man", "Dragt", "Ja", 1956, 2);


    }

    @Test
    void searchForSingleResult() {
        List<Superhelt> results = database.searchFor("superman");

        int actualSize = results.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);

    }

    @Test
    void searchForMultiple() {
        List<Superhelt> results = database.searchFor("man");

        int actualSize = results.size();
        int expectedSize = 3;

        assertEquals(actualSize, expectedSize);
    }

    @Test
    void searchForNoResult() {
        List<Superhelt> results = database.searchFor("Nothing");

        int actualSize = results.size();
        int expectedSize = 0;

        assertEquals(actualSize, expectedSize);
    }

    @Test
    void searchForCase() {
        List<Superhelt> results = database.searchFor("sUpERMan");

        int actualSize = results.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);

    }

    @Test
    void searchForWhitespace() {
        List<Superhelt> results = database.searchFor("    superman   ");

        int actualSize = results.size();
        int expectedSize = 1;

        assertEquals(actualSize, expectedSize);

    }

    @Test
    void deleteSuperHero() {
        List<Superhelt> results = database.getSuperhelteArrayList();
        Superhelt superhero = results.get(0);
        int expectedSize = results.size() - 1;

        boolean actualResult = database.deleteSuperhero(superhero);
        boolean expectedResult = true;

        assertEquals(actualResult, expectedResult);

        ArrayList<Superhelt> resultsAfterDelete = database.getSuperhelteArrayList();
        int actualSize = resultsAfterDelete.size();

        assertEquals(expectedSize, actualSize);

    }
}
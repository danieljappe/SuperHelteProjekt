import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Database database = new Database();

    @Test
    void createSuperhelt() {

        database.createSuperhelt("Batman", "Money", "Ja", 1965, 2);
        database.createSuperhelt("Superman", "Kan flyve", "Nej", 1922, 50);
        database.createSuperhelt("Spider-man", "Edderkoppekrafter", "Ja", 1946, 4);

        int expectedDBSize = 3;
        int actualSize = database.getSuperhelteArrayList().size();
        assertEquals(expectedDBSize,actualSize);
    }

    @Test
    void searchFor() {
        int expectedSize = 3;
        String searchTerm = "man";

        database.createSuperhelt("Batman", "Money", "Ja", 1965, 2);
        database.createSuperhelt("Superman", "Kan flyve", "Nej", 1922, 50);
        database.createSuperhelt("Spider-man", "Edderkoppekrafter", "Ja", 1946, 4);

        ArrayList<Superhelt> søgeResultat = database.searchFor(searchTerm);
        int arraySize = søgeResultat.size();

        assertEquals(expectedSize,arraySize);

    }

}
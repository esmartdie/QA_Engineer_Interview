package PetStoreTest;

import org.testng.annotations.Test;
import petStore.DataRetriever;


public class DataRetrieverTest {
    @Test
    public void testGetUserData() {
        // Crear un objeto DataRetriever
        DataRetriever dataRetriever = new DataRetriever("DiegoM");

        // Llamar al método getUserData
        dataRetriever.getUserData();

    }

}

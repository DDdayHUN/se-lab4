package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireFailedNoTorpedoesInStore() {
        // Arrange
        TorpedoStore store = new TorpedoStore(0);

        // Assert
        assertThrows(IllegalArgumentException.class, () -> store.fire(2));
    }

    @Test
    void isEmpty() {
        // Arrange
        TorpedoStore store1 = new TorpedoStore(0);
        TorpedoStore store2 = new TorpedoStore(1);

        // Assert
        assertEquals(true, store1.isEmpty());
        assertEquals(false, store2.isEmpty());
    }

    @Test
    void getCount() {
        // Arrange
        TorpedoStore store1 = new TorpedoStore(0);
        TorpedoStore store2 = new TorpedoStore(5);

        // Assert
        assertEquals(0, store1.getTorpedoCount());
        assertEquals(5, store2.getTorpedoCount());
    }

    @Test
    void failure() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1, 1.0);

        // Assert
        assertEquals(false, store.fire(1));
    }
}

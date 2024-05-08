import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SaboteurTest {

    @Test
    void testPunctureOnWorkingPipe() {
        // Create an instance of Saboteur
        Saboteur saboteur = new Saboteur("TestPlayer");

        // Mock the currentElement object (a working Pipe)
        Element currentElementMock = mock(Pipe.class);
        when(currentElementMock.getName()).thenReturn("TestPipe");
        when(currentElementMock.getWorks()).thenReturn(true);

        // Set the currentElement for the Saboteur instance
        saboteur.currentElement = currentElementMock;

        // Call the puncture() method
        saboteur.puncture();

        // Verify that the currentElement's setWorks() method is called with false
        verify(currentElementMock).setWorks(false);
    }

    @Test
    void testPunctureOnAlreadyPuncturedPipe() {
        // Create an instance of Saboteur
        Saboteur saboteur = new Saboteur("TestPlayer");

        // Mock the currentElement object (a punctured Pipe)
        Element currentElementMock = mock(Pipe.class);
        when(currentElementMock.getName()).thenReturn("TestPipe");
        when(currentElementMock.getWorks()).thenReturn(false);

        // Set the currentElement for the Saboteur instance
        saboteur.currentElement = currentElementMock;

        // Call the puncture() method
        saboteur.puncture();

        // Verify that no interaction occurs with currentElement's setWorks() method
        verify(currentElementMock, never()).setWorks(anyBoolean());
    }

    @Test
    void testPunctureOnNonPipeElement() {
        // Create an instance of Saboteur
        Saboteur saboteur = new Saboteur("TestPlayer");

        // Mock the currentElement object (not a Pipe)
        Element currentElementMock = mock(Element.class);
        when(currentElementMock.getName()).thenReturn("TestElement");

        // Set the currentElement for the Saboteur instance
        saboteur.currentElement = currentElementMock;

        // Call the puncture() method
        saboteur.puncture();

        // Verify that no interaction occurs with currentElement's setWorks() method
        verify(currentElementMock, never()).setWorks(anyBoolean());
    }
}

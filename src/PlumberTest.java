import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlumberTest {

    @Test
    void testFixPipe() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of Plumber
        Plumber plumber = new Plumber("TestPlayer");

        // Mock the currentElement object
        Element currentElementMock = mock(Pipe.class);
        when(currentElementMock.getName()).thenReturn("TestPipe");
        when(currentElementMock.getWorks()).thenReturn(false);

        // Set the currentElement for the Plumber instance
        plumber.currentElement = currentElementMock;

        // Call the fixPipe() method
        plumber.fixPipe();

        // Verify that the currentElement's setWorks() method is called with true
        verify(currentElementMock).setWorks(true);

        // Verify that the expected output is printed
        assertEquals("TestPlayer fixed TestPipe\n", outputStream.toString());

        // Restore System.out
        System.setOut(System.out);
    }

    @Test
    void testFixPump() {
        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Create an instance of Plumber
        Plumber plumber = new Plumber("TestPlayer");

        // Mock the currentElement object
        Element currentElementMock = mock(Pump.class);
        when(currentElementMock.getName()).thenReturn("TestPump");
        when(currentElementMock.getWorks()).thenReturn(false);

        // Set the currentElement for the Plumber instance
        plumber.currentElement = currentElementMock;

        // Call the fixPump() method
        plumber.fixPump();

        // Verify that the currentElement's setWorks() method is called with true
        verify(currentElementMock).setWorks(true);

        // Verify that the expected output is printed
        assertEquals("TestPlayer fixed TestPump\n", outputStream.toString());

        // Restore System.out
        System.setOut(System.out);
    }
}

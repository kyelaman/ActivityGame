package game;

import java.util.List;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class GetAllAvatarsTest {

    public GetAllAvatars getAllAvatars;

    @Before
    public void init() {
        getAllAvatars = new GetAllAvatars();
    }

    @Test
    public void getAvatarFromStringTestForValidArgument() {
        assertEquals(Bike.class, getAllAvatars.getAvatarFromString("Bike").getClass());
    }

    @Test
    public void getAvatarFromStringTestForInvalidArgument() {
        assertNull(getAllAvatars.getAvatarFromString("Bicycle"));
    }

    @Test
    public void getOrderOfAvatarsTestForFileNotPresent() {
        try {
            getAllAvatars.getOrderOfAvatars("Test.txt");
            fail("File is not present. Need to throw Exception");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

	@Test
	public void getOrderOfAvatarsTestForCorrectFile(){
		List<Avatar> listOfAvatars = getAllAvatars.getOrderOfAvatars("Avatars.txt");
		assertTrue(listOfAvatars.get(0) instanceof Bike);
		assertTrue(listOfAvatars.get(1) instanceof Car);	
	}
	
	@Test
	public void getOrderOfAvatarsTestForCorrectFileWithInvalidClassNames(){
		List<Avatar> listOfAvatars = getAllAvatars.getOrderOfAvatars("TestInput.txt");
		assertTrue(listOfAvatars.get(0) instanceof Bike);
		assertTrue(listOfAvatars.get(1) instanceof Car);	
		assertTrue(listOfAvatars.get(2) instanceof Bike);	
	}
}

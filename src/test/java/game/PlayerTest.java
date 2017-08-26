package game;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class PlayerTest {

    private Player player;
    List<Avatar> avatarList;
    Bike bikeA;
	Bike bikeB;
	Bike bikeC;
	Car carSpy;
	Plane planeSpy;
	Rocket rocketSpy;

    @Before
    public void setUp(){
        bikeA = new Bike();
		bikeB = new Bike();
		bikeC = new Bike();
		
		avatarList = Arrays.asList(bikeA, bikeB, bikeC);
        player = new Player(bikeA, avatarList);
    }

    @Test
    public void testPerformActionWhenCurrentStateBike()
    {
        bikeA = spy((Bike) avatarList.get(0));
        player = new Player(bikeA, avatarList);
        player.performAction();
        verify(bikeA, times(1)).performAction();
    }
	
	@Test
    public void testPerformActionWhenCurrentStateCar()
    {
        Car carSpy = spy(new Car());
		avatarList = Arrays.asList(carSpy);
        player = new Player(carSpy, avatarList);
        player.performAction();
        verify(carSpy).performAction();
    }
	
	@Test
    public void testPerformActionWhenCurrentStatePlane()
    {
        Plane planeSpy = spy(new Plane());
		avatarList = Arrays.asList(planeSpy);
        player = new Player(planeSpy, avatarList);
        player.performAction();
        verify(planeSpy).performAction();
    }
	
	@Test
    public void testPerformActionWhenCurrentStateRocket()
    {
        Rocket rocketSpy = spy(new Rocket());
		avatarList = Arrays.asList(rocketSpy);
        player = new Player(rocketSpy, avatarList);
        player.performAction();
        verify(rocketSpy).performAction();
    }

    @Test
    public void testTransformStateFromBikeAToBikeCUsingBackward()
    {
        player.transformAvatar(Player.Direction.valueOf("BACKWARD"));
        assertEquals(bikeC, player.getCurrentAvatar());
    }

    @Test
    public void testTransformStateFromBikeAToBikeBUsingForward()
    {
        player.transformAvatar(Player.Direction.valueOf("FORWARD"));
        assertEquals(bikeB, player.getCurrentAvatar());
    }

    @Test
	public void testTransformStateFromBikeAtoBikeAUsingForward()
	{
		player.transformAvatar(Player.Direction.valueOf("FORWARD"));
		player.transformAvatar(Player.Direction.valueOf("FORWARD"));
		player.transformAvatar(Player.Direction.valueOf("FORWARD"));
		assertEquals(bikeA, player.getCurrentAvatar());
	}
	
	@Test
	public void testTransformStateFromBikeAtoBikeAUsingBackward()
	{
		player.transformAvatar(Player.Direction.valueOf("BACKWARD"));
		player.transformAvatar(Player.Direction.valueOf("BACKWARD"));
		player.transformAvatar(Player.Direction.valueOf("BACKWARD"));
		assertEquals(bikeA, player.getCurrentAvatar());
	}
	
}
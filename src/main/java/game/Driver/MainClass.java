package game.Driver;

import game.Avatar;
import game.GetAllAvatars;
import game.Player;

import java.io.IOException;
import java.util.List;

public class MainClass {
    public static void main(String args[]) throws IOException
    {
        GetAllAvatars getAvatarsClass = new GetAllAvatars();
        List<Avatar> avatarsList = null;

        avatarsList = getAvatarsClass.getOrderOfAvatars("Avatars.txt");
        Player player = new Player(avatarsList.get(0), avatarsList);

        System.out.println("Calling performAction on " + player.getCurrentAvatar().getClass());
        player.performAction();
        player.transformAvatar(Player.Direction.BACKWARD);
        player.performAction();
        System.out.println("Calling performAction on " + player.getCurrentAvatar().getClass());
    }
}

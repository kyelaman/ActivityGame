package game;

import java.util.List;

public class Player {

    private Avatar currentAvatar;
    private List<Avatar> avatarList;

    public enum Direction{
        FORWARD, BACKWARD
    };

    public Player(Avatar avatar, List<Avatar> allAvatars)
    {
        currentAvatar = avatar;
        avatarList = allAvatars;
    }

    public void performAction()
    {
        currentAvatar.performAction();
    }

    public void transformAvatar(Direction direction)

    {
        int totalNumberOfAvatars = avatarList.size();
        int currentAvatarIndex = avatarList.indexOf(currentAvatar);
        int nextIndex = 0;
        if(direction.equals(Direction.BACKWARD))
            nextIndex = (currentAvatarIndex - 1 + totalNumberOfAvatars) % totalNumberOfAvatars;
        else
            nextIndex = (currentAvatarIndex + 1 + totalNumberOfAvatars) % totalNumberOfAvatars;
        currentAvatar = avatarList.get(nextIndex);
    }

    public Avatar getCurrentAvatar()
    {
        return currentAvatar;
    }

}
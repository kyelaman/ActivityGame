package game;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;
import java.util.stream.Collectors;

public class GetAllAvatars {

    public List<Avatar> getOrderOfAvatars(String path) {

	try{
        List<String> getSequenceOfStrings = Files.lines(Paths.get(path)).collect(Collectors.toList());
        
        return getSequenceOfStrings.stream()
                                   .map(s -> getAvatarFromString(s))
                                   .filter(s -> s != null)
                                   .collect(Collectors.toList());
	}
	catch(Exception ex){
		throw new RuntimeException("File Not Found Exception");
	}
    }

    public Avatar getAvatarFromString(String avatarString) {
        try {
            return (Avatar) Class.forName("game." + avatarString).newInstance();
        } catch (Exception e) {
            return null;
        }

    }

}
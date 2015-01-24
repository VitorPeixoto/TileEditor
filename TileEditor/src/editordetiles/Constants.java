package editordetiles;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 *
 * @author Peixoto
 */
public interface Constants {
    public final char slash = System.getProperty("file.separator").charAt(0);
    public final String userHome = System.getProperty("user.home");
    public final String applicationFolder = userHome+slash+"Editor de Tiles"+slash;
    
    public final String imagesFolder = applicationFolder+"Images"+slash;
    public final String tilesFolder = applicationFolder+"Tiles"+slash;
}

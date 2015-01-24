package editordetiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 *
 * @author Peixoto
 */
public class DataReader implements Serializable, Constants {    
    private static volatile DataReader singleData = null;
    private File dataFile;     
    private File exampleTileset, exampleTile;
    
    private ObjectInputStream objectIS;
    private ObjectOutputStream objectOS;    
    
    private DataReader() throws IOException, ClassNotFoundException {                                  
        dataFile = new File(applicationFolder+"data.ted");
        try {
            (new File(applicationFolder)).mkdirs();
            if(!dataFile.exists()) dataFile.createNewFile();
            (new File(imagesFolder)).mkdirs();
            exampleTileset = new File(URLDecoder.decode(getClass().getResource("/Images/tileset.png").getFile()));
            exampleTile = new File(URLDecoder.decode(getClass().getResource("/Tiles/TreeBase.tile").getFile()));
            copyExampleFiles();
            (new File(tilesFolder)).mkdirs();
        } catch(IOException ex) {                
            ex.printStackTrace();
        }            
        //write();
        //read();
    }    
    
    public static DataReader newDataReader() throws IOException, ClassNotFoundException {
        if(singleData == null) singleData = new DataReader();
        return singleData;
    }        
    
    public void write() throws NotInitiatedYetException, IOException {

    }
    
    public void write(String pngsDir, String tilesDir, String commonSaveDir, String lastFiles[]) throws NotInitiatedYetException, IOException {

    }
    
    public void read() throws ClassNotFoundException, IOException {        

    }

    public void copyExampleFiles() {
        InputStream inStream = null;
	OutputStream outStream = null;
 
    	try{    	    
    	    File tileset = new File(imagesFolder+exampleTileset.getName());
            File tile = new File(tilesFolder+exampleTile.getName());
            
    	    inStream = new FileInputStream(exampleTileset);
    	    outStream = new FileOutputStream(tileset);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){ 
    	    	outStream.write(buffer, 0, length);
    	    }
 
    	    inStream.close();
    	    outStream.close();
            
            inStream = new FileInputStream(exampleTile);
    	    outStream = new FileOutputStream(tile);
 
    	    buffer = new byte[1024];
 
    	    length = 0;
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0){ 
    	    	outStream.write(buffer, 0, length);
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	    System.out.println("Files were copied successful!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }    
    }
    
    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }  
    
}    

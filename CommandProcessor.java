import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class CommandProcessor{
    private static Controller control;
    private static String filename;
    private int hashSize;
    

    /**
     * 
     */
    public CommandProcessor(String name, int size) {
        this.filename = name;
        this.hashSize = size;
        control = new Controller(hashSize);
    }
    
    
    public void readNPrint() {
        Scanner sc;
        try {
            sc = new Scanner(new File(filename));
            Scanner scancmd;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                scancmd = new Scanner(line);
                String cmd = scancmd.next();
                System.out.println(cmd);
            }
            
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
  
        
        
   
    public static void beginParsingByLine() {
        String newline = System.lineSeparator(); 
        try {
           Scanner sc = new Scanner(new File(filename));
           Scanner scancmd;//Declare two scanners one to read the file and one to read the text pulled from the file
           while(sc.hasNextLine()) {//While we have text to read
              String line = sc.nextLine();//Get our next line
              scancmd = new Scanner(line);//Create a scanner from this line
              String cmd = scancmd.next();//Get the first word (the command) on each line
              String type;
              switch(cmd) {
                  case "insert"://In the case of insert change our delimiter from white space to <SEP> 
                     scancmd.useDelimiter("<SEP>");
                     String artist = scancmd.next();//Get the artist since it is before <SEP>
                     String song = scancmd.next();//Get the song title that follows <SEP>
                     String insertres = control.insert(artist,song);
                     System.out.println(insertres);
                  break;
                  case "remove":
                     type = scancmd.next();//Get the mode of deletion artist/song
                     String token = scancmd.nextLine();
                     String removeres = "";
                     //Since both artist titles and song titles have spaces
                     //get the rest of the line for the song/artist name
                     switch(type) {
                        case "artist":
                           removeres = control.remove(type, token);
                           System.out.println(removeres);
                        break;
                        case "song":
                            removeres = control.remove(type, token);
                           System.out.println(removeres);
                        break;
                        default ://Error bad token
                           System.out.println("Error bad remove type " + type);
                     }
                 break;
                 case "print"://Print command
                    String[] res;
                    int count = 0;
                    type = scancmd.next();//get the type of print command
                    switch(type) {
                       case "artist":
                          res = control.print("ARTIST");
                          if (res == null) {
                              count = 0;
                          } else {
                              count = res.length;
                              for (int i = 0; i < count; i++) {

                                  // Print array element present at index i
                                  System.out.print(res[i] + newline);
                              }
                          }
                          System.out.println("total artists: " + count);
                       break;
                       case "song":
                           res = control.print("SONG");
                           if (res == null) {
                               count = 0;
                           } else {
                               count = res.length;
                               for (int i = 0; i < count; i++) {

                                   // Print array element present at index i
                                   System.out.print(res[i] + newline);
                               }
                           }
                           System.out.println("total songs: " + count);
                       break;
                       case "blocks":
                           res = control.print("BLOCKS");
                           System.out.println(res);
                       break;
                       default:
                          System.out.println("Error bad print type " + type);
                       break;
                    }
                 break;
                 default :
                    System.out.println("Unrecognized input");
                 break;
              }
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
     }

}
public class Controller
{

    private Hash songHash;
    private Hash artistHash;
    private int tablesize;


    public Controller(int t)
    {
        this.tablesize = t;
        this.songHash = new Hash(tablesize);
        this.artistHash = new Hash(tablesize);
    }

    public String insert(String artist, String song) {
        String returnMessage = "";
        boolean artistInHash = artistHash.find(artist);
        boolean songInHash = songHash.find(artist);

        if (!artistInHash && songInHash) {
            artistHash.insert(artist);
            returnMessage = artist + " is added to the Artist database.";
          
        }
  
        if (!songInHash && artistInHash) {
            songHash.insert(song);
          returnMessage = song + " is added to the Song database.";
        }
      
        if (!(artistInHash &&  songInHash)){
        songHash.insert(song);
        artistHash.insert(artist);
        returnMessage = artist + " is added to the Artist database.\n " + song + " is added to the Song database.";
         
      }
     
      if (artistInHash && songInHash){
        returnMessage = "duplicates a record already in the database.";
      }
      
      return returnMessage;

    }
    
    public String remove(String type, String name) { 
        String returnMessage = "";
          if (type.equals("SONG")) {
              boolean songInHash = songHash.find(name);

              if (songInHash) {
                  songHash.delete(name);
                  returnMessage = name + "is removed from the Song database.";
              }
              else {
                returnMessage = name + "does not exist in Song database.";
                
              }
              }

          if (type.equals("ARTIST")) {
              boolean artistInHash = artistHash.find(name);

              if (artistInHash) {
                  artistHash.delete(name);
                  returnMessage = name + "is removed from the Artist database.";
              }
            else{
                  returnMessage = name + "does not exist in Artist database.";
              }
          }
          return returnMessage;
      }
    
    public String[] print(String type) {
        if (type.equals("ARTIST")) {
            return artistHash.displayEntries();
        }
        else if (type.equals("SONG")) {
            return songHash.displayEntries();
        } else {
            return null;
        }
    }

}

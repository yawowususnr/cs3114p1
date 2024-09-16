/**
 * Hash table class
 *
 * @author <Put Something Here>
 * @version <Put Something Here>
 */

public class Hash {
    
    
    private Record[] table;
    private int recordCount;
    private Record tombstone;
    
    public Hash (int initialCapacity) {
        this.recordCount = 0;
        this.table = new Record[initialCapacity];
        this.tombstone = new Record("TOMBSTONE");
    }

    /**
     * Compute the hash function
     * 
     * @param s
     *            The string that we are hashing
     * @param length
     *            Length of the hash table (needed because this method is
     *            static)
     * @return
     *         The hash function value (the home slot in the table for this key)
     */
    
    
    public int getLength() {
        return this.table.length;
    }
    
    public int getCount() {
        return this.recordCount;
    }
    
    public void resize() {
        
        Record[] old_arr = this.table;
        Record[] newArr = new Record[this.table.length*2];
        this.table = newArr;
        this.recordCount = 0;
        
           for (int i =0; i < old_arr.length; i++) {
            if (old_arr[i] != null && !old_arr[i].equals(this.tombstone)) {
                 String key = (String)old_arr[i].getKey();
                 this.insert(key);
            }
       }
            
    }
    
        
    
    public static int h(String s, int length) {
        int intLength = s.length() / 4;
        long sum = 0;
        for (int j = 0; j < intLength; j++) {
            char[] c = s.substring(j * 4, (j * 4) + 4).toCharArray();
            long mult = 1;
            for (int k = 0; k < c.length; k++) {
                sum += c[k] * mult;
                mult *= 256;
            }
        }

        char[] c = s.substring(intLength * 4).toCharArray();
        long mult = 1;
        for (int k = 0; k < c.length; k++) {
            sum += c[k] * mult;
            mult *= 256;
        }

        return (int)(Math.abs(sum) % length);
    }
    
    private int quadratic_probe(String key, int i){
        return (this.h(key, this.table.length) + ((i * i) + i)/2) % this.table.length;
    }
   
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param key
     */
    public void insert(String key) {
        if ((this.recordCount+1)*2 > this.table.length) {
            this.resize();
        }
            
        int offset = 0;
        int pos = this.quadratic_probe(key, offset);
        
        while ((this.table[pos] != null) && !this.table[pos].equals(tombstone)) {
               offset += 1;
               pos = this.quadratic_probe(key, offset);
        }
        
        this.table[pos] = new Record(key);
        this.recordCount += 1;
    }
    
  
    public boolean delete(String key) {
        int i = 0;
        int pos = this.quadratic_probe(key, i);
        
        Record check = new Record(key);
        
        
        while (this.table[pos] != null) {
            if (this.table[pos].equals(check)) {
                this.table[pos] = new Record("TOMBSTONE");
                this.recordCount -= 1;
                return true; 
            }
            i += 1;
            pos = this.quadratic_probe(key, i);

        }
        return false;
    }
    

    public boolean find(String key) {
        
        int offset = 0;
        int pos = this.quadratic_probe(key, offset);
        
        Record node = new Record(key);
       
        while (this.table[pos] != null) {
//            System.out.println("tried finding" + key + " " + offset + " " + pos);
            if (this.table[pos].equals(node)) {
                
                return true; 
            }
            
            offset += 1;
            pos = this.quadratic_probe(key, offset);
        }
        
        return false;
    }
    
    public void displayHashTable() {
        for (int i = 0; i < this.table.length; i++) {
         Record value = this.table[i];
         
         if (value != null) {
          System.out.println("Index " + i + " has the key: " + value.getKey());
         }
         else {
             System.out.println("Index " + i + " None");
            }

        } 
     }
    
    public String[] displayEntries() {
        
        if (this.getCount() == 0) {
            return null;
        }
        String[] res = new String[this.getCount()];
        int j = 0;
        for (int i = 0; i < this.table.length; i++) {
         Record value = this.table[i];
         
         if ((value != null) && !(value.equals(this.tombstone))) {
             res[j] = (String)value.getKey();
             j += 1;
         }
        }
        return res;
     }
   
           
}

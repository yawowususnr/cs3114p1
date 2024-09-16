//import student.TestCase;
//
///**
// * @author <Put something here>
// * @version <Put something here>
// */
//public class HashTest extends TestCase {
//    
//    private Hash hashTable;
//    
//    public void setUp() {
//        hashTable = new Hash(4);
//    }
//
//
//    /**
//     * Check out the sfold method
//     *
//     * @throws Exception
//     *             either a IOException or FileNotFoundException
//     */
//    public void testSfold() throws Exception {
//        assertTrue(Hash.h("a", 10000) == 97);
//        assertTrue(Hash.h("b", 10000) == 98);
//        assertTrue(Hash.h("aaaa", 10000) == 1873);
//        assertTrue(Hash.h("aaab", 10000) == 9089);
//        assertTrue(Hash.h("baaa", 10000) == 1874);
//        assertTrue(Hash.h("aaaaaaa", 10000) == 3794);
//        assertTrue(Hash.h("Long Lonesome Blues", 10000) == 4635);
//        assertTrue(Hash.h("Long   Lonesome Blues", 10000) == 4159);
//        assertTrue(Hash.h("long Lonesome Blues", 10000) == 4667);
//    }
//    
//    public void testInsert() {
//        // Insert a key and check if it's properly added
//        hashTable.insert("Key1");
//        assertTrue(hashTable.find("Key1"));
//        hashTable.displayHashTable();
//
//        hashTable.insert("Key2");
//        assertTrue(hashTable.find("Key2"));
//        hashTable.displayHashTable();
//
//        hashTable.insert("Key3");
//        hashTable.displayHashTable();
//        
//        hashTable.insert("Key4");
//        hashTable.displayHashTable();
//        hashTable.insert("Key5");
//        hashTable.displayHashTable();
//
//        assertTrue(hashTable.find("Key3"));
//        hashTable.displayHashTable();
//        assertTrue(hashTable.find("Key4"));
//        
////        assertTrue(hashTable.find("Key5"));
//    }
////    
//    public void testDelete() {
//        // Insert a key, then delete it
//        hashTable.insert("Key1");
//        hashTable.insert("Key2");
//        hashTable.insert("Key3");
//        hashTable.insert("Key4");
//        hashTable.insert("Key5");
//        hashTable.displayHashTable();
//        boolean deleteResult = hashTable.delete("Key1");
//        assertTrue(deleteResult);
//        hashTable.displayHashTable();
//        assertFalse(hashTable.find("Key1"));  
//        // Ensure key is no longer found
//
//        // Try deleting a key that doesn't exist
//        assertFalse(hashTable.delete("NonExistingKey"));
//    }
//    
//    public void testTombstoneReuse() {
//        // Insert and delete a key
//        hashTable.insert("Key1");
//        assertTrue(hashTable.find("Key1"));
//
//        hashTable.delete("Key1");
//        assertFalse(hashTable.find("Key1"));
//
//        // Reinsert and ensure the tombstone is reused
//        hashTable.insert("Key1");
//        assertTrue(hashTable.find("Key1"));
//    }
////    
////    public void testResize() {
////        System.out.println(hashTable.getCount());
////        hashTable.insert("Key1");
////        System.out.println(hashTable.getCount());
////        hashTable.displayHashTable();
////        hashTable.insert("Key2");
////        System.out.println(hashTable.getCount());
////        hashTable.displayHashTable();
////        hashTable.insert("Key3");
////        System.out.println(hashTable.getCount());
////        hashTable.displayHashTable();
////        System.out.println(hashTable.getLength());
////        hashTable.insert("Key4");
////        System.out.println(hashTable.getCount());
////        hashTable.insert("Key5");
////        System.out.println(hashTable.getCount());
////        assertEquals(hashTable.getLength(), 16);
////    }
//}

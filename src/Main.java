public class Main {
    public static void main(String[] args) {
        String sentence = "To be or not to be";
        HashTable hashTable = new HashTable(10);
        String[] words = sentence.split(" ");
        for (String word : words) {
            word = word.toLowerCase();
            hashTable.put(word, 1);
        }
        System.out.println("frequency of words in a sentence 'To be or not to be' : ");
        hashTable.printHashTable();
    }
}
import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        //ETAP 1

        Anagramy a = new Anagramy();
        long start = 0L;
        long end = 0L;

        start = System.nanoTime();
        a.readFile("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 1 - readFile");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa.size());
        System.out.println();
        a.slowa.clear();

        start = System.nanoTime();
        a.readFile2("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 2 - readFile2");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa.size());
        System.out.println();
        a.slowa.clear();

        start = System.nanoTime();
        a.readFile3("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 3 - readFile3");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa.size());
        System.out.println();
        a.slowa.clear();

        start = System.nanoTime();
        a.readFile4("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 4 - readFile4");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa2.size());
        System.out.println();

        start = System.nanoTime();
        a.readFile2("english.200MB.txt");
        a.findAnagrams();
        end = System.nanoTime();
        System.out.println("metoda 5 - findAnagrams");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba anagramow: " + a.anagramy.size());
        a.wypiszAnagramy();
        System.out.println();
        a.slowa.clear();
        a.anagramy.clear();

//        ETAP 2

        start = System.nanoTime();
        a.readFile2("english.200MB.txt");
        a.findAnagrams2();
        end = System.nanoTime();
        System.out.println("metoda 6 - findAnagrams2");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba anagramow: " + a.anagramy.size());
        a.wypiszAnagramy();
        System.out.println();
        a.slowa.clear();
        a.anagramy.clear();

        //metoda readFile2 jest najszybsza z pierwszych czterech
        //roznice miedzy findAnagrams i findAnagrams2 sa niewielkie, zwykle na korzysc findAnagrams2

        start = System.nanoTime();
        a.readFile5("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 7 - readFile5");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa3.size());
        System.out.println();
        a.slowa3.clear();
        a.anagramy.clear();

        start = System.nanoTime();
        a.readFile6("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 8 - readFile6");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa3.size());
        System.out.println();
        a.slowa3.clear();
        a.anagramy.clear();

        start = System.nanoTime();
        a.readFile7("english.200MB.txt");
        end = System.nanoTime();
        System.out.println("metoda 9 - readFile7");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba slow: " + a.slowa3.size());
        System.out.println();
        a.slowa3.clear();
        a.anagramy.clear();

        //udalo sie znalezc wydajniejsza wersje metody readFile (readFile7), ktora znajduje pary slow

        start = System.nanoTime();
        a.readFile5("english.200MB.txt");
        a.findAnagrams3();
        end = System.nanoTime();
        System.out.println("metoda 10 - findAnagrams3, readFile5");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba anagramow: " + a.anagramy.size());
        a.wypiszAnagramy();
        System.out.println();
        a.slowa.clear();
        a.anagramy.clear();

        start = System.nanoTime();
        a.readFile7("english.200MB.txt");
        a.findAnagrams3();
        end = System.nanoTime();
        System.out.println("metoda 11 - findAnagrams3, readFile7");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba anagramow: " + a.anagramy.size());
        a.wypiszAnagramy();
        System.out.println();
        a.slowa.clear();
        a.anagramy.clear();

        //ETAP 3

        start = System.nanoTime();
        a.readFile2And7("english.200MB.txt");
        a.findAnagrams3();
        end = System.nanoTime();
        System.out.println("metoda 12 - findAnagrams3, readFile2And7");
        System.out.println("czas odczytu: " + (end - start) / 1e9 + " sek");
        System.out.println("Liczba anagramow: " + a.anagramy.size());
        a.wypiszAnagramy();
        System.out.println();
        a.slowa.clear();
        a.anagramy.clear();
    }
}
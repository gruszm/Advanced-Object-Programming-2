import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MyTuple
{
    String first, second;

    public MyTuple(String s1, String s2)
    {
        this.first = s1;
        this.second = s2;
    }

    public String sortLetters()
    {
        char[] t = (first + second).toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
}

public class Anagramy
{
    HashSet<String> slowa;
    List<String> slowa2;
    HashSet<MyTuple> slowa3;
    ArrayList<List<String>> anagramy;

    public Anagramy()
    {
        slowa = new HashSet<>();
        anagramy = new ArrayList<>();
    }

    public void wypiszAnagramy()
    {
        for (int i = 0; i < anagramy.size(); i++)
        {
            for (int j = 0; j < anagramy.get(i).size(); j++)
            {
                System.out.print(anagramy.get(i).get(j) + " ");
            }
        }
    }

    public void readFile(String fn) throws IOException
    {
        FileInputStream fis = new FileInputStream(fn);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
        {
            line = line.replaceAll("[^a-zA-Z]+", " ");
            line = line.toLowerCase(Locale.ROOT);
            String[] sline = line.split(" ");
            for (String s : sline)
            {
                if (s.length() >= 3)
                {
                    slowa.add(s);
                }
            }
        }

        br.close();
    }

    public void readFile2(String fn) throws IOException
    {
        FileInputStream fis = new FileInputStream(fn);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null)
        {
            line = line.toLowerCase(Locale.ROOT);
            line = line.replaceAll("[^a-zA-Z]+", " ");
            String[] sline = line.split(" ");
            for (String s : sline)
            {
                if (s.length() >= 3)
                {
                    slowa.add(s);
                }
            }
        }

        br.close();
    }

    public void readFile3(String fn) throws IOException
    {
        String txt = Files.readString(Path.of(fn), StandardCharsets.UTF_8);
        txt = txt.toLowerCase(Locale.ROOT);
        txt = txt.replaceAll("[^a-z ]+", " ");
        String[] sline = txt.split(" ");
        for (String s : sline)
        {
            if (s.length() >= 3)
            {
                slowa.add(s);
            }
        }
    }

    public void readFile4(String fn) throws IOException
    {
        Stream<String> txtStream = Files.lines(Path.of(fn), StandardCharsets.UTF_8);
        slowa2 = txtStream.map(String::toLowerCase)
                .map(txt -> txt.replaceAll("[^a-z ]+", " "))
                .flatMap(txt -> Arrays.stream(txt.split(" ")))
                .filter(txt -> txt.length() >= 3)
                .distinct()
                .toList();
    }

    public void readFile5(String fn) throws IOException
    {
        Stream<String> txtStream = Files.lines(Path.of(fn), StandardCharsets.UTF_8);
        var slowa = txtStream.map(String::toLowerCase)
                .map(txt -> txt.replaceAll("[^a-z ]+", " "))
                .flatMap(txt -> Arrays.stream(txt.split(" ")))
                .filter(txt -> txt.length() >= 3)
                .toArray();

        slowa3 = new HashSet<>();
        for (int i = 0; i < slowa.length / 2; i++)
        {
            slowa3.add(new MyTuple((String) slowa[2 * i], (String) slowa[2 * i + 1]));
        }
    }

    public void readFile6(String fn) throws IOException
    {
        slowa3 = new HashSet<>();

        try (Stream<String> txtStream = Files.lines(Path.of(fn), StandardCharsets.UTF_8))
        {
            Iterator<String> iterator = txtStream
                    .map(String::toLowerCase)
                    .flatMap(txt -> Arrays.stream(txt.replaceAll("[^a-z ]+", " ").split(" ")))
                    .filter(txt -> txt.length() >= 3)
                    .iterator();

            while (iterator.hasNext())
            {
                String first = iterator.next();
                if (iterator.hasNext())
                {
                    String second = iterator.next();
                    slowa3.add(new MyTuple(first, second));
                }
                else
                {
                    slowa3.add(new MyTuple(first, ""));
                }
            }
        }
    }

    public void readFile7(String fn) throws IOException
    {
        slowa3 = new HashSet<>();

        try (Stream<String> txtStream = Files.lines(Path.of(fn), StandardCharsets.UTF_8))
        {
            List<String> words = txtStream
                    .map(String::toLowerCase)
                    .map(txt -> txt.replaceAll("[^a-z ]+", " "))
                    .flatMap(txt -> Arrays.stream(txt.split(" ")))
                    .filter(txt -> txt.length() >= 3)
                    .collect(Collectors.toList());

            for (int i = 0; i < words.size(); i += 2)
            {
                if (i + 1 < words.size())
                {
                    slowa3.add(new MyTuple(words.get(i), words.get(i + 1)));
                }
                else
                {
                    slowa3.add(new MyTuple(words.get(i), null));
                }
            }
        }
    }

    public void findAnagrams()
    {
        HashMap<String, List<String>> hm = new HashMap<>();

        for (String slowo : slowa)
        {
            char[] znaki = slowo.toCharArray();
            Arrays.sort(znaki);
            String znaki_s = new String(znaki);

            if (hm.containsKey(znaki_s))
            {
                hm.get(znaki_s).add(slowo);
            }
            else
            {
                List<String> lista = new ArrayList<>();
                lista.add(slowo);
                hm.put(znaki_s, lista);
            }
        }

        for (List<String> l : hm.values())
        {
            if (l.size() > 1)
            {
                anagramy.add(l);
            }
        }
    }

    private String sortLetters(String s)
    {
        char[] znaki = s.toCharArray();
        Arrays.sort(znaki);
        return new String(znaki);
    }

    public String sortLetters2(String slowo, String slowo2)
    {
        char[] t = slowo.concat(slowo2).toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

    public void findAnagrams2()
    {
        HashMap<String, List<String>> hm = new HashMap<>();
        slowa.forEach(slowo -> hm.computeIfAbsent(
                sortLetters(slowo), s -> new ArrayList<>()).add(slowo));
        hm.entrySet().removeIf(item -> item.getValue().size() < 2);
        anagramy.addAll(hm.values().stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toList()));
        System.out.println("liczba par slow: " + hm.size());
    }

    public void findAnagrams3()
    {
        HashMap<String, List<MyTuple>> hm = new HashMap<>();
        slowa3.forEach(slowo -> hm.computeIfAbsent(
                sortLetters2(slowo.first, slowo.second), s -> new ArrayList<>()).add(slowo));
        hm.entrySet().removeIf(item -> item.getValue().size() < 2);
        anagramy.addAll(hm.values().stream()
                .filter(list -> list.size() > 1)
                .map(list -> list.stream()
                        .map(myTuple -> myTuple.first + " " + myTuple.second)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList()));
        System.out.println("liczba par slow: " + hm.size());
    }

    public void readFile2And7(String fn) throws IOException {
        slowa3 = new HashSet<>();

        try (Stream<String> txtStream = Files.lines(Path.of(fn), StandardCharsets.UTF_8)) {
            List<String> words = txtStream
                    .map(String::toLowerCase)
                    .map(txt -> txt.replaceAll("[^a-z ]+", " "))
                    .flatMap(txt -> Arrays.stream(txt.split(" ")))
                    .filter(txt -> txt.length() >= 3)
                    .collect(Collectors.toList());

            for (int i = 0; i < words.size(); i++) {
                slowa3.add(new MyTuple(words.get(i), ""));

                if (i % 2 == 0)
                {
                    if (i + 1 < words.size()) {
                        slowa3.add(new MyTuple(words.get(i), words.get(i + 1)));
                    } else {
                        slowa3.add(new MyTuple(words.get(i), ""));
                    }
                }
            }
        }
    }
}

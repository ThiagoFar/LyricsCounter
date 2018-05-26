
package components;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReaderSub {

    public String endText = "";
    public String music = "";
    public String[] musicArray;

    public final void read(String find) throws IOException {

        File path = new File(find);
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String data = null;
        music = "";
        while ((data = reader.readLine()) != null) {

            if (data != "null");
            data = data.replace(",", "");
            data = data.replace(".", "");
            data = data.replace("?", "");
            data = data.replace("\"", "");
            data = data.replace("!", "");
            data = data.toLowerCase();
            music = "  " + data + music;
        }

        fileReader.close();
        reader.close();

    }

    public final void read2(String find) throws IOException {

        File path = new File(find);
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String data = null;
        while ((data = reader.readLine()) != null) {

            endText = "" + data + endText;
        }

        fileReader.close();
        reader.close();

    }

    public String[] mafs() {

        musicArray = music.split(" ");
        musicArray = new HashSet<String>(Arrays.asList(musicArray)).toArray(new String[0]);
        return (musicArray);
    }

    public String mafs2() throws IOException {
        String agua = "";

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String st = endText;
        st = st.trim();
        st = st + " ";
        int count = lengthx(st);

        String arr[] = new String[count];
        int p = 0;
        int c = 0;

        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == ' ') {
                arr[p] = st.substring(c, i);

                c = i + 1;
                p++;
            }
        }
        Map<String, Integer> map = new HashMap<>();

        for (String w : arr) {
            Integer n = map.get(w);
            n = (n == null) ? 1 : ++n;
            map.put(w, n);
        }
        for (String key : map.keySet()) {

        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                Integer v1 = e1.getValue();
                Integer v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        List<Map.Entry<String, Integer>> listOfEntries = new ArrayList<Map.Entry<String, Integer>>(entries);
        Collections.sort(listOfEntries, valueComparator);

        LinkedHashMap<String, Integer> sortedByValue = new LinkedHashMap<String, Integer>(listOfEntries.size());

        for (Map.Entry<String, Integer> entry : listOfEntries) {

            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : listOfEntries) {

            sortedByValue.put(entry.getKey(), entry.getValue());
        }

        Set<Map.Entry<String, Integer>> entrySetSortedByValue = sortedByValue.entrySet();
        for (Map.Entry<String, Integer> mapping : entrySetSortedByValue) {
            agua = (mapping.getKey() + " ==> " + mapping.getValue() + "<  " + agua);
        }

        return (agua);
    }

    static int lengthx(String a) {
        int count = 0;
        for (int j = 0; j < a.length(); j++) {
            if (a.charAt(j) == ' ') {
                count++;
            }
        }
        return count;
    }

}

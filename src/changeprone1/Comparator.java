/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changeprone1;

import difflib.Chunk;
import difflib.Delta;
import difflib.DiffUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Integer.max;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.fail;

/**
 *
 * @author aryan_000
 */


class Difference {
    private  final File original;
    private final File revised;
    public Difference (File original, File revised) {
        this.original = original;
        this.revised = revised;
    }
    /**
     *
     * @return
     * @throws IOException
     */
    public List<Chunk> getChangesFromOriginal() throws IOException {
        return getChunksByType(Delta.TYPE.CHANGE);
    }
 
    public List<Chunk> getInsertsFromOriginal() throws IOException {
        return getChunksByType(Delta.TYPE.INSERT);
    }
 
    public List<Chunk> getDeletesFromOriginal() throws IOException {
        return getChunksByType(Delta.TYPE.DELETE);
    }
 
    private List<Chunk> getChunksByType(Delta.TYPE type) throws IOException {
        final List<Chunk> listOfChanges = new ArrayList<>();
        final List<Delta> deltas = getDeltas();
        for (Delta delta : deltas) {
            if (delta.getType() == type) {
                listOfChanges.add(delta.getRevised());
            }
        }
        return listOfChanges;
    }
 
    private List<Delta> getDeltas() throws IOException {
 
        final List<String> originalFileLines = fileToLines(original);
        final List<String> revisedFileLines = fileToLines(revised);
 
        final difflib.Patch patch = DiffUtils.diff(originalFileLines, revisedFileLines);
 
        return patch.getDeltas();
    }
 
    private List<String> fileToLines(File file) throws IOException {
        final List<String> lines = new ArrayList<>();
        String line;
        final BufferedReader in = new BufferedReader(new FileReader(file));
        while ((line = in.readLine()) != null) {
            lines.add(line);
        }
 
        return lines;
    }
 
} 

public class Comparator 
{

    private File original;// = new File("C:\\Users\\aryan_000\\Desktop\\a.java");
    private File revised;// = new File("C:\\Users\\aryan_000\\Desktop\\b.java");

    Comparator(File original, File revised) {
        this.original = original;
        this.revised = revised;
    }

    private int shouldGetChangesBetweenFiles() {

        final Difference comparator = new Difference(original, revised);

        int ans = 0;
        String temp;
        try {
            final List<Chunk> changesFromOriginal = comparator.getChangesFromOriginal();

            for (Chunk changesFromOriginal1 : changesFromOriginal) {
                ans += changesFromOriginal1.getLines().size();
            }

//            System.out.println( changesFromOriginal.get(0).getLines().size());
//            System.out.println("number of lines changed is : " + ans);
//            System.out.println("number of total deletion is : " + changesFromOriginal.size());
            ans = max(ans , changesFromOriginal.size());
        } catch (IOException ioe) {
            fail("Error running test shouldGetChangesBetweenFiles " + ioe.toString());
        }

        return ans;
    }
    private int shouldGetInsertsBetweenFiles() {

        final Difference comparator = new Difference(original, revised);

        int ans = 0;
        try {
            final List<Chunk> insertsFromOriginal = comparator.getInsertsFromOriginal();

            for (Chunk insertsFromOriginal1 : insertsFromOriginal) {
//                System.out.println(changesFromOriginal1.getLines().size());
                ans += insertsFromOriginal1.getLines().size();
            }
//            System.out.println("NUmber of Lines inserted is : " + insertsFromOriginal.size());
             ans = max(ans , insertsFromOriginal.size());
        } catch (IOException ioe) {
            fail("Error running test shouldGetInsertsBetweenFiles " + ioe.toString());
        }

        return ans;
    }
    private int shouldGetDeletesBetweenFiles() {

        final Difference comparator = new Difference(original, revised);

        int ans = 0;
        try {
            final List<Chunk> deletesFromOriginal = comparator.getDeletesFromOriginal();

            for (Chunk deletesFromOriginal1 : deletesFromOriginal) {
//                System.out.println(changesFromOriginal1.getLines().size());
                ans += deletesFromOriginal1.getLines().size();
            }
//            System.out.println("Number os lines deleted " + deletesFromOriginal.size());
             ans = max(ans , deletesFromOriginal.size());
        } catch (IOException ioe) {
            fail("Error running test shouldGetDeletesBetweenFiles " + ioe.toString());
        }

        return ans;
    }

    public int GetTach() 
    {
    int added = shouldGetInsertsBetweenFiles();
    int deleted = shouldGetDeletesBetweenFiles();
    int changed = shouldGetChangesBetweenFiles();
    return added + deleted + 2 * changed;
    }
}

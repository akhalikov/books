package chapter1;

import java.io.File;

/**
 * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
 * 1. write a method that returns all subdirectories of a given directory.
 * Use a lambda expression instead of a FileFilter object.
 * Repeat with a method expression.
 *
 * 2. write a method that returns all files in a given directory with a given extension
 *
 * @author akhalikov
 */
public class SubDirLister {
    public static void main(String[] args) {
        //for (File f : getSubDirs(".")) {
        //    System.out.println(f.getName());
        //}

        for (File f: getFilesWithExtension(".", ".md")) {
            System.out.println(f.getName());
        }
    }

    static File[] getSubDirs(String pathName) {
        File path = new File(pathName);
        return path.listFiles(
                (dir, name) -> new File(name).isDirectory());
    }

    static File[] getFilesWithExtension(String pathName, String ext) {
        File path = new File(pathName);
        return path.listFiles(
                (dir, name) -> !(new File(name).isDirectory()) && name.contains(ext));
    }
}

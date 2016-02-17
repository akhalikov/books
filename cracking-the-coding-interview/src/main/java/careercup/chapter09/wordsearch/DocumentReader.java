package careercup.chapter09.wordsearch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

/**
 * Simple file walker using NIO.2
 */
public class DocumentReader extends SimpleFileVisitor<Path> {
  private Map<String, Path> documents;

  public DocumentReader(Map<String, Path> documents) {
    this.documents = documents;
  }

  @Override
  public FileVisitResult visitFile(Path file,
                                   BasicFileAttributes attrs) throws IOException {
    if (attrs.isRegularFile()) {
      documents.put(getKey(file), file);
    }
    return FileVisitResult.CONTINUE;
  }

  private String getKey(Path file) {
    String fileName = file.toString();
    int start = fileName.indexOf("doc");
    return fileName.substring(start, start + 4);
  }
}

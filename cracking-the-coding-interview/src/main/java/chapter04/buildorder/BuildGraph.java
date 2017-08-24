package chapter04.buildorder;

import java.util.ArrayList;
import java.util.List;

public class BuildGraph {
  List<Project> projects = new ArrayList<>();

  public BuildGraph() {
  }

  public BuildGraph(Project...projects) {
    for (Project project: projects)
      this.projects.add(project);
  }

  public void addProject(Project project) {
    projects.add(project);
  }
}

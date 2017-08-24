package chapter04.buildorder;

import java.util.ArrayList;
import java.util.List;

public class Project {
  String name;
  List<Project> dependencies = new ArrayList<>();

  public Project(String name) {
    this.name = name;
  }

  public Project(String name, Project...dependencies) {
    this.name = name;
    for (Project project: dependencies)
      this.dependencies.add(project);
  }

  void addDependency(Project project) {
    dependencies.add(project);
  }

  public List<Project> getDependencies() {
    return dependencies;
  }

  @Override
  public String toString() {
    return "Project(" + name + ")";
  }
}

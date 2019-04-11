package chapter04.buildorder;

import java.util.HashMap;
import java.util.Map;

class Project {
  private final String name;
  private final Map<String, Project> dependencies = new HashMap<>();
  private State state = State.BLANK;

  Project(String name) {
    this.name = name;
  }

  void addDependency(Project project) {
    dependencies.put(project.name, project);
  }

  String getName() {
    return name;
  }

  Project[] getDependencies() {
    return dependencies.values().toArray(new Project[0]);
  }

  State getState() {
    return state;
  }

  void setState(State state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Project{" +
        "name='" + name + '\'' +
        ", dependencies=" + dependencies +
        '}';
  }

  enum State {
    BLANK,
    PARTIAL,
    COMPLETED
  }
}

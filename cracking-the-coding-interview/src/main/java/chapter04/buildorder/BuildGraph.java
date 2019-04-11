package chapter04.buildorder;

import chapter04.buildorder.Project.State;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class BuildGraph {
  private final List<Project> projects = new ArrayList<>();
  private final Map<String, Project> map = new HashMap<>();

  /**
   * @param first Name of first project
   * @param second Name of the second project, which is dependent on the first project
   *
   * Build order: first then second (second depends on first)
   */
  BuildGraph addEdge(String first, String second) {
    getOrCreateNode(second)
        .addDependency(getOrCreateNode(first));
    return this;
  }

  BuildGraph addNode(String name) {
    getOrCreateNode(name);
    return this;
  }

  List<Project> findBuildOrder() {
    final Deque<Project> queue = new ArrayDeque<>();
    for (Project project: projects) {
      if (project.getState() == State.BLANK) {
        boolean hasOrder = findBuildOrderDepthFirst(project, queue);
        if (!hasOrder) {
          return Collections.emptyList();
        }
      }
    }
    return new ArrayList<>(queue);
  }

  private boolean findBuildOrderDepthFirst(Project project, Deque<Project> queue) {
    if (project.getState() == State.PARTIAL) {
      return false; // cycle
    }
    if (project.getState() == State.BLANK) {
      project.setState(State.PARTIAL);
      for (Project dependency: project.getDependencies()) {
        if (!findBuildOrderDepthFirst(dependency, queue)) {
          return false;
        }
      }
      project.setState(State.COMPLETED);
      queue.add(project);
    }
    return true;
  }

  private Project getOrCreateNode(String name) {
    if (!map.containsKey(name)) {
      Project project = new Project(name);
      projects.add(project);
      map.put(name, project);
    }
    return map.get(name);
  }
}

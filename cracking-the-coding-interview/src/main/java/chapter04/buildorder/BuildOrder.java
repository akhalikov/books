package chapter04.buildorder;

import java.util.List;

/**
 * You are given a list of projects and a list of dependencies
 * (which is a list of pairs of projects, where the first project is dependent on
 * the second project). All of a project’s dependencies must be built before
 * the project is. Find a build order that will allow the projects to be built.
 * If there is no valid build order, return an error.
 * Example:
 *
 * Input:
 *  Projects: a, b, c, d, e, f
 *  Dependencies: (d, a), (b, f), (d, b), (a, f), (c, d)
 *  Output: f, e, a, b, d, c
 *
 * Created by akhalikov on 11/03/16
 */
public class BuildOrder {
  public List<Project> findBuildOrder(BuildGraph graph) {

    return null;
  }
}

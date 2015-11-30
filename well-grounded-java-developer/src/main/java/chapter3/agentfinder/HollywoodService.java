package chapter3.agentfinder;

import javax.inject.Inject;
import java.util.List;

/**
 * @author ahalikov
 */
public class HollywoodService {
  private AgentFinder finder = null;

  @Inject
  public HollywoodService(AgentFinder finder) {
    this.finder = finder;
  }

  public List<Agent> getFriendlyAgents() {
    List<Agent> agents = finder.findAllAgents();
    List<Agent> friendlyAgents = filterAgents(agents, "Java Developer");
    return friendlyAgents;
  }

  public List<Agent> filterAgents(List<Agent> agents, String agentType) {
    // Add filtering
    return agents;
  }
}

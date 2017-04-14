package chapter3.agentfinder;

import javax.inject.Inject;
import java.util.List;

public class HollywoodService {
  private final AgentFinder finder;

  @Inject
  public HollywoodService(AgentFinder finder) {
    this.finder = finder;
  }

  List<Agent> getFriendlyAgents() {
    List<Agent> agents = finder.findAllAgents();
    return filterAgents(agents, "Java Developer");
  }

  List<Agent> filterAgents(List<Agent> agents, String agentType) {
    // Add filtering
    return agents;
  }
}

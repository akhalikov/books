package chapter3.agentfinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Some web service
 *
 * @author ahalikov
 */
public class WebServiceAgentFinder implements AgentFinder {
  @Override
  public List<Agent> findAllAgents() {
    List<Agent> agents = new ArrayList<>();
    // Some agents fetching implementation
    return agents;
  }
}

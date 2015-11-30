package chapter3.agentfinder;

import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.List;

/**
 * Service client
 *
 * @author ahalikov
 */
public class HollywoodServiceClient {

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new AgentFinderModule());
    HollywoodService service = injector.getInstance(HollywoodService.class);
    List<Agent> agents = service.getFriendlyAgents();
    agents.stream().forEach(System.out::print);
  }
}

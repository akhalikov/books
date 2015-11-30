package chapter3.agentfinder;

import com.google.inject.AbstractModule;

/**
 * Guice module
 *
 * @author ahalikov
 */
public class AgentFinderModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(AgentFinder.class).to(WebServiceAgentFinder.class);
  }
}

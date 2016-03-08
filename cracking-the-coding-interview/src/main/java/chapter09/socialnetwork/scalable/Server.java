package chapter09.socialnetwork.scalable;

import java.util.HashMap;
import java.util.Map;

/**
 * Class Server holds a list of all the machines on which we store Persons
 *
 * Created by akhalikov on 03/03/16
 */
public class Server {
  private Map<Integer, Machine> machines = new HashMap<>();
  private Map<Integer, Integer> personToMachineMap = new HashMap<>();

  public Machine getMachineWithId(int machineId) {
    return machines.get(machineId);
  }

  public int getMachineIdForuser(int personId) {
    Integer machineId = personToMachineMap.get(personId);
    return machineId == null ? -1: machineId;
  }

  public Person getPersonWithId(int personId) {
    Integer machineId = personToMachineMap.get(personId);
    if (machineId == null) return null;

    Machine machine = getMachineWithId(machineId);
    if (machine == null) return null;

    return machine.getPersonWithId(personId);
  }
}

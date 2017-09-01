package org.testcontainers.containers;

import com.github.dockerjava.api.command.InspectContainerResponse;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.testcontainers.containers.traits.LinkableContainer;

/**
 * @author Ihor Banadiga
 */
public class InfluxDBContainer<SELF extends InfluxDBContainer<SELF>> extends GenericContainer<SELF> implements LinkableContainer {
  public static final Integer INFLUXDB_PORT = 8086;
  public static final String IMAGE = "influxdb";

  private InfluxDB influxDB;

  private String username = "any";
  private String password = "any";

  public InfluxDBContainer() {
    this(IMAGE + ":latest");
  }

  public InfluxDBContainer(final String dockerImageName) {
    super(dockerImageName);
  }

  @Override
  protected Integer getLivenessCheckPort() {
    return getMappedPort(INFLUXDB_PORT);
  }

  @Override
  protected void configure() {
    addExposedPort(INFLUXDB_PORT);
    addEnv("INFLUXDB_USER", username);
    addEnv("INFLUXDB_PASSWORD", password);
  }

  @Override
  protected void containerIsStarting(InspectContainerResponse containerInfo) {
    influxDB = InfluxDBFactory.connect(getUrl(), username, password);
  }

  /**
   * Bind a fixed port on the docker host to a container port
   *
   * @param hostPort a port on the docker host, which must be available
   * @return this container
   */
  public SELF withFixedExposedPort(int hostPort) {
    super.addFixedExposedPort(hostPort, INFLUXDB_PORT);
    return self();
  }

  public SELF withUsername(final String username) {
    this.username = username;
    return self();
  }

  public SELF withPassword(final String password) {
    this.password = password;
    return self();
  }

  public String getUrl() {
    return "http://" + getContainerIpAddress() + ":" + getLivenessCheckPort();
  }

  public InfluxDB getInfluxDB() {
    return influxDB;
  }
}

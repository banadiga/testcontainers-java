package org.testcontainers.containers.junit;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.InfluxDBContainer;

public class InfluxDBContainerSystemTest {

  @ClassRule
  public static final InfluxDBContainer influxDBContainer = new InfluxDBContainer();

  @ClassRule
  public static final InfluxDBContainer influxDBContainerWithVersion = new InfluxDBContainer(
      InfluxDBContainer.IMAGE + ":1.1");

  @ClassRule
  public static final InfluxDBContainer influxDBContainerWithFixedExposedPort = new InfluxDBContainer()
      .withFixedExposedPort(InfluxDBContainer.INFLUXDB_PORT);

  @ClassRule
  public static final InfluxDBContainer influxDBContainerWithUsernameAndPassword = new InfluxDBContainer()
      .withUsername("test").withPassword("test");

  @Test
  public void influxDBContainerStartUp() throws Exception {
  }
}

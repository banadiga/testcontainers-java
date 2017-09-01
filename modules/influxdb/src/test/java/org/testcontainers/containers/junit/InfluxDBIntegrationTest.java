package org.testcontainers.containers.junit;

import org.influxdb.InfluxDB;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.InfluxDBContainer;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InfluxDBIntegrationTest {

  @Rule
  public InfluxDBContainer influxDBContainer = new InfluxDBContainer();

  @Test
  public void getInfluxDB() throws Exception {
    InfluxDB actual = influxDBContainer.getInfluxDB();
    assertThat(actual, notNullValue());
  }

  @Test
  public void getDatabases() throws Exception {
    Collection actual = influxDBContainer.getInfluxDB().describeDatabases();
    assertThat(actual, notNullValue());
  }
}

package org.testcontainers.containers.junit;

import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.InfluxDBContainer;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class InfluxDBContainerTest {
  @Rule
  public InfluxDBContainer influxDBContainer = new InfluxDBContainer();

  @Test
  public void getUrl() throws Exception {
    String actual = influxDBContainer.getUrl();
    assertThat(actual, notNullValue());
  }
}

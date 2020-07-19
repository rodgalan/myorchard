package org.happyhome.myorchard.shared.infrastructure;

import org.happyhome.myorchard.shared.domain.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SharedConfiguration {

  @Bean
  public EventBus eventBus(){
    return new SyncEventBus();
  }
}

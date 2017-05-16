package de.feffi.jnumber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author feffi <feffi@feffi.org>
 */
@SpringBootApplication
public final class JNumber {

  private JNumber() {
    // This is a main class, so no instanciation is done here.
  }

  /**
   * @param args The command line arguments.
   */
  public static void main(final String[] args) {
		SpringApplication.run(JNumber.class, args);
  }

}

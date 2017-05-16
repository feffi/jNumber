package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.stream.Collectors;

/**
 * Created by wennemuth_k on 15.05.2017.
 */
@RestController
//@RequestMapping("/imei/{imei}")
public class ImeiController {
  
  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(ImeiController.class);

  @GetMapping({"/imei/{serial}/{method}", "/imei/{serial}"})
  public ResponseEntity validate(@PathVariable(value="serial") String serial, @PathVariable(value="method", required = false) String method) {
    try {
      Imei imei = new Imei(serial);
      if (method == null) {
        imei.validate();
      } else if (method.equalsIgnoreCase("syntax")) {
        imei.validateSyntax();
      } else if (method.equalsIgnoreCase("semantic")) {
        imei.validateSemantic();
      }
    } catch (ValidationException e) {
      String messages = e.getValidationErrors().isEmpty() ? e.getMessage() : e.getMessage() + ", " + e.getValidationErrors().stream().map(er -> e.getMessage()).collect(Collectors.joining(", "));
      LOG.debug("IMEI invalid::" + messages, e);
      return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
    } catch (URISyntaxException e) {
      LOG.debug("URL invalid::" + e.getMessage(), e);
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("IMEI is valid.", HttpStatus.OK);
  }
}

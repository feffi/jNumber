package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by wennemuth_k on 15.05.2017.
 */
@RestController
@RequestMapping("/imei/{imei}")
public class ImeiController {
  
  /**
   * Default logging facility.
   */
  final private static Logger LOG = LoggerFactory.getLogger(ImeiController.class);
  
  
  @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
  
  @GetMapping("/customers/{imei}")
  public ResponseEntity validate(@PathVariable(value="imei") String imei) {
     
    try {
      Imei serial = new Imei(imei);
      serial.validate();
    } catch (ValidationException e) {
      LOG.debug("IMEI invalid::" + e.getMessage(), e);
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (URISyntaxException e) {
      LOG.debug("URL invalid::" + e.getMessage(), e);
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("IMEI is valid.", HttpStatus.OK);
  }
}

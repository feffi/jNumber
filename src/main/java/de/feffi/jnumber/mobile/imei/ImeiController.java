package de.feffi.jnumber.mobile.imei;

import de.feffi.jnumber.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * Created by wennemuth_k on 15.05.2017.
 */
@RestController
@RequestMapping("/imei/{imei}")
public class ImeiController {

  @RequestMapping(method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
  
  @GetMapping("/customers/{imei}")
  public ResponseEntity validate(@PathVariable(value="imei") String imei) {
    Imei serial = new Imei(imei);
    try {
      serial.validate();
    } catch (ValidationException e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity("IMEI is valid.", HttpStatus.OK);
  }
}

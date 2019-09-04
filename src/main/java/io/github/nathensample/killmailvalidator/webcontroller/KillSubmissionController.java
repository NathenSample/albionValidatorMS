package io.github.nathensample.killmailvalidator.webcontroller;

import io.github.nathensample.killmailvalidator.model.VerificationRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/internal/killmail")
public class KillSubmissionController
{
    @RequestMapping(value = "/verify", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity validateKillmail(@RequestBody VerificationRequest verificationRequest){
        //Do stuff with verification request

        //Everything went right
        return new ResponseEntity(HttpStatus.PAYMENT_REQUIRED);

        //Everything went wrong
        //return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
    }
}

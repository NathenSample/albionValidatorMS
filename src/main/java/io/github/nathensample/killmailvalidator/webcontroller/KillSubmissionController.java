package io.github.nathensample.killmailvalidator.webcontroller;

import io.github.nathensample.killmailvalidator.model.VerificationRequest;
import io.github.nathensample.killmailvalidator.service.KillmailVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/internal/killmail")
public class KillSubmissionController
{
    private final KillmailVerificationService killmailVerificationService;

    public KillSubmissionController(@Autowired KillmailVerificationService killmailVerificationService)
    {
        this.killmailVerificationService = killmailVerificationService;
    }

    @PostMapping(value = "/verify", consumes = "application/json")
    public ResponseEntity validateKillmail(@RequestBody VerificationRequest verificationRequest){
        if (killmailVerificationService.verifyKillmail(verificationRequest))
        {
            return new ResponseEntity(HttpStatus.PAYMENT_REQUIRED);
        }
        return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
    }
}

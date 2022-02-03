package lab.responsepratice.controller;

import lab.responsepratice.dto.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ResponseController {

    @PostMapping("/error")
    public ResponseEntity<String> testError(final @Valid @RequestBody Member member) {
        return ResponseEntity.ok().body("postDto 객체 검증 성공");
    }
}

package lab.responsepratice.exception;

import lombok.*;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Object message;
}

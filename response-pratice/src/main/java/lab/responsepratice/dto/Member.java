package lab.responsepratice.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Email(message = "이메일을 올바르게 입력해주세요.")
    private String email;

    @NotNull(message = "이름을 입력해주세요.")
    private String name;
}

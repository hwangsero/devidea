package com.project.devidea.modules.account.validator;

import com.project.devidea.infra.error.exception.ErrorCode;
import com.project.devidea.modules.account.dto.SignUp;
import com.project.devidea.modules.account.exception.AccountException;
import com.project.devidea.modules.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class SignUpOAuthRequestValidator implements Validator{

    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return SignUp.OAuthRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        SignUp.OAuthRequest request = (SignUp.OAuthRequest) target;
        String[] providers = {"google", "github", "naver"};

        if (!Arrays.asList(providers).contains(request.getProvider().toLowerCase())) {
            errors.rejectValue("provider", "invalid.provider",
                    "해당 소셜사이트 로그인 기능은 제공하지 않습니다.");
        }

        if (accountRepository.existsByEmail(request.getId())) {
            errors.rejectValue("OAuthId", "invalid.OAuthId", "이미 가입하신 회원입니다.");
        }

        if (accountRepository.existsByNickname(request.getNickname())) {
            errors.rejectValue("nickname", "invalid.nickname", "이미 존재하는 닉네임입니다.");
        }

        if (errors.hasErrors()) {
            throw new AccountException(ErrorCode.ACCOUNT_ERROR, errors);
        }
    }
}

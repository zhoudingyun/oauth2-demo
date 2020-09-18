package org.example.config.common.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Pbkdf2Sha256PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return Pbkdf2Sha256Utils.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return Pbkdf2Sha256Utils.encode(charSequence.toString()).equals(s);
    }
}

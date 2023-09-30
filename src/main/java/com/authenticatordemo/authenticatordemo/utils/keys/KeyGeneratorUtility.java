package com.authenticatordemo.authenticatordemo.utils.keys;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGeneratorUtility {

    public static KeyPair generateRsaKey() {

        KeyPair kp;

        try {
            KeyPairGenerator kpGenerator = KeyPairGenerator.getInstance("RSA");
            kpGenerator.initialize(2048);
            kp = kpGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException();
        }

        return kp;
    }
}

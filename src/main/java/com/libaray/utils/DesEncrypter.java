package com.libaray.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.codec.binary.Base64;

final public class DesEncrypter {
    private static DesEncrypter desEncrypter = null;
    private Cipher ecipher = null;
    private Cipher dcipher = null;

    public DesEncrypter(String passPhrase)
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
        KeySpec keySpec = new DESKeySpec(passPhrase.getBytes());
        SecretKey key = SecretKeyFactory.getInstance("DES").generateSecret(keySpec);

        ecipher = Cipher.getInstance("DES");
        dcipher = Cipher.getInstance("DES");

        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String encrypt(String str)
            throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] utf8 = str.getBytes("UTF8");
        byte[] enc = ecipher.doFinal(utf8);
        return new String(Base64.encodeBase64(enc));
    }

    public String decrypt(String str)
            throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
        byte[] dec = Base64.decodeBase64(str);
        byte[] utf8 = dcipher.doFinal(dec);
        return new String(utf8, "UTF8");
    }

    public synchronized static DesEncrypter getInstance()
            throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException {
        if (desEncrypter == null) {
            desEncrypter = new DesEncrypter(".-'/W2@ce03=fky#vw6&H");
        }
        return desEncrypter;
    }
}

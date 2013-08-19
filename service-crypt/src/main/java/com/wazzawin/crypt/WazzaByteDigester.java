package com.wazzawin.crypt;

import java.nio.charset.Charset;
import javax.annotation.PostConstruct;
import org.apache.commons.codec.binary.Base64;
import org.jasypt.digest.ByteDigester;
import org.jasypt.digest.StandardByteDigester;
import static org.jasypt.digest.StandardByteDigester.DEFAULT_ALGORITHM;
import static org.jasypt.digest.StandardByteDigester.DEFAULT_ITERATIONS;
import static org.jasypt.digest.StandardByteDigester.DEFAULT_SALT_SIZE_BYTES;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class WazzaByteDigester implements ByteDigester {

    private StandardByteDigester standardByteDigester;
    // Algorithm to be used for hashing
    private String algorithm = DEFAULT_ALGORITHM;
    // Size of salt to be applied
    private int saltSizeBytes = DEFAULT_SALT_SIZE_BYTES;
    // Number of hash iterations to be applied
    private int iterations = DEFAULT_ITERATIONS;

    @PostConstruct
    public void initializeByteDigester() {
        this.standardByteDigester = new StandardByteDigester();
        this.standardByteDigester.setAlgorithm(algorithm);
        this.standardByteDigester.setSaltSizeBytes(saltSizeBytes);
        this.standardByteDigester.setIterations(iterations);
    }

    @Override
    public byte[] digest(byte[] message) {
        return standardByteDigester.digest(message);
    }

    /*
     * @return It returns the appropriate password encoded using digest encryption
     */
    public String gsDigest(String passwordToDigest) {
        return ("digest1:" + new String(Base64.encodeBase64(
                this.digest(passwordToDigest.getBytes(Charset.defaultCharset())))));
    }

    @Override
    public boolean matches(byte[] message, byte[] digest) {
        return standardByteDigester.matches(message, digest);
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public void setSaltSizeBytes(int saltSizeBytes) {
        this.saltSizeBytes = saltSizeBytes;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}

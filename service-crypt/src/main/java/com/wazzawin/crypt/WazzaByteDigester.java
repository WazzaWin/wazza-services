/*
 *  wazza-services
 *  WazzaWins Services
 *  https://github.com/WazzaWin/wazza-services
 * ====================================================================
 *
 * Copyright (C) 2012-2013 WazzaWin Developer Group (WazzaWin Team - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
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

    /**
     * The default constructor uses the MD5 alghoritm
     */
    public WazzaByteDigester() {
    }

    public WazzaByteDigester(String algorithm) {
        this.algorithm = algorithm;
        this.initializeByteDigester();
    }

    public WazzaByteDigester(String algorithm, int saltSizeBytes, int iterations) {
        this.algorithm = algorithm;
        this.saltSizeBytes = saltSizeBytes;
        this.iterations = iterations;
        this.initializeByteDigester();
    }

    @PostConstruct
    public final void initializeByteDigester() {
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
    public String digest(String passwordToDigest) {
        return (new String(Base64.encodeBase64(
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

package me.imyu.authz;

/**
 * Created by imyu on 2018-02-08.
 */
public class AuthzException extends RuntimeException {
    public AuthzException(String message) {
        super(message);
    }

    public AuthzException(String message, Throwable cause) {
        super(message, cause);
    }
}

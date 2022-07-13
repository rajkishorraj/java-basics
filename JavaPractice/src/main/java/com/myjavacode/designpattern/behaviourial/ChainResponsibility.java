package com.myjavacode.designpattern.behaviourial;


public class ChainResponsibility {

    public static void main(String[] args) {
        AuthenticationProvider authenticationProvider = getChainOfAuthProcessor();
        authenticationProvider.isAuthorized(new OAuthToken());
    }

    private static AuthenticationProvider getChainOfAuthProcessor() {
        AuthenticationProvider authenticationProvider = new OAuthProvider(null);
        return new UserNamePasswordAuthenticationProvider(authenticationProvider);
    }

}

abstract class AuthenticationProvider {

    public AuthenticationProvider nextAuthenticationProvider;

    abstract boolean isAuthorized(Token token);
}

class OAuthProvider extends AuthenticationProvider {

    OAuthProvider(AuthenticationProvider nextProvider) {
        nextAuthenticationProvider = nextProvider;
    }

    @Override
    boolean isAuthorized(Token token) {
        if (token instanceof UserNamePasswordToken) {
            return true;
        } else if (nextAuthenticationProvider != null) {
            nextAuthenticationProvider.isAuthorized(token);
        }

        return false;
    }
}

class UserNamePasswordAuthenticationProvider extends AuthenticationProvider {

    UserNamePasswordAuthenticationProvider(AuthenticationProvider nextProvider) {
        nextAuthenticationProvider = nextProvider;
    }

    @Override
    boolean isAuthorized(Token token) {
        if (token instanceof UserNamePasswordToken) {
            return true;
        } else if (nextAuthenticationProvider != null) {
            nextAuthenticationProvider.isAuthorized(token);
        }
        return false;
    }
}

abstract class Token {
    String id;
}

class UserNamePasswordToken extends Token {

}

class OAuthToken extends Token {

}


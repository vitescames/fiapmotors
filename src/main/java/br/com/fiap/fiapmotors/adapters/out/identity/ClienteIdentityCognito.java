package br.com.fiap.fiapmotors.adapters.out.identity;

import br.com.fiap.fiapmotors.core.port.out.ClienteIdentityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminSetUserPasswordRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.MessageActionType;

@Service
@RequiredArgsConstructor
public class ClienteIdentityCognito implements ClienteIdentityPort {
    private final CognitoIdentityProviderClient cognitoClient;

    private final String userPoolId = "us-east-1_jZ4awgdKz";
    private final String appClientId = "6idfem8og9rgnf44qv5o5ta7lu";

    @Override
    public String registrar(String email, String senha) {
        cognitoClient.adminCreateUser(AdminCreateUserRequest.builder()
                .userPoolId(userPoolId)
                .username(email)
                .userAttributes(
                        AttributeType.builder().name("email").value(email).build(),
                        AttributeType.builder().name("email_verified").value("true").build()
                )
                .messageAction(MessageActionType.SUPPRESS)
                .build());

        cognitoClient.adminSetUserPassword(AdminSetUserPasswordRequest.builder()
                .userPoolId(userPoolId)
                .username(email)
                .password(senha)
                .permanent(true)
                .build());

        var user = cognitoClient.adminGetUser(builder -> builder
                .userPoolId(userPoolId)
                .username(email));

        return user.userAttributes().stream()
                .filter(attr -> "sub".equals(attr.name()))
                .map(AttributeType::value)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("sub não encontrado no Cognito"));
    }
}

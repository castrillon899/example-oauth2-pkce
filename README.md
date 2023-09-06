# Ejemplo de OAuth2 con PKCE
Este es un ejemplo de cómo utilizar la autenticación OAuth2 para clientes JavaScript. Es importante tener en cuenta que este enfoque no se considera completamente seguro, ya que no implementa ningún método de autenticación en el lado de la aplicación del cliente.

El método "none" indica que no se debe utilizar ningún método de autenticación para el cliente, lo que significa que el cliente no proporciona ninguna prueba de su identidad al solicitar el token de acceso. Esto puede ser un riesgo de seguridad, ya que cualquier persona podría solicitar un token de acceso sin autenticarse adecuadamente.



## Introducción

En este ejemplo, el cliente envía code_challenge al servidor OAuth2 como parte del intercambio de tokens. A continuación, se proporciona un ejemplo de code_challenge y code_verifier:

- code_challenge: wd5lR3j27YXK2FOOAfmyyrjFMBWO8SB85sVUkkiXrW4
- code_verifier: 8b876fc78b3ca6f51dca057013207ace265567bdd314dd9adb563393
Si deseas generar estos valores, puedes visitar el siguiente enlace: [Generador de PKCE](https://example-app.com/pkce).

## Paso 1: Solicitud de Intercambio de Código
Primero, realizamos una solicitud de intercambio de código al servidor OAuth2. La URL de autorización es la siguiente:

http://127.0.0.1:8080/oauth2/authorize?response_type=code&client_id=123456&redirect_uri=http%3A%2F%2F127.0.0.1%3A3000%2Fcallback&code_challenge_method=S256&code_challenge=wd5lR3j27YXK2FOOAfmyyrjFMBWO8SB85sVUkkiXrW4&state=hola&continue
El servidor responderá con un callback que incluirá el token.

## Paso 2: Intercambio de Código por Token
A continuación, tomamos el token obtenido y ejecutamos el siguiente comando curl para intercambiar el código por un token de acceso:


curl --location --request POST 'http://localhost:8080/oauth2/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: JSESSIONID=5C21DA74C775B14370A84B125D143DC3' \
--data-urlencode 'grant_type=authorization_code' \
--data-urlencode 'code=o_eHPT3R6TnmR2MJgt8OxZ0q9fZrBq7YGbfjjj35-dHYEBoVWmnfiodkPW7lhjo5vwqhgv0uTrTxTr5DE08tkX_GLizbEhUxukZxtHVCn_4ViHWhJZZxrlZgYKaKsYpI' \
--data-urlencode 'client_id=123456' \
--data-urlencode 'code_challenge_method=S256' \
--data-urlencode 'code_verifier=8b876fc78b3ca6f51dca057013207ace265567bdd314dd9adb563393' \
--data-urlencode 'state=hola' \
--data-urlencode 'redirect_uri=http://127.0.0.1:3000/callback'
Con estos pasos, puedes implementar la autenticación OAuth2 en un cliente JavaScript de forma segura y eficiente.

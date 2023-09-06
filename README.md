# example-oauth2-pkce
Este es un ejemplo de como usar la autenticacion oauth2 para clientes javascript, 
No es considerado del todo seguro por que no tiene algun metodo de autenticacion por el lado de aplicacion del cliente



Como punto importante el cliente envia code_challenge para intercambiarlo con el servidor oauth2
code_challenge=wd5lR3j27YXK2FOOAfmyyrjFMBWO8SB85sVUkkiXrW4
code_verifier=8b876fc78b3ca6f51dca057013207ace265567bdd314dd9adb563393


Si quieres generarlo puedes ir a:
https://example-app.com/pkce


Primero hacemos una solicitud de intercambio de codigo con el servidor oauth2
Este nos retornara un callback con el token


http://127.0.0.1:8080/oauth2/authorize?response_type=code&client_id=123456&redirect_uri=http%3A%2F%2F127.0.0.1%3A3000%2Fcallback&code_challenge_method=S256&code_challenge=wd5lR3j27YXK2FOOAfmyyrjFMBWO8SB85sVUkkiXrW4&state=hola&continue



Luego tomamos ese token y ejecutamos 
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

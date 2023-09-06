# example-oauth2-pkce
Este es un ejemplo de como usar la autenticacion oauth2 para clientes javascript



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

# Notes

## When to move away from Self-Signed JWTs without an auth server
When the trade-offs are no longer acceptable:
 - When you need a refresh token

A distinct auth server makes more sense when you have multiple services or
when you want to be able to harden security. The distinct auth server may
be something like Spring Authorization server but it also might be something
like Okta - your resource servers can then consult that auth server to
authorise requests.

See https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html

## Making a public/private key pair for JWT
 - ```openssl genrsa -out keypair.pem 2048```
 - ```openssl rsa -in keypair.pem -pubout -out public.pem```

Finally we need our key in the right format.
 - ```openssl pkcs8 -topk8 -inform PEM -outform PEM -nocrypt -in keypair.pem -out private.pem```

Now public.pem is not needed.

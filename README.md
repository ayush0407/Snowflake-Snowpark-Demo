# Snowflake-Snowpark-Demo

1. Using Java-17
2. As Java-17 is not fully compatible with Snowpark I was running into some session related issues. The fix for which is the below command.
3. java --add-exports java.base/sun.net.www=ALL-UNNAMED -jar sf-0.0.1-SNAPSHOT.jar
4. This project demos how can we connect with Snowflake using Snowpark and call stored procedures, queries etc.

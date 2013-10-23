# First, we generated the server keystore with a self signed cert.
# Note that we needed to use a "First Name, Last Name" of "jetty".
# Password is "password".
keytool -keystore server.keystore -alias jetty -genkey -keyalg RSA -validity 11499

# Then, we exported the cert and called "jetty.crt"
keytool -export -keystore server.keystore -alias jetty -file jetty.crt

# Then, we created a client keystore and in the process imported the jetty cert as a trusted cert.
# Note: Type "yes" when prompted to trust the cert!
# Password: password
keytool -import -trustcacerts -alias jetty -file jetty.crt -keystore client.keystore

# List the certs
keytool -list -keystore client.keystore 

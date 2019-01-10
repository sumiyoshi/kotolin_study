import org.junit.Assert.*
import org.junit.*

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

import java.security.MessageDigest;
import java.math.BigInteger


class AuthTest {

    private val secret = "honmani secret na key"

    @Test
    fun testJwt() {
        val subject = "some subject"
        val token = generateToken(subject)
        val _subject = Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
        assertEquals(_subject.body["sub"], subject)
    }

    fun generateToken(subject: String): String {
        val expiration = LocalDateTime.now().plusHours(1).atZone(ZoneId.systemDefault())
        return Jwts.builder()
            .setSubject(subject)
            .setAudience("aud")
            .setIssuer("Iss")
            .setHeaderParam("typ", "JWT")
            .setExpiration(Date.from(expiration.toInstant()))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

    @Test
    fun testPassword() {
        val password = "test"
        assertEquals(getSHA256(password), getSHA256(password))
    }

    fun getSHA256(input: String): String? {

        val message = input + "salt"

        var toReturn: String? = null
        try {
            val digest = MessageDigest.getInstance("SHA-256")
            digest.reset()
            digest.update(message.toByteArray(charset("utf8")))
            toReturn = String.format("%040x", BigInteger(1, digest.digest()))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return toReturn
    }

}

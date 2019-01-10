import org.junit.Assert.*
import org.junit.*

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

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
            .setAudience("Qiita_sample")
            .setHeaderParam("typ", "JWT")
            .setExpiration(Date.from(expiration.toInstant()))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

}

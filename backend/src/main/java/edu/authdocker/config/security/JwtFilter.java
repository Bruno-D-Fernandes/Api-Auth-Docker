package edu.authdocker.config.security;

import com.auth0.jwt.JWT;
import edu.authdocker.model.Usuario;
import edu.authdocker.repository.UsuarioRepository;
import jakarta.servlet.FilterChain;
import org.hibernate.type.descriptor.sql.internal.Scale6IntervalSecondDdlType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private JwtService jwtService;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public JwtFilter(JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getToken(request);
        String tokenValidado = jwtService.validateToken(token);

        if(tokenValidado != null){
            String email = jwtService.validateToken(tokenValidado);
            Usuario usuario = usuarioRepository.findByEmail(email);

            Authentication authentication = new UsernamePasswordAuthenticationToken(usuario.getEmail(), null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request){
        String rawToken = request.getHeader("Authorization");
        if(rawToken == null || rawToken.length() < 7) return null;
        
        return rawToken.replace("Bearer: ", "");
    }
}

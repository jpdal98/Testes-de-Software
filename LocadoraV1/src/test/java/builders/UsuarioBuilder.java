package builders;

import br.ufc.entities.Usuario;

public class UsuarioBuilder {

	private Usuario usuario;
	
	private void UsuarioBulder() {
		
	}
	
	public static UsuarioBuilder umUsuario() {
		UsuarioBuilder builder = new UsuarioBuilder();
		builder.usuario = new Usuario();
		builder.usuario.setNome("Pedro");
		return builder;
	}
	
	public Usuario agora() {
		return usuario;
	}
}

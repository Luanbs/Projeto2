package avaliacao;

public class Usuario {

    private String nome;
    private String cpf;
    private String email;
    private String senha;

    //Perfil 0 - Administrativo;
    //Perfil 1 - Operacional;
    //Perfil 2 - RH;
    private boolean[] perfilAcesso;

    public Usuario(String nome, String cpf, String email, String senha, boolean[] perfilAcesso) throws IllegalArgumentException{
        this.nome = nome;
        this.perfilAcesso=perfilAcesso;

        if (senha.length()>=8 && !senha.matches("^([^0-9]*|[^a-zA-Z]*)$") && !senha.contains(" ")) {
             this.senha = senha;
         }else{
             throw new IllegalArgumentException("Senha deve possuir no mínimo 8 caracteres, uma letra, um número e sem espaçamento.");
         }


        if (email.matches("\\w+@\\w+\\.[\\w&&[^0-9]]+")) {
            this.email = email;
        }else{
            throw new IllegalArgumentException("Email inválido.");
        }


        if(cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            this.cpf = cpf;
        }else{
            throw new IllegalArgumentException("CPF esperado no formato 'XXX.XXX.XXX-XX'");
        }
    }

    public void setPerfilAcesso(Usuario usuario, boolean[] perfilAcesso, Usuario usuarioAlvo) {
        if (usuario.hasAdminAccess()) {
            usuarioAlvo.perfilAcesso = perfilAcesso;
        }
    }

    public boolean hasAdminAccess(){
        return perfilAcesso[0];
    }
    public boolean hasOpAccess(){
        return perfilAcesso[1];
    }
    public boolean hasRhAccess(){
        return perfilAcesso[2];
    }
}
package avaliacao;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class Modulo {
    private Trilha trilha;
    private String nome;
    private String habilidades;
    private  String tarefa;
    private StatusEnum status;
    private int prazoLimite;
    private OffsetDateTime dataModuloIniciado;
    private OffsetDateTime dataAvaliacaoInicial;
    private OffsetDateTime dataModuloFinalizado;
    public static List<Modulo> modulos = new ArrayList<>();


    public Modulo(Trilha trilha, String nome, String habilidades, String tarefa) {
        this.trilha = trilha;
        this.nome = nome;
        this.habilidades = habilidades;
        this.tarefa = tarefa;
        this.prazoLimite=10;
        this.status=StatusEnum.NAO_INICIADO;

    }

    public void setStatus(Usuario usuario, StatusEnum status) throws IllegalAccessException {
        if (usuario.hasAdminAccess()) {
            this.status = status;
            if (status.equals(StatusEnum.ANDAMENTO)){
                this.dataModuloIniciado=OffsetDateTime.now();
            }
            if (status.isDisponivelAvaliar()){
                this.dataAvaliacaoInicial=OffsetDateTime.now();
                this.dataModuloFinalizado=OffsetDateTime.now();
            }
        }else{
            throw new IllegalAccessException("Usuário não possui perfil de acesso: ADMINISTRATIVO");
        }
    }

    public String getNome() {
        return nome;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public String getTarefa() {
        return tarefa;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public OffsetDateTime getDataAvaliacaoInicial() {
        return dataAvaliacaoInicial;
    }

    public OffsetDateTime getDataModuloFinalizado() {
        return dataModuloFinalizado;
    }
}

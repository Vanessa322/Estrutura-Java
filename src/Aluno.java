public class Aluno implements Comparable<Aluno> {

    private String nome;
    private int ra;
    private int idade;
    private char sexo;
    private double media;
    private String resultado;

    public Aluno(String nome, int ra, int idade, char sexo, double media) {
        this.nome = nome;
        this.ra = ra;
        this.idade = idade;
        this.sexo = sexo;
        this.media = media;
        this.resultado = calcularResultado(media);
    }

    private String calcularResultado(double media) {
        return (media >= 6.0) ? "Aprovado" : "Reprovado";
    }

    public String getNome() {
        return nome;
    }

    public int getRa() {
        return ra;
    }

    public int getIdade() {
        return idade;
    }

    public char getSexo() {
        return sexo;
    }

    public double getMedia() {
        return media;
    }

    public String getResultado() {
        return resultado;
    }

    // Ordem natural do Aluno: por nome, A-Z (usado pelos relatórios "por Nome")
    @Override
    public int compareTo(Aluno outro) {
        return this.nome.compareToIgnoreCase(outro.nome);
    }

    @Override
    public String toString() {
        return String.format(
                "RA: %-6d | Nome: %-20s | Idade: %-3d | Sexo: %-1s | Média: %-5.2f | Resultado: %s",
                ra, nome, idade, sexo, media, resultado
        );
    }
}

package cinema;

public class Filme {
    private String titulo;
    private int duracao;
    private int classificacao;
    private String categoria;
    private String sinopse;

    public Filme(String titulo, int duracao, String categoria, int classificacao) {
        this.titulo = titulo;
        
        if (duracao > 0) {
            this.duracao = duracao;
        } else {
            this.duracao = 90;
        }
        
        if (classificacao >= 0) {
            this.classificacao = classificacao;
        } else {
            this.classificacao = 0;
        }
        
        this.sinopse = "Não informada";
        
        boolean resultadoCategoria = setCategoria(categoria);
        if (resultadoCategoria == false) {
            this.categoria = "Ação";
        }
    }

    public Filme(String titulo, int duracao) {
        this.titulo = titulo;
        
        if (duracao > 0) {
            this.duracao = duracao;
        } else {
            this.duracao = 90;
        }
        
        this.classificacao = 0;
        this.categoria = "Ação";
        this.sinopse = "Não informada";
    }

    public String getTitulo() {
        return this.titulo;
    }

    public int getDuracao() {
        return this.duracao;
    }

    public int getClassificacao() {
        return this.classificacao;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String novaSinopse) {
        this.sinopse = novaSinopse;
    }

    public boolean setCategoria(String novaCategoria) {
        if (novaCategoria.equalsIgnoreCase("Ação")) {
            this.categoria = "Ação";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Acao")) {
            this.categoria = "Ação";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Aventura")) {
            this.categoria = "Aventura";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Comédia")) {
            this.categoria = "Comédia";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Comedia")) {
            this.categoria = "Comédia";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Drama")) {
            this.categoria = "Drama";
            return true;
        }
        if (novaCategoria.equalsIgnoreCase("Terror")) {
            this.categoria = "Terror";
            return true;
        }
        
        return false;
    }

    public boolean podeAssistir(int idade) {
        if (idade < 0) {
            return false;
        }
        
        if (idade >= this.classificacao) {
            return true;
        } else {
            return false;
        }
    }
}
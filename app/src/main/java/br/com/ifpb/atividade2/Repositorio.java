package br.com.ifpb.atividade2;

import java.util.Objects;

public class Repositorio {
    private String autor;
    private String nome;
    private String descricao;
    private String url_foto;

    public Repositorio() {
    }

    public Repositorio(String autor, String nome, String descricao, String url_foto) {
        this.autor = autor;
        this.nome = nome;
        this.descricao = descricao;
        this.url_foto = url_foto;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repositorio that = (Repositorio) o;
        return Objects.equals(autor, that.autor) &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(url_foto, that.url_foto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(autor, nome, descricao, url_foto);
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "autor='" + autor + '\'' +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", url_foto='" + url_foto + '\'' +
                '}';
    }
}

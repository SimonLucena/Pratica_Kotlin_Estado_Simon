package com.example.pratica_estado_simonlucenadecastro.repositorio

class Galeria {
    private val repositorio = mutableListOf<Repositorio>()

    fun addImagem(imagem: Repositorio) {
        repositorio.add(imagem)
    }

    // Método público para obter o tamanho da lista repositorio
    fun getTamanhoRepositorio(): Int {
        return (repositorio.size-1)
    }

    fun getArquivo(index: Int): String?{
        val imagem = repositorio.find { it.indice == index }
        return imagem?.arquivo
    }
    fun getTitulo(index: Int): String?{
        val imagem = repositorio.find { it.indice == index }
        return imagem?.titulo
    }
    fun getDescricao(index: Int): String?{
        val imagem = repositorio.find { it.indice == index }
        return imagem?.descricao
    }
}
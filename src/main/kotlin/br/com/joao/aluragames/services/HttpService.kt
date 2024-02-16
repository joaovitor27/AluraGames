package br.com.joao.aluragames.services

class HttpService (
    private val url: String
){
    fun get(): String {
        return java.net.http.HttpClient.newHttpClient().send(
            java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun post(body: Any): String {
        return java.net.http.HttpClient.newHttpClient().send(
            java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .POST(java.net.http.HttpRequest.BodyPublishers.ofString(body.toString()))
                .build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun put(): String {
        return java.net.http.HttpClient.newHttpClient().send(
            java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .PUT(java.net.http.HttpRequest.BodyPublishers.ofString(""))
                .build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun delete(): String {
        return java.net.http.HttpClient.newHttpClient().send(
            java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .DELETE()
                .build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun patch(): String {
        return java.net.http.HttpClient.newHttpClient().send(
            java.net.http.HttpRequest.newBuilder()
                .uri(java.net.URI.create(url))
                .method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofString(""))
                .build(),
            java.net.http.HttpResponse.BodyHandlers.ofString()
        ).body()
    }
}

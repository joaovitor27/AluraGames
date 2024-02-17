package br.com.joao.aluragames.services

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class HttpService(
    private val url: String
) {
    fun get(): String {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun post(body: Any): String {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                .POST(HttpRequest.BodyPublishers.ofString(body.toString()))
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun put(): String {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(""))
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun delete(): String {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                .DELETE()
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()
    }

    fun patch(): String {
        return HttpClient.newHttpClient().send(
            HttpRequest.newBuilder()
                .uri(URI.create(url))
                .method("PATCH", HttpRequest.BodyPublishers.ofString(""))
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()
    }
}

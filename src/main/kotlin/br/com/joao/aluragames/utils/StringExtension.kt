package br.com.joao.aluragames.utils

import java.text.Normalizer
import java.util.regex.Pattern


fun String.removeAccents(): String {
    val normalizer: String = Normalizer.normalize(this, Normalizer.Form.NFD)
    val pattern: Pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
    return pattern.matcher(normalizer).replaceAll("")
}


package br.com.joao.aluragames.utils

import java.text.Normalizer
import java.util.regex.Pattern

class Utils {
    fun removeAccents(value: String?): String {
        val normalizer: String = Normalizer.normalize(value, Normalizer.Form.NFD)
        val pattern: Pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        return pattern.matcher(normalizer).replaceAll("")
    }
}

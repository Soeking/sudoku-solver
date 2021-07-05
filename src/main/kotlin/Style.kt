import kotlinx.css.*
import styled.StyleSheet

object Style : StyleSheet("Style", isStatic = true) {
    private val style = CSSBuilder().apply {
        body {
            fontSize = 15.px
        }
    }

    val button by css {

    }

    fun applyStyle() {
        styled.injectGlobal(style.toString())
    }
} 

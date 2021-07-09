import kotlinx.css.*
import styled.StyleSheet

object Style : StyleSheet("Style", isStatic = true) {
    private val style = CSSBuilder().apply {
        body {
            fontSize = 35.px
        }
    }

    val board by css {
        margin(30.px)
        display = Display.grid
        gridTemplateColumns = GridTemplateColumns(40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px)
        gridTemplateRows = GridTemplateRows(40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px, 40.px)
    }

    val input by css {
        width = 40.px
        height = 40.px
        textAlign = TextAlign.center
        margin(0.px)
        padding(0.px)
    }

    val button by css {

    }

    fun applyStyle() {
        styled.injectGlobal(style.toString())
    }
} 

import kotlinx.css.*
import kotlinx.css.properties.border
import styled.StyleSheet

object Style : StyleSheet("Style", isStatic = true) {
    private val gridSize = 40.px
    private val smallBoardSize = 123.px

    private val style = CSSBuilder().apply {
        body {
            fontSize = 35.px
        }
    }

    val board by css {
        margin(30.px)
        display = Display.grid
        gridTemplateColumns = GridTemplateColumns(*Array(3) { smallBoardSize })
        gridTemplateRows = GridTemplateRows(*Array(3) { smallBoardSize })
        columnGap = Gap("1px")
        rowGap = Gap("1px")
    }

    val smallBoard by css {
        border(2.px, BorderStyle.solid, Color.black)
        display = Display.grid
        gridTemplateColumns = GridTemplateColumns(*Array(3) { 41.px })
        gridTemplateRows = GridTemplateRows(*Array(3) { 41.px })
        columnGap = Gap("1px")
        rowGap = Gap("1px")
    }

    val input by css {
        width = gridSize
        height = gridSize
        textAlign = TextAlign.center
        margin(0.px)
        padding(0.px)
    }

    val grid by css {
        width = gridSize
        height = gridSize
        border(1.px, BorderStyle.solid, Color.black)
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

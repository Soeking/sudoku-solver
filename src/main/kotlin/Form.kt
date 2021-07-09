import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledInput

class Form : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                +Style.board
            }
            for (i in 0..8) {
                for (j in 0..8) {
                    styledInput {
                        css {
                            +Style.input
                        }
                    }
                }
            }
        }

        styledButton {
            css {
                +Style.button
            }
            +"calc"
            attrs.onClickFunction = {}
        }

        styledButton {
            css {
                +Style.button
            }
            +"reset"
            attrs.onClickFunction = {}
        }
    }
}

fun RBuilder.form() = child(Form::class) {}
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
            for(n in 0..2){
                for (m in 0..2){
                    styledDiv {
                        css {
                            +Style.smallBoard
                        }
                        for (i in 0..2) {
                            for (j in 0..2) {
                                styledInput {
                                    css {
                                        +Style.input
                                    }
                                }
                            }
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
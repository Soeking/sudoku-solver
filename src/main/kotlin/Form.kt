import kotlinx.html.js.onClickFunction
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledButton

class Form : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
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
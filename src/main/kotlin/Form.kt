import kotlinx.html.InputType
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import org.w3c.dom.HTMLInputElement
import react.*
import styled.css
import styled.styledButton
import styled.styledDiv
import styled.styledInput

interface FormState : RState {
    var text: String
    var numbers: Array<Array<Int>>
    var isEdit: Boolean
}

class Form : RComponent<RProps, FormState>() {
    init {
        state.run {
            text = "please input"
            numbers = Array(9) { Array(9) { 0 } }
            isEdit = true
        }
    }

    override fun RBuilder.render() {
        +state.text
        styledDiv {
            css {
                +Style.board
            }
            for (n in 0..2) {
                for (m in 0..2) {
                    styledDiv {
                        css {
                            +Style.smallBoard
                        }
                        for (i in 0..2) {
                            for (j in 0..2) {
                                if (state.isEdit) {
                                    styledInput {
                                        css {
                                            +Style.input
                                        }
                                        attrs {
                                            type = InputType.text
                                            onChangeFunction = {
                                                setState {
                                                    numbers[n * 3 + i][m * 3 + j] =
                                                        checkNumber((it.target as HTMLInputElement).value)
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    styledDiv {
                                        css {
                                            +Style.grid
                                        }
                                        +state.numbers[n * 3 + i][m * 3 + j].let { if (it != 0) it.toString() else "" }
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
            attrs.onClickFunction = {
                calc()
            }
        }

        styledButton {
            css {
                +Style.button
            }
            +"reset"
            attrs.onClickFunction = {
                reset()
            }
        }
    }

    private fun checkNumber(x: String): Int {
        val res = x.toIntOrNull() ?: 0
        return if (res in 1..9) res else 0
    }

    private fun calc() {
        setState {
            isEdit = false
            Solver(numbers).solve().let {
                text = if (it) "answer is"
                else "impossible"
            }
        }
    }

    private fun reset() {
        setState {
            isEdit = true
            numbers.forEach {
                repeat(9) { i ->
                    it[i] = 0
                }
            }
            text = "please input"
        }
    }
}

fun RBuilder.form() = child(Form::class) {}
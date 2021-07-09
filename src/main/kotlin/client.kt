import react.dom.render
import kotlinx.browser.document
import kotlinx.browser.window

fun main() {
    Style.applyStyle()
    window.onload = {
        render(document.getElementById("root")) {
            form()
        }
    }
}

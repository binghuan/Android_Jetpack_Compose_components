package com.bh.androidx_material_samples.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextWithLinks() {
    val url = "https://developer.android.com/jetpack/compose"

    val linkColor = MaterialTheme.colors.primary
    val linkStyle =
        SpanStyle(color = linkColor, textDecoration = TextDecoration.Underline)

    val annotatedString = buildAnnotatedString {
        append("Build better apps faster with ")
        withLink(
            LinkAnnotation.Url(
                url = url, styles = TextLinkStyles(style = linkStyle)
            )
        ) {
            append("Jetpack Compose")
        }
    }
    // Note that if your string is defined in resources, you can pass the same link style object
    // when constructing the AnnotatedString using the AnnotatedString.fromHtml method.
    Text(annotatedString)
}

@Preview
@Composable
fun TextWithLinksPreview() {
    TextWithLinks()
}



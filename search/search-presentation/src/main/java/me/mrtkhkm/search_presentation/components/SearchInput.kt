package me.mrtkhkm.search_presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import me.mrtkhkm.common.R
import me.mrtkhkm.ui.LocalSpacing

@Composable
fun SearchInput(
    value: String,
    onValueChange: (String) -> Unit
) {
    val spacing = LocalSpacing.current
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceMedium),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(text = stringResource(id = R.string.search_placeholder))
            },
            trailingIcon = {
                IconButton(
                    onClick = { onValueChange("") }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        modifier = Modifier,
                        contentDescription = null
                    )
                }
            },
            shape = MaterialTheme.shapes.large,
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onValueChange(value)
                }
            ),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    SearchInput(
        "",
    ) {}
}
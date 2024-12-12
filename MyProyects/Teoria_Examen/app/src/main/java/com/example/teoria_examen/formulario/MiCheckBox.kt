package com.example.teoria_examen.formulario

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment

@Composable
fun MiCheckBox(checked: List<String>, checkedList: SnapshotStateList<Boolean>) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            for (i in checkedList.indices) {
                Text(text = checked[i])
                Checkbox(
                    checked = checkedList[i],
                    onCheckedChange = { checkedList[i] = it }
                )
            }
        }
    }
}
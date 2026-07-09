package com.ancp.engdept.teacherscreens.thomescreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider

data class TeacherClass(
    val courseType: String,
    val semester: String,
    val session: String,
    val subject: String,
    val time: String,
    val room: String,
    val cr: String,
    val topic: String
)

@Composable
fun TeacherHomeScreen() {

    val classes = listOf(
        TeacherClass(
            "MJC",
            "Semester 4",
            "2024–28",
            "British Literature",
            "09:00 AM - 10:00 AM",
            "Room 204",
            "Nita Kumari",
            "The Romantic Age"
        ),
        TeacherClass(
            "MIC",
            "Semester 2",
            "2025–29",
            "English Grammar",
            "11:00 AM - 12:00 PM",
            "Room 105",
            "Amit Kumar",
            "Voice"
        ),
        TeacherClass(
            "AEC",
            "Semester 1",
            "2026–30",
            "Communicative English",
            "01:00 PM - 02:00 PM",
            "Room 110",
            "Priya Singh",
            "Listening Skills"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        item {
            GreetingCard(classCount = classes.size)
        }

        item {
            Text(
                text = "Today's Classes",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }

        items(classes) {
            TeacherClassCard(it)
        }
    }
}

@Composable
private fun GreetingCard(classCount: Int) {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Text(
                "Good Morning 👋",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                "Friday, 10 July",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(18.dp))

            AssistChip(
                onClick = {},
                label = {
                    Text("Today's Classes : $classCount")
                }
            )
        }
    }
}

@Composable
private fun TeacherClassCard(item: TeacherClass) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        "${item.courseType} • ${item.semester}",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        item.subject,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Box {

                    IconButton(
                        onClick = { expanded = true }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {

                        DropdownMenuItem(
                            text = { Text("Start Class") },
                            onClick = { expanded = false }
                        )

                        DropdownMenuItem(
                            text = { Text("Mark Attendance") },
                            onClick = { expanded = false }
                        )

                        DropdownMenuItem(
                            text = { Text("Upload Material") },
                            onClick = { expanded = false }
                        )

                        DropdownMenuItem(
                            text = { Text("Create Assignment") },
                            onClick = { expanded = false }
                        )

                        DropdownMenuItem(
                            text = { Text("Post Notice") },
                            onClick = { expanded = false }
                        )

                        DropdownMenuItem(
                            text = { Text("Edit Topic") },
                            onClick = { expanded = false }
                        )
                    }
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))

            InfoRow("📚", "Course", item.courseType)
            InfoRow("🎓", "Session", item.session)
            InfoRow("🕒", "Time", item.time)
            InfoRow("🏫", "Room", item.room)
            InfoRow("👤", "CR", item.cr)
            InfoRow("📖", "Topic", item.topic)
        }
    }
}

@Composable
private fun InfoRow(
    icon: String,
    title: String,
    value: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {

        Text(
            text = icon,
            modifier = Modifier.padding(end = 8.dp)
        )

        Text(
            text = "$title:",
            modifier = Modifier.weight(0.35f),
            fontWeight = FontWeight.SemiBold
        )

        Text(
            text = value,
            modifier = Modifier.weight(0.65f)
        )
    }
}
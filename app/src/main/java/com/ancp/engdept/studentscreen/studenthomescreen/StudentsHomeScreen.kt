package com.ancp.engdept.studentscreen.studenthomescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

data class Notice(
    val title: String,
    val time: String
)

data class TodayClass(
    val time: String,
    val subject: String,
    val teacher: String,
    val room: String,
    val studentsOpted: Int,
    val arrived: Int
)

@Composable
fun StudentHomeScreen() {

    val notices = listOf(
        Notice("Assignment submission by Friday", "10 min ago"),
        Notice("English class shifted to Room 204", "1 hr ago"),
        Notice("Library will remain closed tomorrow", "Yesterday")
    )

    val classes = listOf(
        TodayClass(
            "09:00",
            "British Literature",
            "Dr. Anjali Sharma",
            "204",
            62,
            41
        ),
        TodayClass(
            "11:00",
            "English Grammar",
            "Dr. Rajesh Kumar",
            "105",
            58,
            36
        ),
        TodayClass(
            "01:00",
            "Communicative English",
            "Dr. P. Singh",
            "110",
            54,
            29
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateTopPadding() + 16.dp,
            bottom = WindowInsets.safeDrawing
                .asPaddingValues()
                .calculateBottomPadding() + 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        item {
            StudentHeader()
        }

        item {
            SectionTitle("Today's Classes")
        }

        items(classes) {
            CompactClassItem(it)
        }

        item {
            Spacer(modifier = Modifier.height(4.dp))
            SectionTitle("Latest Notices")
        }

        items(notices) {
            NoticeItem(it)
        }
    }
}

@Composable
private fun StudentHeader() {

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {

                Text(
                    "Ranjan Kumar",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    "Session: 2024–28 • Semester IV",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    "Class Roll: 18",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    "University Roll: 24101018",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
private fun SectionTitle(title: String) {

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun CompactClassItem(item: TodayClass) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 1.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Schedule,
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    item.subject,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    "${item.time} • Room ${item.room}",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    "Teacher: ${item.teacher}",
                    style = MaterialTheme.typography.bodySmall
                )

                Text(
                    "Opted ${item.arrived}/${item.studentsOpted}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            FilledTonalButton(
                onClick = {
                    // TODO: Opt for class
                }
            ) {
                Text("Opt")
            }
        }
    }
}

@Composable
private fun NoticeItem(item: Notice) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable { },
        shape = RoundedCornerShape(12.dp),
        tonalElevation = 1.dp
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    item.title,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    item.time,
                    style = MaterialTheme.typography.bodySmall
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null
            )
        }
    }
}
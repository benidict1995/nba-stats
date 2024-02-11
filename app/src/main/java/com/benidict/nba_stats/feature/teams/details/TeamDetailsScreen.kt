package com.benidict.nba_stats.feature.teams.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.benidict.domain.model.Team
import com.benidict.nba_stats.R
import com.benidict.nba_stats.ext.SpaceMaxWidth
import com.benidict.nba_stats.ui.theme.NbastatsTheme

@Composable
fun TeamDetailsScreen(team: Team) {
    Log.d("makerChecker", "team:$team")
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        56.SpaceMaxWidth()
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp
                )
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            val (
                imgTeam,
                txtFullName,
                txtConference
            ) = createRefs()
            val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
            Image(painter = image, contentDescription = "",
                modifier = Modifier
                    .constrainAs(imgTeam) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .height(100.dp)
                    .width(100.dp)
            )

            Text(text = team.fullName,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier.constrainAs(txtFullName) {
                    start.linkTo(imgTeam.end)
                    top.linkTo(parent.top)
                }.padding(start = 8.dp)
            )

            Text(text = "${team.conference} ${team.division}" ,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                modifier = Modifier.constrainAs(txtConference) {
                    start.linkTo(imgTeam.end)
                    top.linkTo(txtFullName.bottom)
                }.padding(start = 8.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamDetailsScreenPreview() {
    NbastatsTheme {
        TeamDetailsScreen(team = Team.empty)
    }
}
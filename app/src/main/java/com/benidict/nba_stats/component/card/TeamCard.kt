package com.benidict.nba_stats.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.benidict.domain.model.Team
import com.benidict.nba_stats.R
import com.benidict.nba_stats.ui.theme.NbastatsTheme

@Composable
fun TeamCard(team: Team) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { }
    ){
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    16.dp, 8.dp, 16.dp, 8.dp
                )
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            val (
                imageTeam,
                textTeamName,
                textView,
                textConference
            ) = createRefs()
            val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(imageTeam) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .height(60.dp)
                    .width(60.dp)
            )

            Text(
                text = team.fullName,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.constrainAs(textTeamName){
                    top.linkTo(imageTeam.top)
                    start.linkTo(imageTeam.end, 10.dp)
                }
            )
            
            Text(
                text = stringResource(id = R.string.conference, team.conference),
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                modifier = Modifier.constrainAs(textConference){
                    top.linkTo(textTeamName.bottom)
                    start.linkTo(imageTeam.end, 10.dp)
                }
            )

            Text(
                text = stringResource(id = R.string.view),
                fontSize = 14.sp,
                color = Color.Blue,
                modifier = Modifier.constrainAs(textView) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TeamCardPreview() {
    NbastatsTheme {
        TeamCard(Team.dummyData)
    }
}
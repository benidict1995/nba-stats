package com.benidict.nba_stats.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.benidict.domain.model.Game
import com.benidict.nba_stats.R
import com.benidict.nba_stats.ui.theme.NbastatsTheme

@Composable
fun GameCard(game: Game) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable { }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(
                    16.dp, 8.dp, 16.dp, 8.dp
                )
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            val (
                lblFinal,
                lblSeparator,
                imgHomeCourtTeam,
                txtHomeCourtTeamName,
                txtHomeCourtTeamScore,
                imgVisitorTeam,
                txtVisitorCourtTeamScore,
                txtVisitorCourtTeamName
            ) = createRefs()

            val image: Painter = painterResource(id = R.drawable.ic_launcher_background)
            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(imgHomeCourtTeam) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        end.linkTo(txtHomeCourtTeamScore.start)
                    }
                    .height(100.dp)
                    .width(60.dp)
            )


            Image(
                painter = image,
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(imgVisitorTeam) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(txtVisitorCourtTeamScore.end)
                    }
                    .height(100.dp)
                    .width(60.dp)
            )

            Text(text = game.team.name,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                modifier = Modifier.constrainAs(txtHomeCourtTeamName) {
                    end.linkTo(lblSeparator.start, margin = 30.dp)
                    bottom.linkTo(txtHomeCourtTeamScore.top)
                })

            Text(text = game.score.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.constrainAs(txtHomeCourtTeamScore) {
                    start.linkTo(txtHomeCourtTeamName.start)
                    end.linkTo(txtHomeCourtTeamName.end)
                    top.linkTo(imgHomeCourtTeam.top)
                    bottom.linkTo(imgHomeCourtTeam.bottom)
                })

            Text(
                text = stringResource(id = R.string.lbl_separator),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.constrainAs(lblSeparator) {
                    top.linkTo(txtHomeCourtTeamScore.top)
                    bottom.linkTo(txtHomeCourtTeamScore.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end
                    )
                }
            )

            Text(
                text = stringResource(id = R.string.lbl_final),
                fontWeight = FontWeight.Bold,
                fontSize = 10.sp,
                modifier = Modifier.constrainAs(lblFinal) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(txtHomeCourtTeamName.top)
                }
            )

            Text(text = game.visitorTeam.name,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                modifier = Modifier.constrainAs(txtVisitorCourtTeamName) {
                    start.linkTo(lblSeparator.end, margin = 30.dp)
                    bottom.linkTo(txtVisitorCourtTeamScore.top)
                })


            Text(text = game.visitorScore.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.constrainAs(txtVisitorCourtTeamScore) {
                    start.linkTo(txtVisitorCourtTeamName.start)
                    end.linkTo(txtVisitorCourtTeamName.end)
                    top.linkTo(imgVisitorTeam.top)
                    bottom.linkTo(imgVisitorTeam.bottom)
                })

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameCardPreview() {
    NbastatsTheme {
        GameCard(Game.empty())
    }
}
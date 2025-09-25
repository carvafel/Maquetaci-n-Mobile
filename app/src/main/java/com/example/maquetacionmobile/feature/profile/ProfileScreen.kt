package com.example.maquetacionmobile.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.maquetacionmobile.R
import com.example.maquetacionmobile.ui.components.HomeBottomBar
import com.example.maquetacionmobile.ui.theme.LocalExtendedColors
import com.example.maquetacionmobile.ui.theme.LocalSpacing
import com.example.maquetacionmobile.ui.theme.responsivePadding

@Composable
fun ProfileScreen(
    onConfigClick: () -> Unit = {},
    onAlarmClick: () -> Unit = {},
    onHomeClick: () -> Unit = {},
    onProfileClick: () -> Unit = {}
) {
    val extended = LocalExtendedColors.current
    val spacing = LocalSpacing.current

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(extended.brandBg)
                .padding(horizontal = responsivePadding(spacing.xl))
                .padding(bottom = 80.dp)
        ) {
            Spacer(Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(72.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = "Perfil",
                    modifier = Modifier.size(56.dp)
                )
                Spacer(Modifier.width(12.dp))
                Column {
                    Text("Juan Gil", fontWeight = FontWeight.SemiBold)
                    Text("jgil@gmail.com")
                }
            }

            Spacer(Modifier.height(16.dp))
            Surface(
                shape = RoundedCornerShape(6.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFFB9A9AA))
            ) {
                Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text("Ajustes privacidad", modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
                    androidx.compose.material3.Divider(color = Color(0xFFEADADA))
                    Text("Cambiar contraseña", modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
                }
            }
        }

        HomeBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter),
            onConfig = onConfigClick,
            onAlarm = onAlarmClick,
            onHome = onHomeClick,
            onProfile = onProfileClick
        )
    }
}



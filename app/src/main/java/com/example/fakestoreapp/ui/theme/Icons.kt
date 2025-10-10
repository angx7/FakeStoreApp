package com.example.fakestoreapp.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Star: ImageVector
    get() {
        if (_Star != null) return _Star!!

        _Star = ImageVector.Builder(
            name = "Star",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveToRelative(354f, -287f)
                lineToRelative(126f, -76f)
                lineToRelative(126f, 77f)
                lineToRelative(-33f, -144f)
                lineToRelative(111f, -96f)
                lineToRelative(-146f, -13f)
                lineToRelative(-58f, -136f)
                lineToRelative(-58f, 135f)
                lineToRelative(-146f, 13f)
                lineToRelative(111f, 97f)
                close()
                moveTo(233f, 840f)
                lineToRelative(65f, -281f)
                lineTo(80f, 370f)
                lineToRelative(288f, -25f)
                lineToRelative(112f, -265f)
                lineToRelative(112f, 265f)
                lineToRelative(288f, 25f)
                lineToRelative(-218f, 189f)
                lineToRelative(65f, 281f)
                lineToRelative(-247f, -149f)
                close()
                moveToRelative(247f, -350f)
            }
        }.build()

        return _Star!!
    }

private var _Star: ImageVector? = null

val Star_half: ImageVector
    get() {
        if (_Star_half != null) return _Star_half!!

        _Star_half = ImageVector.Builder(
            name = "Star_half",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveToRelative(606f, -286f)
                lineToRelative(-33f, -144f)
                lineToRelative(111f, -96f)
                lineToRelative(-146f, -13f)
                lineToRelative(-58f, -136f)
                verticalLineToRelative(312f)
                close()
                moveTo(233f, 840f)
                lineToRelative(65f, -281f)
                lineTo(80f, 370f)
                lineToRelative(288f, -25f)
                lineToRelative(112f, -265f)
                lineToRelative(112f, 265f)
                lineToRelative(288f, 25f)
                lineToRelative(-218f, 189f)
                lineToRelative(65f, 281f)
                lineToRelative(-247f, -149f)
                close()
            }
        }.build()

        return _Star_half!!
    }

private var _Star_half: ImageVector? = null

val Category: ImageVector
    get() {
        if (_Category != null) return _Category!!

        _Category = ImageVector.Builder(
            name = "Category",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveToRelative(260f, -520f)
                lineToRelative(220f, -360f)
                lineToRelative(220f, 360f)
                close()
                moveTo(700f, 880f)
                quadToRelative(-75f, 0f, -127.5f, -52.5f)
                reflectiveQuadTo(520f, 700f)
                reflectiveQuadToRelative(52.5f, -127.5f)
                reflectiveQuadTo(700f, 520f)
                reflectiveQuadToRelative(127.5f, 52.5f)
                reflectiveQuadTo(880f, 700f)
                reflectiveQuadToRelative(-52.5f, 127.5f)
                reflectiveQuadTo(700f, 880f)
                moveToRelative(-580f, -20f)
                verticalLineToRelative(-320f)
                horizontalLineToRelative(320f)
                verticalLineToRelative(320f)
                close()
                moveToRelative(580f, -60f)
                quadToRelative(42f, 0f, 71f, -29f)
                reflectiveQuadToRelative(29f, -71f)
                reflectiveQuadToRelative(-29f, -71f)
                reflectiveQuadToRelative(-71f, -29f)
                reflectiveQuadToRelative(-71f, 29f)
                reflectiveQuadToRelative(-29f, 71f)
                reflectiveQuadToRelative(29f, 71f)
                reflectiveQuadToRelative(71f, 29f)
                moveToRelative(-500f, -20f)
                horizontalLineToRelative(160f)
                verticalLineToRelative(-160f)
                horizontalLineTo(200f)
                close()
                moveToRelative(202f, -420f)
                horizontalLineToRelative(156f)
                lineToRelative(-78f, -126f)
                close()
                moveToRelative(298f, 340f)
            }
        }.build()

        return _Category!!
    }

private var _Category: ImageVector? = null

val Diamond: ImageVector
    get() {
        if (_Diamond != null) return _Diamond!!

        _Diamond = ImageVector.Builder(
            name = "Diamond",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(480f, 840f)
                lineTo(80f, 360f)
                lineToRelative(120f, -240f)
                horizontalLineToRelative(560f)
                lineToRelative(120f, 240f)
                close()
                moveToRelative(-95f, -520f)
                horizontalLineToRelative(190f)
                lineToRelative(-60f, -120f)
                horizontalLineToRelative(-70f)
                close()
                moveToRelative(55f, 347f)
                verticalLineToRelative(-267f)
                horizontalLineTo(218f)
                close()
                moveToRelative(80f, 0f)
                lineToRelative(222f, -267f)
                horizontalLineTo(520f)
                close()
                moveToRelative(144f, -347f)
                horizontalLineToRelative(106f)
                lineToRelative(-60f, -120f)
                horizontalLineTo(604f)
                close()
                moveToRelative(-474f, 0f)
                horizontalLineToRelative(106f)
                lineToRelative(60f, -120f)
                horizontalLineTo(250f)
                close()
            }
        }.build()

        return _Diamond!!
    }

private var _Diamond: ImageVector? = null

val Male: ImageVector
    get() {
        if (_Male != null) return _Male!!

        _Male = ImageVector.Builder(
            name = "Male",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(800f, 160f)
                verticalLineToRelative(240f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-103f)
                lineTo(561f, 455f)
                quadToRelative(19f, 28f, 29f, 59.5f)
                reflectiveQuadToRelative(10f, 65.5f)
                quadToRelative(0f, 92f, -64f, 156f)
                reflectiveQuadToRelative(-156f, 64f)
                reflectiveQuadToRelative(-156f, -64f)
                reflectiveQuadToRelative(-64f, -156f)
                reflectiveQuadToRelative(64f, -156f)
                reflectiveQuadToRelative(156f, -64f)
                quadToRelative(33f, 0f, 65f, 9.5f)
                reflectiveQuadToRelative(59f, 29.5f)
                lineToRelative(159f, -159f)
                horizontalLineTo(560f)
                verticalLineToRelative(-80f)
                close()
                moveTo(380f, 440f)
                quadToRelative(-58f, 0f, -99f, 41f)
                reflectiveQuadToRelative(-41f, 99f)
                reflectiveQuadToRelative(41f, 99f)
                reflectiveQuadToRelative(99f, 41f)
                reflectiveQuadToRelative(99f, -41f)
                reflectiveQuadToRelative(41f, -99f)
                reflectiveQuadToRelative(-41f, -99f)
                reflectiveQuadToRelative(-99f, -41f)
            }
        }.build()

        return _Male!!
    }

private var _Male: ImageVector? = null

val Female: ImageVector
    get() {
        if (_Female != null) return _Female!!

        _Female = ImageVector.Builder(
            name = "Female",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(440f, 840f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-84f)
                quadToRelative(-79f, -14f, -129.5f, -75.5f)
                reflectiveQuadTo(260f, 378f)
                quadToRelative(0f, -91f, 64.5f, -154.5f)
                reflectiveQuadTo(480f, 160f)
                reflectiveQuadToRelative(155.5f, 63.5f)
                reflectiveQuadTo(700f, 378f)
                quadToRelative(0f, 81f, -50.5f, 142.5f)
                reflectiveQuadTo(520f, 596f)
                verticalLineToRelative(84f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(40f, -320f)
                quadToRelative(58f, 0f, 99f, -41f)
                reflectiveQuadToRelative(41f, -99f)
                reflectiveQuadToRelative(-41f, -99f)
                reflectiveQuadToRelative(-99f, -41f)
                reflectiveQuadToRelative(-99f, 41f)
                reflectiveQuadToRelative(-41f, 99f)
                reflectiveQuadToRelative(41f, 99f)
                reflectiveQuadToRelative(99f, 41f)
            }
        }.build()

        return _Female!!
    }

private var _Female: ImageVector? = null

val Memory: ImageVector
    get() {
        if (_Memory != null) return _Memory!!

        _Memory = ImageVector.Builder(
            name = "Memory",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 960f,
            viewportHeight = 960f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000))
            ) {
                moveTo(360f, 600f)
                verticalLineToRelative(-240f)
                horizontalLineToRelative(240f)
                verticalLineToRelative(240f)
                close()
                moveToRelative(80f, -80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                close()
                moveToRelative(-80f, 320f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                quadToRelative(-33f, 0f, -56.5f, -23.5f)
                reflectiveQuadTo(200f, 680f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                quadToRelative(0f, -33f, 23.5f, -56.5f)
                reflectiveQuadTo(280f, 200f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(80f)
                quadToRelative(33f, 0f, 56.5f, 23.5f)
                reflectiveQuadTo(760f, 280f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                quadToRelative(0f, 33f, -23.5f, 56.5f)
                reflectiveQuadTo(680f, 760f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(-80f)
                horizontalLineToRelative(-80f)
                verticalLineToRelative(80f)
                close()
                moveToRelative(320f, -160f)
                verticalLineToRelative(-400f)
                horizontalLineTo(280f)
                verticalLineToRelative(400f)
                close()
                moveTo(480f, 480f)
            }
        }.build()

        return _Memory!!
    }

private var _Memory: ImageVector? = null


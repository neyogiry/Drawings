@Composable
fun Flower() {
    val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ), label = "rotation"
    )

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        drawLine(
            color = Color.Green,
            strokeWidth = 24f,
            start = Offset(x = size.width / 2, y = size.height * 0.65f),
            end = Offset(x = size.width / 2, y = size.height * 0.9f)
        )

        drawLeaf(
            center = Offset(x = size.width / 2, y = size.height * 0.75f),
            scale = 6f
        )

        rotate(
            degrees = rotation,
            pivot = Offset(x = size.width / 2, y = size.height * 0.65f)
        ) {
            val petalCount = 10
            for (i in 0 until petalCount) {
                val angle = 360f / petalCount * i
                rotate(
                    degrees = angle,
                    pivot = Offset(x = size.width / 2, y = size.height * 0.65f)
                ) {
                    drawRoundRect(
                        color = Color.Yellow,
                        topLeft = Offset(x = size.width / 2 - 15, y = size.height * 0.65f),
                        size = Size(40f, 120f),
                        cornerRadius = CornerRadius(15f, 15f)
                    )
                }
            }

            drawCircle(
                color = PollenColor,
                radius = 40f,
                center = Offset(x = size.width / 2, y = size.height * 0.65f)
            )
        }

    }
}

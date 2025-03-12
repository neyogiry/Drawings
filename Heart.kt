@Composable
fun HeartAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "infiniteTransition")

    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "scaleAnimation"
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(modifier = Modifier.padding(100.dp).size(200.dp)) {
            HeartShape(scale)
        }
    }
}

@Composable
fun HeartShape(scale: Float) {
    Canvas(modifier = Modifier.size(200.dp).scale(scale)) {
        val path = Path().apply {
            moveTo(size.width / 2, size.height / 3)
            cubicTo(
                size.width * 3 / 4, -size.height / 6,
                size.width * 5 / 4, size.height / 2,
                size.width / 2, size.height
            )
            cubicTo(
                -size.width / 4, size.height / 2,
                size.width / 4, -size.height / 6,
                size.width / 2, size.height / 3
            ) 
        }

        drawPath(path = path, color = Color.Red, style = Fill)
        drawPath(path = path, color = Color.Black, style = Stroke(width = 4f))
    }
}

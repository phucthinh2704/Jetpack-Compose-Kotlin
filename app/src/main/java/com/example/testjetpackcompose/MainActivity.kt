package com.example.testjetpackcompose

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.VisibilityThreshold
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.testjetpackcompose.ui.theme.TestJetpackComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestJetpackComposeTheme {
//                HomeScreen()
//                MainNavigation()
                LemonadeApp()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen( navController: NavHostController, modifier: Modifier = Modifier) {
//    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//        GetLayout(
//            "Thịnh", modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxWidth()      // Thêm khoảng cách padding
//                .border(2.dp, Color.Red) // Viền đỏ
//                .clickable { }
//        )
//    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                )
        }, modifier = Modifier.systemBarsPadding()
    ) { innerPadding ->
        Column {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(innerPadding)
            ) {
                Text("Hello, world!")
                Button(onClick = {
                    navController.navigate("detail")
                }) {
                    Text("Go to detail screens")
                }
            }

            GetLayout(
                "Thịnh", modifier = Modifier
//                    .padding(innerPadding)
                    .fillMaxWidth()      // Thêm khoảng cách padding
                    .border(2.dp, Color.Red) // Viền đỏ
                    .clickable { }
//                    .padding(bottom = 50.dp)
            )
        }
    }
}

@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.Green
        )
    ) {
        Text("Click tui ne")
    }

    TextButton(onClick = {})
    {
        Text("Text Button")
    }

    IconButton(onClick = {}) {
        Icon(imageVector = Icons.Default.AccountBox, contentDescription = "")
    }
}

@Composable
fun DisableSimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.Red
        ),
        enabled = false
    )
    {
        Text("Disable Button")
//        Text("Right Now", style = TextStyle(Color.Blue, 30.sp, fontStyle = FontStyle.Italic))
    }

    Button(
        onClick = {},
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Green,
            containerColor = Color.LightGray
        )
    ) {
        Column {
            Icon(Icons.Default.ShoppingCart, contentDescription = "")
            Text("Add to cart")
        }
    }
}

@Composable
fun RoundedCornerButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
//        shape = RoundedCornerShape(3.dp)
        shape = RoundedCornerShape(topStart = 15.dp, bottomStart = 15.dp, topEnd = 10.dp)
    )
    {
        Text("Rounded Corner Button")
    }
}

@Composable
fun BorderSimpleButton(modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        border = BorderStroke(width = 2.dp, color = Color.Red),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    )
    {
        Text("Check out", color = Color.Red)
    }
}

@Composable
fun DemoDetectTapGestures(modifier: Modifier = Modifier) {
    val textContent = remember {
        mutableStateOf("")
    }
    Text(text = textContent.value)
    Text(text = "something", modifier = Modifier.pointerInput(Unit) {
        detectTapGestures(
            onDoubleTap = {
                textContent.value = "double tap"
            },
            onPress = {
                textContent.value = "press"
            },
            onLongPress = {
                textContent.value = "long press"
            }
        )
    })
}

@Composable
fun DemoRadioButton(modifier: Modifier = Modifier) {
    Row {
        RadioButton(
            selected = false, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledUnselectedColor = Color.Gray
            ), enabled = false
        )
        RadioButton(
            selected = true, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
            )
        )
        RadioButton(
            selected = false, onClick = {}, colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Green,
                disabledUnselectedColor = Color.Gray
            )
        )
    }
}

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {

//    LazyVerticalGrid(
//        columns = GridCells.Fixed(3),
//        horizontalArrangement = Arrangement.spacedBy(12.dp),
//        verticalArrangement = Arrangement.spacedBy(24.dp),
//        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 24.dp)
//    ) {
//
//        items(19) { index ->
//            Item(index = index)
//        }
//
//    }

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 54.dp),
        modifier = Modifier.background(color = Color.Red)
    ) {

        items(19) { index ->
            Item(index = index)
        }

    }
}


@Composable
fun Item(modifier: Modifier = Modifier, index: Int) {
    Box(
        modifier = Modifier
            .background(
                color = Color.Magenta,
                shape = RoundedCornerShape(12.dp)
            )
            .size(100.dp)
            .clip(RoundedCornerShape(12.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "$index", style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 48.sp
            )
        )
    }
}


@Composable
//@Preview(name = "Category Screen Preview", showBackground = true, showSystemUi = true)
fun CategoryScreenPreview() {
    CategoryScreen()
}

@Composable
fun GetRowItem(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.width(300.dp)
//            .fillMaxWidth()
            .height(90.dp)
            .background(color = Color.Green, shape = RoundedCornerShape(12.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = null,
            modifier = Modifier.size(70.dp)
        )
        Text(
            "Momo",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            ),
        )
        RadioButton(selected = false, onClick = {})
    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ThanhToan(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(top = 45.dp, start = 20.dp, end = 20.dp).background(Color.Red).fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
//        verticalArrangement = Arrangement.SpaceBetween
//        verticalArrangement = Arrangement.SpaceAround
//        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            "Thanh Toán",
            modifier = Modifier.fillMaxWidth().background(Color.Green),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        GetRowItem()
        GetRowItem()
        GetRowItem()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GetLayout(title: String, modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
    ) {
        GetTextTitle(count.toString(), modifier)
        Button(
            onClick = {
                count++
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
        )
        {
            Text("Click me")
        }
//        SimpleButton(modifier)
//        DisableSimpleButton()
        RoundedCornerButton()
//        BorderSimpleButton()
        Spacer(modifier = Modifier.height(24.dp))
        DemoDetectTapGestures()
        DemoRadioButton()
        CheckboxList()
//        BannerCompose()
        CardExample()
        SurfaceExample()
        BoxExample()
        RoundedAvatar()
        ImageFromUrl()
        DemoTextField()
//        SnackbarExample()
        ListStateExample()
//        ConstraintAsExample()
//        ChainExample()
        BasicTopAppBarExample()
//        CategoryScreen()
        AnimateContentSizeExample()
        DynamicSizeExample()
        var email by remember { mutableStateOf("") }
        Email(email = email, onEmailChange = {email = it })

    }
}

@Composable
fun Email(email : String, onEmailChange : (String) -> Unit , modifier: Modifier = Modifier) {
    OutlinedTextField(value = email, onValueChange = onEmailChange)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main"
    ) {
        composable("main"){
            HomeScreen(navController)
        }
        composable("detail") {
            Hello(navController)
        }
    }
}

@Composable
fun DynamicSizeExample() {
    var showDetails by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize(), // Thêm hiệu ứng khi nội dung thay đổi
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText("Tap to ${if (showDetails) "Collapse" else "Expand"}")

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray)
                .clickable { showDetails = !showDetails }
        )

        if (showDetails) {
            Spacer(modifier = Modifier.height(16.dp))
            BasicText("Here are some details!")
        }
    }
}

@Composable
fun AnimateContentSizeExample() {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.Blue)
            .clickable { expanded = !expanded }
            .animateContentSize(
                animationSpec = spring(
                    stiffness = Spring.StiffnessHigh,
                    visibilityThreshold = IntSize.VisibilityThreshold
                )
            ) // Tự động tạo hoạt ảnh khi kích thước thay đổi
            .size(if (expanded) 200.dp else 100.dp)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        // Nội dung của Box
        Text(text = "$expanded", color = Color.White)

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicTopAppBarExample() {
    TopAppBar(
        title = {
            Text(text = "My App ")
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle back action */ }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        actions = {
            IconButton(onClick = { /* Handle search action */ }) {
                Icon(Icons.Default.Search, contentDescription = "Search", tint = Color.White)
            }
            IconButton(onClick = { /* Handle settings action */ }) {
                Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Blue,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
    )
    TopAppBar(
        title = {
            Text(
                text = "30 Days Of Cooking",
                color = Color.White,
            )
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Black
        )
    )
}

@Composable
fun ChainExample() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        // Tạo các tham chiếu cho các phần tử
        val (box1, box2, box3) = createRefs()

        // Tạo chain ngang
        createHorizontalChain(
            box1, box2, box3,
            chainStyle = ChainStyle.Packed // Kiểu chain
        )
        // Box1
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Red)
                .constrainAs(box1) { }
        )

        // Box2
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Green)
                .constrainAs(box2) {}
        )

        // Box3
        Box(
            modifier = Modifier
                .size(50.dp)
                .background(Color.Blue)
                .constrainAs(box3) {}
        )
    }
}


@Composable
fun ConstraintAsExample() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        // Tạo các tham chiếu constraint
        val (box1, box2, text) = createRefs()

        // Box1 - Gắn với topStart
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        // Box2 - Gắn với bottomEnd
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(box2) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )

        // Text - Gắn với giữa hai Box
        Text(
            text = "Hello, Constraint!",
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(box1.bottom)
                    bottom.linkTo(box2.top)
                    start.linkTo(box1.end)
                    end.linkTo(box2.start)
                }
        )
    }
}

@Composable
fun Ingredient(modifier: Modifier = Modifier) {
    ConstraintLayout(modifier = Modifier) { }
}

@Composable
fun ListStateExample() {
    val items = remember { mutableStateOf(listOf("Apple", "Banana", "Cherry")) }
    var value by remember { mutableStateOf("") }
    TextField(
        value = value,
        onValueChange = {value = it},
        label = { Text("Nhập ở đây") },
        modifier = Modifier.padding(16.dp)
    )
    Column {
        items.value.forEach { item ->
            Text(item)
        }
        Button(onClick = {
            items.value += value // Tạo một bản sao mới của List
            value = "" // Xóa giá trị TextField
        }) {
            Text("Add Item")
        }
    }
}


@Composable
fun SnackbarExample() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Column {
        Button(onClick = {
            scope.launch {
                snackbarHostState.showSnackbar("This is a Snackbar message!")
            }
        }) {
            Text("Show Snackbar")
        }

        SnackbarHost(hostState = snackbarHostState)
    }
}

@Composable
fun DemoTextField(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    val keyBoardController = LocalSoftwareKeyboardController.current // điểu khiển (ẩn bàn phím)

    TextField(
        value = input,
        onValueChange = {
            input = it
        },
        label = { Text("Firstname", style = TextStyle(color = Color.Red)) },
        placeholder = { Text("Enter your first name") },
        leadingIcon = { Icon(Icons.Default.Person, contentDescription = "") },
        trailingIcon = {
            IconButton(onClick = { input = "" })
            {
                Icon(Icons.Default.Clear, contentDescription = "", tint = Color.Green)
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Red, // textStyle mạnh hơn
            cursorColor = Color.Black,
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                keyBoardController?.hide()
            }
        )
    )
    var textState = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        placeholder = { Text("Nhập văn bản...") },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Search, // Thay đổi biểu tượng theo nhu cầu
                contentDescription = null,
//                tint = Color.Red // Thiết lập màu cho biểu tượng
            )
        },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedTrailingIconColor = Color.Green // Màu nền của TextField
        ),
//        shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(22.dp),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Send
        ),
        keyboardActions = KeyboardActions(
            onSend = {
                keyBoardController?.hide()
            }
        )
    )

    var email by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    val context = LocalContext.current
    OutlinedTextField(
        value = email,
        onValueChange = { newValue -> email = newValue },
        placeholder = { Text("username/email") },
        label = { Text("username/email") },
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = Color.Green,
            unfocusedTextColor = Color.Red,
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Red,
            focusedLeadingIconColor = Color.Green,
            unfocusedLeadingIconColor = Color.Red,
            focusedLabelColor = Color.Green,
            unfocusedLabelColor = Color.Red,
            cursorColor = Color.Red,
            focusedPlaceholderColor = Color.Blue,
        ),
        leadingIcon = { Icon(Icons.Default.Email, contentDescription = "") },
        trailingIcon = {
            IconButton(onClick = {
                isShowPassword = !isShowPassword
                if (isShowPassword)
                    Toast.makeText(context, "Ẩn password rồi nè", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(context, "Đang show password nè", Toast.LENGTH_SHORT).show()
            }) {
                if (isShowPassword) {
                    Icon(Icons.Default.Face, contentDescription = "", tint = Color.Green)

                } else {
                    Icon(Icons.Default.Favorite, contentDescription = "", tint = Color.Red)

                }
            }
        },
        visualTransformation = if (isShowPassword) VisualTransformation.None
        else PasswordVisualTransformation() //thiết lập cho ô mật khẩu
    )
}

@Composable
fun ImageFromUrl() {
    val imageUrl =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTP5z38q20BDyDMhBrhFMHJgO0cit6O4ww4aA&s"
    Image(
        painter = rememberAsyncImagePainter(imageUrl),
        contentDescription = "Mô tả ảnh",
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
fun RoundedAvatar() {
    Image(
        painter = painterResource(id = R.drawable.banner), // Thay bằng hình ảnh của bạn
        contentDescription = "Avatar",
        contentScale = ContentScale.Crop, // Cắt và căn chỉnh hình ảnh để vừa khung
        modifier = Modifier
            .size(130.dp) // Kích thước hình ảnh
            .clip(CircleShape) // Cắt hình ảnh thành hình tròn
            .border(2.dp, Color.Gray, CircleShape) // Thêm viền cho hình tròn (nếu cần)
    )
}


@Composable
fun BoxExample() {
    Box(
        modifier = Modifier
            .size(200.dp)
            .background(Color.Gray), // Màu nền cho Box
        contentAlignment = Alignment.Center // nếu con không có align thì sẽ canh theo contentAlignment của cha
    ) {
        Box(
            modifier = Modifier
                .size(150.dp)
                .background(Color.Blue)
                .align(Alignment.TopStart) // Căn góc trên trái
        )

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .align(Alignment.Center) // Căn giữa
        ) {
            Text(
                text = "Bottom Center",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }

        Text(
            text = "Overlay Text",
            color = Color.White,
            modifier = Modifier.align(Alignment.BottomEnd) // Căn góc dưới phải
        )
    }
}


@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(100.dp),
        color = Color(0xFFBBDEFB), // Màu nền xanh nhạt
        shape = RoundedCornerShape(16.dp), // Bo tròn góc
        shadowElevation = 8.dp // Độ nổi
    ) {
        Box(
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.background(Color.Red)
        ) {
            Text(
                text = "This is a Surface",
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}


@Composable
fun CardExample() {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp), // Bo tròn góc
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp) // Tạo bóng đổ
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "This is a Card", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Card is great for displaying content with elevation and rounded corners.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun CircularImage(imagePainter: Painter, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp) // Đặt kích thước cho avatar
            .clip(CircleShape) // Bo tròn hình ảnh
            .background(Color.Gray) // Màu nền
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            contentScale = ContentScale.Crop, // Cắt hình ảnh để phù hợp với kích thước hình tròn
            modifier = Modifier.fillMaxSize() // Đảm bảo hình ảnh nằm đầy trong Box
        )
    }
}

@Composable
fun BannerCompose(modifier: Modifier = Modifier) {
//    Image(painter = painterResource(id = R.drawable.banner),
//        contentDescription = "Banner Fashion",
//        contentScale = ContentScale.Fit,
//        modifier = Modifier.fillMaxWidth(),
////        alignment = Alignment.TopStart
//    )
    CircularImage(painterResource(id = R.drawable.banner))
}

@Composable
fun CheckboxList() {
    // Danh sách trạng thái checkbox
    val checkboxStates = remember { mutableStateListOf(false, false, false) } // 3 checkbox ví dụ

    // Danh sách tên checkbox
    val checkboxLabels = listOf("Checkbox 1", "Checkbox 2", "Checkbox 3")

    Column {
        // Lặp qua danh sách checkbox
        for (i in checkboxLabels.indices) {
            Row(
                modifier = Modifier.selectable(
                    selected = checkboxStates[i],
                    onClick = { checkboxStates[i] = !checkboxStates[i] },
                    role = Role.Checkbox
                ),
                verticalAlignment = Alignment.CenterVertically // Căn giữa theo chiều dọc
            ) {
                Checkbox(
                    checked = checkboxStates[i],
                    onCheckedChange = { checkboxStates[i] = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Red,
                        uncheckedColor = Color.Green
                    )
                )
                Spacer(modifier = Modifier.width(8.dp)) // Khoảng cách giữa checkbox và text
                Text(text = checkboxLabels[i])
            }
        }
    }
}

@Composable
fun GetTextTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        "xin chào $title",
        modifier = modifier,
        fontSize = 30.sp,
        color = Color.Green,
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp() {

    var currentStep by remember { mutableStateOf(1) }

    var squeezeCount by remember { mutableStateOf(0) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(MaterialTheme.colorScheme.tertiaryContainer),
            color = MaterialTheme.colorScheme.background
        ) {
            when (currentStep) {
                1 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_select,
                        drawableResourceId = R.drawable.lemon_tree,
                        contentDescriptionResourceId = R.string.lemon_tree_content_description,
                        onImageClick = {
                            currentStep = 2
                            squeezeCount = (2..4).random()
                        }
                    )
                }
                2 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_squeeze,
                        drawableResourceId = R.drawable.lemon_squeeze,
                        contentDescriptionResourceId = R.string.lemon_content_description,
                        onImageClick = {
                            squeezeCount--
                            if (squeezeCount == 0) {
                                currentStep = 3
                            }
                        }
                    )
                }

                3 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_drink,
                        drawableResourceId = R.drawable.lemon_drink,
                        contentDescriptionResourceId = R.string.lemonade_content_description,
                        onImageClick = {
                            currentStep = 4
                        }
                    )
                }
                4 -> {
                    LemonTextAndImage(
                        textLabelResourceId = R.string.lemon_empty_glass,
                        drawableResourceId = R.drawable.lemon_restart,
                        contentDescriptionResourceId = R.string.empty_glass_content_description,
                        onImageClick = {
                            currentStep = 1
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner_radius)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(dimensionResource(R.dimen.button_image_width))
                        .height(dimensionResource(R.dimen.button_image_height))
                        .padding(dimensionResource(R.dimen.button_interior_padding))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_vertical)))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestJetpackComposeTheme {

    }
}
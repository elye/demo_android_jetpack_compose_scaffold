package com.example.scaffold

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val scaffoldState = rememberScaffoldState(
                rememberDrawerState(DrawerValue.Closed)
            )

            Scaffold(
                scaffoldState = scaffoldState,
                topBar = { MyTopAppBar(scaffoldState) },
                bottomBar = { MyBottomAppBar() },
                snackbarHost = { state -> MySnackHost(state) },
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.Center,
                floatingActionButton = { MyFloatingButton(scaffoldState) },
                drawerContent = { MyDrawerConten(drawers) },
                bodyContent = { MyBodyContent(body) }
            )
        }
    }

    val drawers = listOf(
        "Drawer 1", "Drawer 2", "Drawer 3",
        "Drawer 11", "Drawer 12", "Drawer 13",
        "Drawer 21", "Drawer 22", "Drawer 23",
        "Drawer 31", "Drawer 32", "Drawer 33",
        "Drawer 41", "Drawer 42", "Drawer 43",
        "Drawer 51", "Drawer 52", "Drawer 53"
    )

    val body =
        """
Korean: 국민경제의 발전을 위한 중요정책의 수립에 관하여 대통령의 자문에 응하기 위하여 국민경제자문회의를 둘 수 있다. 
Greek: Λορεμ ιπσθμ δολορ σιτ αμετ, μει ιδ νοvθμ φαβελλασ πετεντιθμ vελ νε, ατ νισλ σονετ οπορτερε εθμ. Αλιι δοcτθσ μει ιδ, νο αθτεμ αθδιρε ιντερεσσετ μελ, δοcενδι cομμθνε οπορτεατ τε cθμ. 
Japanese Lorem Ipsum: 旅ロ京青利セムレ弱改フヨス波府かばぼ意送でぼ調掲察たス日西重ケアナ住橋ユムミク順待ふかんぼ人奨貯鏡すびそ。
Russian Lorem Ipsum: Лорем ипсум долор сит амет, пер цлита поссит ех, ат мунере фабулас петентиум сит. Иус цу цибо саперет сцрипсерит, нец виси муциус лабитур ид. Ет хис нонумес нолуиссе дигниссим. 
Chinese Lorem Ipsum: 側経意責家方家閉討店暖育田庁載社転線宇。得君新術治温抗添代話考振投員殴大闘北裁。品間識部案代学凰処済準世一戸刻法分。悼測済諏計飯利安凶断理資沢同岩面文認革。内警格化再薬方久化体教御決数詭芸得筆代。 
Indian Lorem Ipsum: पढाए हिंदी रहारुप अनुवाद कार्यलय मुख्य संस्था सोफ़तवेर निरपेक्ष उनका आपके बाटते आशाआपस मुख्यतह उशकी करता। शुरुआत संस्था कुशलता मेंभटृ अनुवाद गएआप विशेष सकते परिभाषित लाभान्वित प्रति देकर समजते दिशामे प्राप्त जैसे वर्णन संस्थान निर्माता प्रव्रुति भाति चुनने उपलब्ध बेंगलूर अर्थपुर्ण 
Armeninian Lorem Ipsum: լոռեմ իպսում դոլոռ սիթ ամեթ, լաբոռե մոդեռաթիուս եթ հաս, պեռ ոմնիս լաթինե դիսպութաթիոնի աթ, վիս ֆեուգաիթ ծիվիբուս եխ. վիվենդում լաբոռամուս ելաբոռառեթ նամ ին. 
Arab Lorem Ipsum: غينيا واستمر العصبة ضرب قد. وباءت الأمريكي الأوربيين هو به،, هو العالم، الثقيلة بال. مع وايرلندا الأوروبيّون كان, قد بحق أسابيع العظمى واعتلاء. انه كل وإقامة المواد. 
Hebrew Lorem Ipsum: כדי יסוד מונחים מועמדים של, דת דפים מאמרשיחהצפה זאת. אתה דת שונה כלשהו, גם אחר ליום בשפות, או ניווט פולנית לחיבור ארץ. ויש בקלות ואמנות אירועים או, אל אינו כלכלה שתי.            
        """.trimIndent()
}


@Composable
fun MyTopAppBar(scaffoldState: ScaffoldState) {
    TopAppBar(title = { Text("Top AppBar") },
        backgroundColor = Color(0xFF008800),
        navigationIcon = {
            Icon(
                Icons.Default.Menu,
                null,
                modifier = Modifier.clickable(onClick = {
                    scaffoldState.drawerState.open()
                })
            )
        })
}

@Composable
fun MyBottomAppBar() {
    BottomAppBar(backgroundColor = Color(0xFF008800)) {
        Text("BottomAppBar")
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MySnackHost(state: SnackbarHostState) {
    SnackbarHost(
        state,
        snackbar = { data ->
            Snackbar(
                data,
                backgroundColor = Color(0x99000000),
                elevation = 1.dp
            )
        })
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyFloatingButton(scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    FloatingActionButton(onClick = {
        scope.launch {
            when (scaffoldState.snackbarHostState.showSnackbar(
                message = "Snackbar",
                actionLabel = "Ok"
            )) {
                SnackbarResult.Dismissed -> Log.d("Track", "Dismissed")
                SnackbarResult.ActionPerformed -> Log.d("Track", "Action!")
            }
        }

    }) {
        Text("X")
    }
}

@Composable
fun MyDrawerConten(drawers: List<String>) {
    LazyColumnFor(
        items = drawers,
        contentPadding = PaddingValues(16.dp, 16.dp, 16.dp)
    ) { itemText ->
        Text(
            text = itemText,
            style = TextStyle(fontSize = 24.sp, color = Color(0xFF5555FF)),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.fillMaxWidth().height(16.dp))
    }
}

@Composable
fun MyBodyContent(body: String) {
    ScrollableColumn(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 58.dp)) {
        Text(text = body, fontSize = 32.sp) }
}
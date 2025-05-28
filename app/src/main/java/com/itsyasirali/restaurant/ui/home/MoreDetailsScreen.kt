import androidx.compose.runtime.Composable
import com.itsyasirali.restaurant.model.More
import com.itsyasirali.restaurant.ui.ui.theme.*

@Composable
fun MoreDetailsScreen(content: More){
    BahgatResturantTheme {
        val argument: More = content
        argument.setContent()
    }
}


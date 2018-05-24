package controllers


import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc._



@Inject
class HolaMundoController @Inject()(config: Configuration, cc: ControllerComponents, authenticatedUserAction: AuthenticatedUserAction) extends AbstractController(cc)  {


        def index() = Action {
          Ok("Hello World")

        }
        def hello(name: String) = Action {
               Ok(views.html.hello(name))
        }

        def hello1() = Action {
            Ok(views.html.hello1())
        }
}



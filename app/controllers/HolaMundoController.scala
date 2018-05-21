package controllers

import javax.inject.{Inject, Singleton}
import play.api.Configuration
import play.api.mvc._



@Singleton
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



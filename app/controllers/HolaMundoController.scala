package controllers

import javax.inject.{Inject, Singleton}
import play.api.Configuration
import play.api.mvc.{AbstractController, ControllerComponents}



@Singleton
class HolaMundoController @Inject()(config: Configuration, cc: ControllerComponents) extends AbstractController(cc)  {




        def hello(name: String) = Action {
               Ok(views.html.hello(name))
        }

        def hello1() = Action {
            Ok(views.html.hello1())
        }



}

package controllers

import javax.inject.Inject
import model.{User, UserForm}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.UserService

import scala.concurrent.{ExecutionContext, Future}

class UserController @Inject() (userService: UserService,cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def home = Action.async { implicit  request =>
    userService.listAllUsers map { users =>
      Ok(views.html.user(UserForm.form,users))
    }
  }





  }


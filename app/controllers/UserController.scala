package controllers

import javax.inject.{Inject, Singleton}
import model.{User, UserForm}
import play.api.mvc.{AbstractController, ControllerComponents}
import services.UserService

import scala.concurrent.{ExecutionContext, Future}


@Singleton
class UserController @Inject() (userService: UserService,cc: ControllerComponents)(implicit ec: ExecutionContext) extends AbstractController(cc) {

  def home = Action.async { implicit  request =>
    userService.listAllUsers map { users =>
      Ok(views.html.user(UserForm.form,users))
    }
  }
  def addUser() = Action.async{ implicit request =>
    UserForm.form.bindFromRequest.fold(
      errorForm => Future.successful(Ok(views.html.user(errorForm,Seq.empty[User]))),
      data => {
        val newUser = User(0,data.firstName,data.lastName,data.mobile,data.email)
          userService.addUser(newUser).map(res =>
          Redirect(routes.HolaMundoController.hello1()))

        }
    )

  }

  def deleteUser(id: Long) = Action.async { implicit request =>
    userService.deleteUser(id) map { res =>
      Redirect(routes.HolaMundoController.hello1())
    }

  }





  }


package services

import dao.UserDAO
import javax.inject.{Inject, Singleton}
import model.User

import scala.concurrent.Future


@Singleton
class UserServiceImpl @Inject() (userDAO: UserDAO) extends UserService {
  override def addUser(user: User): Future[String] = {
    userDAO.add(user)
  }

  override def getUser(id: Long): Future[Option[User]] = {
    userDAO.get(id)
  }

  override def deleteUser(id: Long): Future[Int] = {
    userDAO.delete(id)
  }

  override def listAllUsers: Future[Seq[User]] = {
    userDAO.listAll
  }
}

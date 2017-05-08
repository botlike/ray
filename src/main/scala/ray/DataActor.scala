package ray

import akka.actor.{Actor, UnhandledMessage}
import ray.DataActor.{Add, Delete, DeleteAll, Update}
import ray.objects.Cacheable
import scala.sys.Prop

/**
  * Created by cmontecinos on 08-05-17.
  */
class DataActor[A](typ : Cacheable[A]) extends Actor{

  var cache : Map[String, A] = Map.empty[String,A]

  override def receive: Receive = {
    case Add(cacheable) => cache =  cache + (cacheable.key -> cacheable.value[A]);
    case DeleteAll => cache.empty
    case Update(key, cacheable) => cache + (cacheable.key -> cacheable.value[A]);
    case Delete(key) => cache  = cache - key
    case _ => UnhandledMessage
  }
}

object DataActor {
  def props[A] (typ : A) = {
    Prop[DataActor[A]]
  }

  sealed trait Commands
  case class Add[A](cacheable: Cacheable[A]) extends Commands
  case class Delete(key : String) extends Commands
  case class Update[A](key: String, cacheable: Cacheable[A]) extends Commands
  case object DeleteAll extends Commands
}

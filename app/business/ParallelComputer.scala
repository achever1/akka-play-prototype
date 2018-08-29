package business

import akka.actor.ActorSystem
import javax.inject.Inject

import scala.concurrent.{ExecutionContext, Future}

class ParallelComputer @Inject()(system: ActorSystem)(
    implicit ec: ExecutionContext) {

  def compute() =
    Future
      .sequence {
        (1 to 5)
          .map { i =>
            {
              Future(i)
                .map(_ * 10)
                .map(_ + 1)
                .map { i => Thread.sleep(100); i }
            }
          }
      }
      .map(_.sum)
}

package ray.objects

import akka.cluster.sharding.ShardRegion

/**
  * Created by cmontecinos on 08-05-17.
  */

sealed trait Cacheable[A] {
  val key : String
  val value : A
}

case class TagItem[A](key : String,
                      value : A,
                      tag : String,
                      entityFunction:  ShardRegion.ExtractEntityId) extends Cacheable[A]

case class SimpleItem[A](key : String,
                         value : A,
                         entityFunction: ShardRegion.ExtractEntityId,
                         shardFunction : ShardRegion.ExtractShardId) extends Cacheable[A]
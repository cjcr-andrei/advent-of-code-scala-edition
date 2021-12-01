import scala.annotation.tailrec
import scala.io.Source

@tailrec
def count_depth_increases(depths: List[Int], last: Int = Int.MaxValue, count: Int = 0): Int =
  if depths.isEmpty then count
  else if depths.head > last then count_depth_increases(depths.tail, depths.head, count + 1)
  else count_depth_increases(depths.tail, depths.head, count)

val depths = Source.fromFile("C:/Users/burge/Desktop/Advent of Code/inputs/1.1.txt").getLines.toList
  .map(_.toInt)

count_depth_increases(depths)

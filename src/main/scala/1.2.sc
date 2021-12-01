import scala.annotation.tailrec
import scala.io.Source

@tailrec
def count_depth_increases(depth_windows: List[List[Int]], last_window_sum: Int = Int.MaxValue,
                          count: Int = 0): Int =
  if depth_windows.isEmpty then count
  else if depth_windows.head.size < 3 then return count
  else if depth_windows.head.sum > last_window_sum then count_depth_increases(depth_windows.tail,
    depth_windows.head.sum, count + 1)
  else count_depth_increases(depth_windows.tail, depth_windows.head.sum, count)

val depths = Source.fromFile("C:/Users/burge/Desktop/Advent of Code/inputs/1.1.txt").getLines.toList
  .map(_.toInt).sliding(3).toList

count_depth_increases(depths)
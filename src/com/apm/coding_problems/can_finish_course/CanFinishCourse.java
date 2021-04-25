package com.apm.coding_problems.can_finish_course;

import com.apm._lib.GraphNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CanFinishCourse {

//  static boolean takeCourse(int courseToTake, Set<Integer> coursesTaken,
//                            int numCourses, Map<Integer, Integer> deps) {
//    Integer prerequisite = deps.get(courseToTake);
//    if (prerequisite == null) {
//      return true;
//    }
//    else {
//      //if (takeCourse(prerequisite, ))
//      return false;
//    }
//  }
//
//  private static boolean canFinish(int numCourses, Map<Integer, Integer> deps) {
//    ArrayList<Set<Integer>> depsForCourse = new ArrayList<>();
//    IntStream.range(1,numCourses).forEach(x -> depsForCourse.add(new TreeSet<>()));
//
//    for (int i=0; i<=numCourses-1; i++) {
//      takeCourse(i+1, depsForCourse.get(i), numCourses, deps);
//      if (depsForCourse.get(i).size() == numCourses) {
//        return true;
//      }
//    }
//
//    //Set<Integer>
//
//    return false;
//  }

  static Set<Integer> getCourseWithNoDeps(int numCourses, Map<Integer, List<Integer>> deps) {
    Set<Integer> allCourses = IntStream.range(1,numCourses).boxed().collect(Collectors.toSet());

    Set<Integer> coursesWithDeps = new HashSet<>();
    deps.entrySet().stream().forEach(e -> coursesWithDeps.addAll(e.getValue()));

    allCourses.removeAll(coursesWithDeps);

    return allCourses;
  }

  static GraphNode<Integer> createDepGraph(int course, Map<Integer, List<Integer>> deps) {
    return null;
  }

  static List<GraphNode<Integer>> getDepGraphs(int numCourses, Map<Integer, List<Integer>> deps) {
    List<GraphNode<Integer>> depGraphs = new ArrayList<>();

    Set<Integer> coursesWithNoDeps = getCourseWithNoDeps(numCourses, deps);

    coursesWithNoDeps.stream().forEach(course -> {
      depGraphs.add(createDepGraph(course, deps));
    });

    return depGraphs;
  }

  static boolean canFinish(int numCourses, Map<Integer, List<Integer>> deps) {
    return false;
  }

  public static void main(String[] args) {
    int numCourses = 5;

    // Dependencies
    // 1 - 5
    // 2 - 1
    // 3 -
    // 4 - 2
    // 5 - 3
    // Answer -  3,5,1,2,4
    Map<Integer, List<Integer>> deps = new HashMap<>();
    deps.put(5, Arrays.asList(1));
    deps.put(1, Arrays.asList(2));
    deps.put(2, Arrays.asList(4));
    deps.put(3, Arrays.asList(5));

    System.out.println(canFinish(numCourses, deps));
  }

}


/*

https://leetcode.com/problems/course-schedule/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

 */

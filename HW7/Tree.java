/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package HW7;
import java.util.Iterator;

/**
 * An interface for a tree where nodes can have an arbitrary number of children.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Tree<E> extends Iterable<E> {

  /**
   * Returns the root of the tree (or null if tree is empty).
   * @return root of the tree (or null if tree is empty)
   */
  Node<E> root();

  /**
   * Returns the node n's parent (or null if n is root).
   *
   * @param n    A node within the tree
   * @return n's parent (or null if n is root)
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  Node<E> parent(Node<E> n) throws IllegalArgumentException;

  /**
   * Returns an iterable collection of the Positions representing p's children.
   *
   * @param n    A node within the tree
   * @return iterable collection of n's children
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  Iterable<Node<E>> children(Node<E> n)
                                   throws IllegalArgumentException;

  /**
   * Returns the number of children of node n.
   *
   * @param n    A node within the tree
   * @return number of children of Position n
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  int numChildren(Node<E> n) throws IllegalArgumentException;

  /**
   * Returns true if node n has one or more children.
   *
   * @param n    A valid Position within the tree
   * @return true if n has at least one child, false otherwise
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  boolean isInternal(Node<E> n) throws IllegalArgumentException;

  /**
   * Returns true if node n does not have any children.
   *
   * @param n    A node within the tree
   * @return true if n has zero children, false otherwise
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  boolean isExternal(Node<E> n) throws IllegalArgumentException;

  /**
   * Returns true if node n represents the root of the tree.
   *
   * @param n    A node within the tree
   * @return true if n is the root of the tree, false otherwise
   * @throws IllegalArgumentException if n is not a valid node for this tree.
   */
  boolean isRoot(Node<E> n) throws IllegalArgumentException;

  /**
   * Returns the number of nodes in the tree.
   * @return number of nodes in the tree
   */
  int size();

  /**
   * Tests whether the tree is empty.
   * @return true if the tree is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Returns an iterator of the elements stored in the tree.
   * @return iterator of the tree's elements
   */
  Iterator<E> iterator();

  /**
   * Returns an iterable collection of the positions of the tree.
   * @return iterable collection of the tree's positions
   */
  Iterable<Node<E>> positions();
}

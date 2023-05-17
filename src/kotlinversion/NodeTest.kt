@file:Suppress("FunctionName")

package kotlinversion

import ext.runWithConsoleOutput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class NodeTest {

    @Test
    fun `Verify append to end`() {
        val head = Node(1)
        val expectedData = 10

        head.appendToEnd(expectedData)

        assertEquals(expectedData, head.next?.data)
    }

    @Test
    fun `Verify print nodes`() {
        val head = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)
        val node3 = Node(4)

        head.next = node1
        node1.next = node2
        node2.next = node3

        val expectedResult = "1 --> 2 --> 3 --> 4"
        val result = runWithConsoleOutput { head.printNodes() }

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Verify length`() {
        val head = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)
        val node3 = Node(4)

        head.next = node1
        node1.next = node2
        node2.next = node3

        val expectedResult = 4
        val result = head.length(head)

        assertEquals(expectedResult, result)

    }

    @Test
    fun `Verify sum of nodes`() {
        val head = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)

        head.next = node1
        node1.next = node2

        val expectedResult = 6
        val result = head.sumOfNodes()

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Verify delete start node`() {
        var head: Node? = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)
        val node3 = Node(4)

        head?.next = node1
        node1.next = node2
        node2.next = node3

        val expectedResult = "2 --> 3 --> 4"
        val result = runWithConsoleOutput {
            head = head?.deleteNode(head!!, 1)
            head?.printNodes()
        }

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Verify delete middle node`() {
        var head: Node? = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)
        val node3 = Node(4)

        head?.next = node1
        node1.next = node2
        node2.next = node3

        val expectedResult = "1 --> 3 --> 4"
        val result = runWithConsoleOutput {
            head = head?.deleteNode(head!!, 2)
            head?.printNodes()
        }

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Verify delete end node`() {
        var head: Node? = Node(1)
        val node1 = Node(2)
        val node2 = Node(3)
        val node3 = Node(4)

        head?.next = node1
        node1.next = node2
        node2.next = node3

        val expectedResult = "1 --> 2 --> 3"
        val result = runWithConsoleOutput {
            head = head?.deleteNode(head!!, 4)
            head?.printNodes()
        }

        assertEquals(expectedResult, result)
    }

    @Test
    fun `Verify node has next`() {
        val head = Node(1)
        val node1 = Node(2)

        head.next = node1

        assertTrue(head.hasNext())
    }

}
package kotlinversion

class Node(var data: Int) {

    var next: Node? = null

    fun appendToEnd(data: Int) {
        val end = Node(data)
        var n: Node? = this
        while (n!!.next != null) {
            n = n.next
        }
        n.next = end
    }

    fun printNodes() {
        var current: Node? = this
        while (current != null) {
            val nextArrow = " --> ".takeIf { current!!.hasNext() }.orEmpty()
            print("${current.data}$nextArrow")
            current = current.next
        }
    }

    fun length(head: Node?): Int {
        var current: Node? = head
        var length = 0
        while (current != null) {
            length++
            current = current.next
        }
        return length
    }

    fun sumOfNodes(): Int {
        var current: Node? = this
        var sum = 0
        while (current != null) {
            sum += current.data
            current = current.next
        }
        return sum
    }

    fun deleteNode(head: Node, data: Int): Node? {
        var current: Node? = head
        var temp: Node?

        if (current?.data == data) {
            return head.next
        }

        while (current != null) {
            temp = current
            current = current.next

            if (current?.data == data) {
                temp.next = current.next
                return head
            }
        }

        return head
    }

    fun hasNext() = this.next != null
}
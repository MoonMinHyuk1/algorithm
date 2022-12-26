class Node:
    def __init__(self, item):
        self.item = item
        self.left = None
        self.right = None

class BinaryTree():
    def __init__(self):
        self.root = None
    
    def preOrder(self, n):
        if n != None:
            print(n.item, end = ' ')
            if n.left != None:
                self.preOrder(n.left)
            if n.right != None:
                self.preOrder(n.right)
    
    def inOrder(self, n):
        if n != None:
            if n.left != None:
                self.inOrder(n.left)
            print(n.item, end = ' ')
            if n.right != None:
                self.inOrder(n.right)
    
    def postOrder(self, n):
        if n != None:
            if n.left != None:
                self.postOrder(n.left)
            if n.right != None:
                self.postOrder(n.right)
            print(n.item, end = ' ')

tree = BinaryTree()
tree.root = Node(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)
tree.root.right.left = Node(6)
tree.root.right.right = Node(7)

tree.preOrder(tree.root)
print()
tree.inOrder(tree.root)
print()
tree.postOrder(tree.root)
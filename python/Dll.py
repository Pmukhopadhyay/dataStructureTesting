from abc import ABCMeta, abstractmethod

class Node:
	
	def __init__(self,before,after,data):
		self.before = before
		self.after = after
		self.data = data

	def getAfter(self):
		return self.after

	def setAfter(self,after):
		self.after = after

	def setBefore(self,before):
		self.before = before

	def getData(self):
		return self.data


class DoublyLinkedListDefinition:
	__metaclass__ = ABCMeta

	@abstractmethod
	def add(self, data):
		pass
	
	@abstractmethod
	def display(self):
		pass

class DoublyLinkedList(DoublyLinkedListDefinition):

	def __init__(self):
		self.head = Node(None,None,None)
		self.tail = Node(None,None,None)
		self.size = 0

	def add(self, data):
		newNode = Node(None, self.head, data)
		'''print "palash>>>>1>>>"+newNode.getData().__str__()'''
		if self.size == 0 :
			self.head = newNode
			'''print "palash>>>>1>>>"+self.head.getData().__str__()'''
		else:
			newNode.setBefore(self.head)
			self.head.setAfter(newNode)
		self.size = self.size + 1

	def display(self):
		i=0
		temp = self.head
		while i < self.size :
			print 'Dll['+i.__str__()+'] # '+temp.getData().__str__()
			temp = temp.getAfter()
			i = i+1

dll = DoublyLinkedList()
dll.add(5)
dll.add(2)
dll.display()

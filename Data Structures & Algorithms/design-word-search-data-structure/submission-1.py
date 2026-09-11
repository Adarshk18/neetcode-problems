class TrieNode:
    def __init__(self):
        self.children = {}
        self.endOfWord = False

class WordDictionary:

    def __init__(self):
        self.root = TrieNode()
        

    def addWord(self, word: str) -> None:
        curr = self.root
        for i in word:
            if i not in curr.children:
                curr.children[i] = TrieNode()
            curr = curr.children[i]
        curr.endOfWord = True        

        

    def search(self, word: str) -> bool:
        def dfs(index, node):
            if index==len(word):
                return node.endOfWord

            c=word[index]

            if c!='.':
                if c not in node.children:
                    return False

                return dfs(index+1,node.children[c])

            for child in node.children.values():
                if dfs(index+1,child):
                    return True

            return False

        return dfs(0,self.root)        

        

class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)

        #Transpose
        for i in range(n):
            for j in range(i,n):
                temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp


        #Revrse
        for i in range(n):
            left =0
            right = n-1

            while left < right:
                temp = matrix[i][left]
                matrix[i][left] = matrix[i][right]
                matrix[i][right] = temp

                left+=1
                right-=1 

                   


        
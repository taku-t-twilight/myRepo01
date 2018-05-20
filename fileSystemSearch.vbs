Dim targetSheet As Worksheet
Dim rootFolderPath As String
Dim rowPosition As Long
Dim colPosition As Long
Dim targetThreshold As Long
Dim fso As Scripting.FileSystemObject

Sub listFolders()
  rootFolderPath = "C:\Users\Takumi\Documents"
  
  Set fso = New Scripting.FileSystemObject
  Set targetSheet = ThisWorkbook.Worksheets("sheet2")
  targetThreshold = CLng(10) * 1024 * 1024
    
  Call checkFolder(fso.GetFolder(rootFolderPath), 1, 1)
    
  Set fso = Nothing
  Set targetSheet = Nothing
End Sub

Sub checkFolder(currentFolder As Folder, rp As Long, cp As Long)
  Dim subFolders As Scripting.Folders
  Dim subFolder  As Scripting.Folder
  
  Dim folderSize As Double
  
  rowPosition = rp
    
  '再帰処理でcurrentFolderにNothingが渡った際の対処
  If currentFolder Is Nothing Then
    Return
  End If
  
  On Error Resume Next
  folderSize = currentFolder.Size
    
  targetSheet.Cells(rp, cp) = currentFolder.Name & "(" & currentFolder.Attributes & ")"
  
  
  If Err.Number <> 0 Then
    targetSheet.Cells(rp, cp + 1) = "Error:" & Err.Number
    Err.Clear
  Else
    targetSheet.Cells(rp, cp + 1) = folderSize
  End If
  
  If (folderSize > targetThreshold) Then
    targetSheet.Cells(rp, cp).Font.ColorIndex = 3
    targetSheet.Cells(rp, cp + 1).Font.ColorIndex = 3
  Else
    targetSheet.Cells(rp, cp).Font.ColorIndex = 0
    targetSheet.Cells(rp, cp + 1).Font.ColorIndex = 0
  End If
  
  Set subFolders = fso.GetFolder(currentFolder.Path).subFolders
  
  If subFolders.Count > 0 Then
    For Each subFolder In subFolders
      Call checkFolder(subFolder, rowPosition + 1, cp + 2)
    Next
  End If
  
  Set subFolder = Nothing
  Set subFolders = Nothing

End Sub


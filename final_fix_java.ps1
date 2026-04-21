# final_fix_java.ps1
$files = Get-ChildItem -Recurse -Filter *.java

foreach ($file in $files) {
    $relativePath = Resolve-Path $file.FullName -Relative
    $relativePath = $relativePath -replace "^\.\\", ""
    $dirName = [System.IO.Path]::GetDirectoryName($relativePath)
    $fileNameOnly = $file.BaseName
    
    $content = Get-Content $file.FullName -Raw
    
    # Remove existing package and imports to start fresh
    $content = $content -replace "(?m)^package\s+[\w\.]+;", ""
    $content = $content -replace "(?m)^import\s+java\.\w+\..*;", ""
    
    # 1. Package Declaration (MUST BE FIRST)
    $packageLine = ""
    if ($dirName -and $dirName -ne ".") {
        $packageName = $dirName -replace "\\", "."
        $packageLine = "package $packageName;`n`n"
    }
    
    # 2. Imports
    $importLines = "import java.util.*;`nimport java.io.*;`n`n"
    
    # 3. Fix class name (ensure it matches filename)
    if ($content -match "public\s+class\s+(\w+)") {
        $oldName = $Matches[1]
        if ($oldName -ne $fileNameOnly) {
            $content = $content -replace "public\s+class\s+$oldName", "public class $fileNameOnly"
        }
    } elseif ($content -match "class\s+(\w+)") {
        $oldName = $Matches[1]
        if ($oldName -ne $fileNameOnly) {
            $content = $content -replace "class\s+$oldName", "class $fileNameOnly"
        }
    }

    # 4. Handle ListNode if missing
    if ($content -match "ListNode" -and $content -notmatch "class ListNode") {
        $listNodeDef = "`nclass ListNode {`n    int val;`n    ListNode next;`n    ListNode() {}`n    ListNode(int val) { this.val = val; }`n    ListNode(int val, ListNode next) { this.val = val; this.next = next; }`n}`n"
        $content = $content + $listNodeDef
    }
    
    # 5. Handle TreeNode if missing (just in case)
    if ($content -match "TreeNode" -and $content -notmatch "class TreeNode") {
        $treeNodeDef = "`nclass TreeNode {`n    int val;`n    TreeNode left;`n    TreeNode right;`n    TreeNode() {}`n    TreeNode(int val) { this.val = val; }`n    TreeNode(int val, TreeNode left, TreeNode right) {`n        this.val = val;`n        this.left = left;`n        this.right = right;`n    }`n}`n"
        $content = $content + $treeNodeDef
    }

    # Combine everything
    # Clean up leading whitespace/newlines from content
    $content = $content.TrimStart()
    $finalContent = $packageLine + $importLines + $content
    
    Set-Content $file.FullName -Value $finalContent
}
Write-Host "All Java files corrected (Package first, then imports, then class definitions)."

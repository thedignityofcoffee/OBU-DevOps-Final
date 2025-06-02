param (
    [string]$directory_path,
    [int]$maximum_size
)

$file_list_path = "C:\Users\a13350632007\files.txt"

ls $directory_path | java .\FileFilter.java $maximum_size > $file_list_path

$big_files = cat $file_list_path
foreach ($file in $big_files) {
	cp $file $env:big_files_backup_path/
}

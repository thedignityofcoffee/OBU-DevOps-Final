directory_path=$1
maximum_size=$2

file_list_path="/Users/a13350632007/code/teaching/dops/week6-shell_scripting/big_files.txt"

ls -l $directory_path | java ./FileFilter.java $maximum_size > $file_list_path

big_files=$(cat $file_list_path)
for file in $big_files; do
    file_path=$directory_path/$file
    cp $file_path $big_files_backup_path/
done

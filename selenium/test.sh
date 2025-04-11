#!/usr/bin/bash
logfile="/home/coder/project/log.log"

#Removing Files
rm -rf /home/coder/project/workspace/Project/screenshots
rm -rf /home/coder/project/workspace/Project/logs
rm -rf /home/coder/project/workspace/Project/reports
rm -rf "$logfile"
touch "$logfile"

#Execution
cp /home/coder/project/workspace/selenium/EventHandler.java /home/coder/project/workspace/Project/src/test/java/utils/EventHandler.java
cd /home/coder/project/workspace/Project
mvn -q test
cp /home/coder/project/workspace/selenium/EventHandleDummy.java /home/coder/project/workspace/Project/src/test/java/utils/EventHandler.java

# Redirect all output to log file
exec > >(tee -a /home/coder/project/log.log)
exec 2>&1

check_directory_empty() {
    local directory=$1
    local name=$2
    if [ -d "$directory" ]; then
        echo $2 "-exists" 
    else
        echo $2 "-notexists" 
    fi
}

check_directory_log_extension(){
    log_directory="/home/coder/project/workspace/Project/logs"

    # Specify the year you want to check for
    target_year="2024"

    # Check if a log file with the specified year exists
    if find "$log_directory" -type f -name "*${target_year}*" | grep -q . ; then
        echo "Log -${target_year}" 
        # Add your further actions here
    else
        echo "Log file without ${target_year} "
        # Add your error handling or other actions here
    fi
}

check_directory_rep_extension(){
    rep_directory="/home/coder/project/workspace/Project/reports"

    # Specify the year you want to check for
    target_year="2024"

    # Check if a log file with the specified year exists
    if find "$rep_directory" -type f -name "*${target_year}*" | grep -q . ; then
        echo "Report -${target_year}" 
        # Add your further actions here
    else
        echo "Report file without ${target_year} "
        # Add your error handling or other actions here
    fi
}

check_directory_scr_extension(){
    scr_directory="/home/coder/project/workspace/Project/screenshots"

    # Specify the year you want to check for
    target_year="2024"

    # Check if a log file with the specified year exists
    if find "$scr_directory" -type f -name "*${target_year}*" | grep -q . ; then
        echo "Screenshot -${target_year}"
        # Add your further actions here
    else
        echo "Screenshot file without ${target_year} "
        # Add your error handling or other actions here
    fi
}



logfile=$(find /home/coder/project/workspace/Project/logs -type f -name "*.log" -print -quit)
line_count=0
 
# Check if the logfile exists
if [ -f "$logfile" ]; then
    line_count=$(wc -l < "$logfile")
    echo "Line count in log file: $line_count"  # Added line to print line_count
else
    echo "Logfile does not exist."
fi
 
# Proceed with comparison if line_count is valid
if [ "$line_count" -gt 5 ]; then
    echo "The log file with lines"
else
    echo "The log has 5 or fewer lines."
fi
 
 
 
# Check for "" in the log file
if grep -q "scroll down to footer" "$logfile"; then
    echo 'found in log file'
else
    echo 'not in log'
fi
 

 # Get today's date in YYYY-MM-DD format
today_date=$(date +"%Y.%m.%d")

# Check if the filename contains today's date and a year (four consecutive digits)
if [[ "$logfile" =~ [0-9]{4} && "$logfile" == *"$today_date"* ]]; then
    echo "log_timestamp"
else
    echo "no_timestamp"
fi

# Correct report file path
reportfile=$(find /home/coder/project/workspace/Project/reports -name "*.html" -print -quit)
 
 
# Check if the report file exists
if [ -f "$reportfile" ]; then
  
   
    # Count and display the number of lines in the report file
    echo "Number of lines in report:"
    line_count=$(wc -l < "$reportfile")
    echo "$line_count"
 
    # Check if the number of lines is greater than 300
    if [ "$line_count" -gt 311 ]; then
        echo "The report file with lines"
    else
        echo "The report file has 310 or fewer lines."
    fi
else
    echo "Report file does not exist."
fi
 
    # Check if "switch to new window" exists in the report
    if grep -q "switch to new window" "$reportfile"; then
        echo "found in report file"
    else
        echo "not in report"
    fi

# Get today's date in various formats
today_date=$(date +"%Y.%m.%d")

# Find the most recent PNG file based on modification time
recent_png=$(find /home/coder/project/workspace/Project/screenshots -type f -name "*.png" -print -quit)

if [[ -n "$recent_png" ]]; then
    echo "Most recent PNG file: $recent_png"
echo "$today_date"
    # Check if the filename contains today's date in any format
    if [[ "$recent_png" =~ $today_date ]]; then
        echo "screenshot_timestamp"
    else
        echo "The file name does not contain today's date in any format."
    fi
else
    echo "No PNG file found in the  folder."
fi



# Find the first HTML report file with scr in the reports directory
reportfile=$(find /home/coder/project/workspace/Project/reports -name "*.html" -print -quit)

# Check if the report file was found
if [[ -n "$reportfile" ]]; then
    # Search for any .png image file that contains "destination_guide" in its name
    if grep -qE 'src="[^"]*nykaa[^"]*\.png"' "$reportfile"; then
        echo "png is found in the report file"
    else
        echo "No image in report"
    fi
else
    echo "No report"
fi



logdir="/home/coder/project/workspace/Project/logs"
scrdir="/home/coder/project/workspace/Project/screenshots"
reportsdir="/home/coder/project/workspace/Project/reports"


check_directory_empty $logdir "log";
check_directory_empty $scrdir "scr";
check_directory_empty $reportsdir "report";
check_directory_log_extension $logdir "log";
check_directory_rep_extension $reportsdir "reports";
check_directory_scr_extension $scrdir "screenshots";

# Redirect all output to /dev/null
exec > /dev/null 2>&1

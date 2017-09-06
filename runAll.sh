#!/bin/bash - 
set -o nounset                              # Treat unset variables as an error

echo "" > PIDS
echo "" > killAll.sh

launchPayara(){
    
    WAR=${1:-"UNKNOWN"}
    PM_PATH=${2:-"/opt/payara/micro/173/payara-micro.jar"}
    
    if [ $WAR = "UNKNOWN" ]; then
        java -jar $PM_PATH --autobindhttp
        PID=$!
    else
        java -jar $PM_PATH --deploy $WAR/target/$WAR.war --autobindhttp 
        PID=$!
    fi
    
    echo "$WAR PID == $PID" >> PIDS
    echo "kill $PID" >> killAll.sh

}

launchPayara BossModule > logs/boss.out 2>&1 &
sleep 2
launchPayara LackeyModule > logs/lackey.out 2>&1 &
sleep 2
launchPayara SerfModule > logs/serf.out 2>&1 &
sleep 2
launchPayara DogsbodyModule > logs/dogsbody.out 2>&1 &
sleep 2
launchPayara > logs/solo.out 2>&1 &

pipeline{

 agent{
   docker{
          image "alpine"
   }
 }

 stages{
   stage('stage-1'){
            steps{
               sh "wget www.google.com"
            }
   }
 }

 post{
     always{
     archiveArtifacts artifacts: 'index.html', followSymlinks: false
     }

 }

}
job('Maven-Project-using-DSL') {
    description("Maven Project generated by the DSL ${new Date()}, its a small Maven Project hosted on github")
    scm {
        git("https://github.com/lloydzedds/Jenkins_Upgradev3.git", master)
    }
    triggers {
        scm('*/10 * * * *')
    }
    steps { 
        maven('clean package', 'maven-samples/single-module/pom.xml')
    }
    publishers {
        //archive the war file generated
        archiveArtifacts '**/*.jar'
    }
}